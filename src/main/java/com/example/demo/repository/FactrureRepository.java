package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Facture;

@RepositoryRestResource(collectionResourceRel = "Factures", path = "facture")
public interface FactrureRepository extends MongoRepository<Facture, String> {

}
