package com.navi.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TollWays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "highway_code", unique = true)
    private String highwayCode;

    @Column(name = "price")
    private Double price;
    
 // getters and setters

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public TollWays(Long id, String highwayCode, Double price) {
		super();
		this.id = id;
		this.highwayCode = highwayCode;
		this.price = price;
	}

	public TollWays() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TollPrice [id=" + id + ", highwayCode=" + highwayCode + ", price=" + price + "]";
	}
	
	
	

    
    
    
}