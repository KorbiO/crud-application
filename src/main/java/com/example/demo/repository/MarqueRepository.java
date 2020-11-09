package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.demo.entity.Marque;

@RepositoryRestResource(collectionResourceRel = "Marques", path = "marque")
public interface MarqueRepository extends MongoRepository<Marque, String> {

}
