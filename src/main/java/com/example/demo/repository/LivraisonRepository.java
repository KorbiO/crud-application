package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Livraison;

@RepositoryRestResource(collectionResourceRel = "Livraisons", path = "livraison")
public interface LivraisonRepository extends MongoRepository<Livraison, String>{

}
