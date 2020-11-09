package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "Vente Flash")
public class VenteFlash {
	
	@Id
	private String id;
	private String mat;
	private LocalDateTime dateDebVF;
	private LocalDateTime dateFinVF;
	
	public String getId() {
		return this.mat;
	}
	public void setMat(String mat) {
		this.mat = this.id;
		
	}
	
	 private List<Article> articleVenteFlash;
	
}
