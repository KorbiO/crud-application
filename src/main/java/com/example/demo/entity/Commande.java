package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection  = "Commande")
public class Commande {
	
	@Id
	private String idCmd; 
	private String mat ;
	private LocalDateTime dateCmd; 
	private double totalCmd; 
	private String modePaiement;
	
	private List<LigneCommande> ligneCmd ; 
	
	private Client clientCmd;
	
	private LigneLivraison ligneLivraisonCmd;

	public String getIdCmd() {
		return this.mat;
	}

public void setMat(String mat) {
		
		this.mat=this.idCmd;
	}
}
