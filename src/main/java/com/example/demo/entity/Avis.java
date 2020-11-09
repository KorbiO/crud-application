package com.example.demo.entity;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Avis")
public class Avis {
	@Id
	private String idAvis ;
	private String avis ; 
	private LocalDate dateAvis; 
	
	private Client client;
	

}
