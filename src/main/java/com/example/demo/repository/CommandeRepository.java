package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.demo.entity.Commande;

@RepositoryRestResource(collectionResourceRel = "Commandes", path = "commande")
public interface CommandeRepository extends MongoRepository<Commande, String> {

}
