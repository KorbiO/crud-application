package com.example.demo.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection  = "Client")
public class Client extends Utilisateur {
	

	private String cin; 
	private String address;
	private String phoneNumber;

}
