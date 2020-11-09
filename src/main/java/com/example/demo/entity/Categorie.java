package com.example.demo.entity;

import java.util.Collection;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Categorie")

public class Categorie {
	
	@Id
	private String idCat;
	private String mat;
	private String libelleCat;
	
	
	public String getIdCat() {
		return this.mat;
	}

public void setMat(String mat) {
		
		this.mat=this.idCat;
	}
}
