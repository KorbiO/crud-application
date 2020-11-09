package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.LigneCommande;

@RepositoryRestResource(collectionResourceRel = "LingeCommandes", path = "lignecommande")
public interface LigneCommandeRepository extends MongoRepository<LigneCommande, String>{

}
