package com.navi.project.model;

import jakarta.persistence.*;
import org.locationtech.jts.geom.LineString;

@Entity
@Table(name = "roads")
public class Roads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String code;

    @Column(columnDefinition = "LINESTRING", nullable = false)
    private LineString geom;
    
    // Getter ve Setter'lar

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LineString getGeom() {
		return geom;
	}

	public void setGeom(LineString geom) {
		this.geom = geom;
	}

	public Roads(Long id, String name, Double price, String code, LineString geom) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.code = code;
		this.geom = geom;
	}


    
    


}