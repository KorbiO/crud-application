package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Fournisseur;
@RepositoryRestResource(collectionResourceRel = "Fournisseurs", path = "fournisseur")
public interface FournisseurRepository extends MongoRepository<Fournisseur,String>{

}
