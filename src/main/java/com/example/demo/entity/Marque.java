package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Marque")
public class Marque {
	@Id
	private String idMarq;
	private String mat;
	
	private String libelleMarq;
	
	public String getIdMarq() {
		return this.mat;
	}
	public void setMat(String mat) {
		this.mat = this.idMarq;
		
	} 
	
}
