package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Administrateur;


@RepositoryRestResource(collectionResourceRel = "Administrateurs", path = "admin")
public interface  AdministrateurRepository extends MongoRepository<Administrateur, String> {

}
