package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Reclamation;

@RepositoryRestResource(collectionResourceRel = "Reclamations", path = "reclamation")
public interface ReclamationRepository extends MongoRepository<Reclamation, String>{

}
