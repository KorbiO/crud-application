package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Livraison")
public class Livraison {
	
	@Id
	private String idLiv;
	private String modeLiv ; 
	private String mat ;
	
	public String getIdLiv() {
		return this.mat;
	}

public void setMat(String mat) {
		
		this.mat=this.idLiv;
	}
}
