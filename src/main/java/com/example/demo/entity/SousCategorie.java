package com.example.demo.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document (collection = "Sous Categorie")
@AllArgsConstructor @NoArgsConstructor
public class SousCategorie {
	
	@Id
	private String idSousCat;
	private String mat;
	private String libelleSousCat;
	private List <String> valeur ; 
	
	private Categorie categorie; 
	
	public String getIdSousCat() {
		return this.mat;
	}
public void setMat(String mat) {
		
		this.mat=this.idSousCat;
	}
}
