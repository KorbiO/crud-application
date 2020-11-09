package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Avis;

@RepositoryRestResource(collectionResourceRel = "Avis", path = "avis")
public interface  AvisRepository  extends MongoRepository<Avis, String>{

}
