package com.example.demo.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Administrateur")
public class Administrateur extends Utilisateur {
	
	
	

}
