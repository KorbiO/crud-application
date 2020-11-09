package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.demo.entity.Client;


@RepositoryRestResource(collectionResourceRel = "Clients", path = "client")
public interface ClientRepository extends MongoRepository<Client, String> {

}
