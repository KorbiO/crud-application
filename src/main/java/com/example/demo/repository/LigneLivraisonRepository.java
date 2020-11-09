package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.demo.entity.LigneLivraison;

@RepositoryRestResource(collectionResourceRel = "ligneLivs", path = "ligneliv")
public interface  LigneLivraisonRepository extends  MongoRepository<LigneLivraison, String> {

}
