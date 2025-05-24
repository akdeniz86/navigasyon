package com.navi.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.navi.project.dto.TollWayDto;
import com.navi.project.model.TollWay;

public interface TollWayRepository extends JpaRepository<TollWay, Long>{
	
	
	@Query(value = """
		    SELECT 
		        id, 
		        highway_code AS highwayCode, 
		        highway_name AS highwayName, 
		        gate_a_name AS gateAName, 
		        gate_b_name AS gateBName, 		       
		        fee
		    FROM toll_way
		    WHERE ST_DWithin(
		        gate_a_point::geography,
		        ST_GeomFromText(:lineStringWkt, 4326)::geography,
		        :distance
		    )
		""", nativeQuery = true)
		List<TollWayDto> findByGateAPoint(@Param("lineStringWkt") String lineStringWkt,
		                                  @Param("distance") double distance);


		@Query(value = """
		    SELECT 
		        id, 
		        highway_code AS highwayCode, 
		        highway_name AS highwayName, 
		        gate_a_name AS gateAName, 
		        gate_b_name AS gateBName, 
		     
		        fee
		    FROM toll_way
		    WHERE ST_DWithin(
		        gate_b_point::geography,
		        ST_GeomFromText(:lineStringWkt, 4326)::geography,
		        :distance
		    )
		""", nativeQuery = true)
		List<TollWayDto> findByGateBPoint(@Param("lineStringWkt") String lineStringWkt,
		                                  @Param("distance") double distance);


}
