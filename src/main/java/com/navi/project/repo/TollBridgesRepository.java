package com.navi.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.navi.project.model.TollBridges;
public interface TollBridgesRepository extends JpaRepository<TollBridges, Long> {
	
	@Query(value = """
		    SELECT name, price
		    FROM toll_bridges
		    WHERE ST_DWithin(
		        location::geography,
		        ST_GeomFromText(:lineStringWkt, 4326)::geography,
		        :distance
		    )
		""", nativeQuery = true)


		List<Object[]> findNearbyBridges(@Param("lineStringWkt") String lineStringWkt, 
		                                @Param("distance") double distance);

}