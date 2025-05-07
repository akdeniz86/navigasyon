package com.navi.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TollBridgesRepository extends JpaRepository<com.navi.project.model.TollBridges, Long> {
	

	
	@Query(value = "SELECT name, price FROM toll_bridges WHERE ST_Distance_Sphere(location, ST_GeomFromText(:point)) < :distance", nativeQuery = true)
	List<Object[]> findNearbyBridges(@Param("point") String point, @Param("distance") double distance);




}