package com.navi.project.dto;



public class TollWayDto {
    private Long id;
    private String highwayCode;
    private String highwayName;
    private String gateAName;
    private String gateBName;
    private double fee;
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
	public String getGateBName() {
		return gateBName;
	}
	public void setGateBName(String gateBName) {
		this.gateBName = gateBName;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public TollWayDto(Long id, String highwayCode, String highwayName, String gateAName, String gateBName, double fee) {
		super();
		this.id = id;
		this.highwayCode = highwayCode;
		this.highwayName = highwayName;
		this.gateAName = gateAName;
		this.gateBName = gateBName;
		this.fee = fee;
	}
    
    

}
