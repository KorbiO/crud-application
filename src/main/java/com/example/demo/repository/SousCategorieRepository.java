package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.SousCategorie;

 @RepositoryRestResource(collectionResourceRel = "SousCathegories", path = "souscategorie")

public interface SousCategorieRepository extends MongoRepository<SousCategorie, String> {

}
