package com.example.demo.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.demo.entity.Categorie;


@RepositoryRestResource(collectionResourceRel = "Categories", path = "categorie")

public interface CategorieRepository extends MongoRepository<Categorie, String> {

}
