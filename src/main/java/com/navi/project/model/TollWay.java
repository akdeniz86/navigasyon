package com.navi.project.model;

import jakarta.persistence.*;
import java.awt.Point;

@Entity
public class TollWay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String highwayCode;

    private String highwayName;
    
    @Column(name = "gate_a_name")
    private String gateAName;    

	 @Column(columnDefinition = "geometry(Point,4326)", nullable = false, name = "gate_a_point")
    private Point gateAPoint;

    
    @Column(name = "gate_b_name")
    private String gateBName;

	 @Column(columnDefinition = "geometry(Point,4326)", nullable = false, name = "gate_b_point")
    private Point gateBPoint;

    private Double fee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHighwayCode() {
		return highwayCode;
	}

	public void setHighwayCode(String highwayCode) {
		this.highwayCode = highwayCode;
	}

	public String getHighwayName() {
		return highwayName;
	}

	public void setHighwayName(String highwayName) {
		this.highwayName = highwayName;
	}

	public String getGateAName() {
		return gateAName;
	}

	public void setGateAName(String gateAName) {
		this.gateAName = gateAName;
	}

	public Point getGateAPoint() {
		return gateAPoint;
	}

	public void setGateAPoint(Point gateAPoint) {
		this.gateAPoint = gateAPoint;
	}

	public String getGateBName() {
		return gateBName;
	}

	public void setGateBName(String gateBName) {
		this.gateBName = gateBName;
	}

	public Point getGateBPoint() {
		return gateBPoint;
	}

	public void setGateBPoint(Point gateBPoint) {
		this.gateBPoint = gateBPoint;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}
    
	

}
