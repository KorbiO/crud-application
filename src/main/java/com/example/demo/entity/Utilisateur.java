package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Data
@Document(collection ="Utilisateur" )
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Utilisateur {
	@Id
	private String id;
	private String mat;
	private String username ; 
	private String password ; 
	private String nom;
	private String prenom;
	private String role; 
	
	 private String confirmedPassword; 
	public String getId() {
		return this.mat;
	}
	public void setMat(String mat) {
		
		this.mat=this.id;
	}

}
