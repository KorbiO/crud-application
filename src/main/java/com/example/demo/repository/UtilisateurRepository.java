package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Utilisateur;


@RepositoryRestResource(collectionResourceRel = "Utilisateurs", path = "utilisateur")
public interface UtilisateurRepository  extends MongoRepository<Utilisateur, String>{

}
