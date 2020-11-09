package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.ImageModel;

@RepositoryRestResource(path = "image")
public interface ImageRepository extends MongoRepository <ImageModel , String>{
	
	Optional<ImageModel> findByName(String name);

}
