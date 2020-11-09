package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Reclamation")
public class Reclamation {
	
	@Id
	private String idRec;
	private String reclamation ; 
	private LocalDate dateRec;
	
	private Commande commandeRec;

}
