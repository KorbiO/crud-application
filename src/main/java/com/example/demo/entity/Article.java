package com.example.demo.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection  = "Article")
public class Article {
	@Id 
	private String id;
	private String mat;
	private int nbr;
	private String designtationArt;
	private String descriptionArt;
	private  double prixArt;
	private int qteStockArt;
	private double tauxRemiseArt;
	
	private Marque marqueArt; 
	 
	private SousCategorie sousCategorieArt;
	
	private Fournisseur fournisseurArt;
	
	private Avis avisArt ; 
	
	private String imageName;
//	private ImageModel imageModel ;
	private  double prixArtVF;
    private int qteStockArtVF;
    private Boolean isArtVF;	
	public String getId() {
		return this.mat;
	}

public void setMat(String mat) {
		
		this.mat=this.id;
	}
}
