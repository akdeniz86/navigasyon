package com.navi.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.navi.project.model.Roads;

public interface RoadsRepository extends JpaRepository<Roads, Long> {
//	@Query(value = """
//		    SELECT SUM(ST_Length_Sphere(
//		        ST_Intersection(geom, ST_GeomFromText(:wkt, 4326))
//		    ))
//		    FROM roads
//		    WHERE ST_Intersects(geom, ST_GeomFromText(:wkt, 4326))
//		    """, nativeQuery = true)
//		Double getTotalIntersectLength(@Param("wkt") String wkt);
	
	
	@Query(value = """
		    SELECT SUM(ST_Length(
		        ST_Intersection(geom, ST_GeomFromText(:wkt, 4326))
		    )) * 111195
		    FROM roads
		    WHERE ST_Intersects(geom, ST_GeomFromText(:wkt, 4326))
		    """, nativeQuery = true)
		Double getApproxIntersectLengthMeters(@Param("wkt") String wkt);



}
