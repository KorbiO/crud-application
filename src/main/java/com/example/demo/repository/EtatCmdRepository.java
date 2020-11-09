package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.EtatCmd;

@RepositoryRestResource(collectionResourceRel = "EtatCmds", path = "etatCmd")
public interface EtatCmdRepository extends MongoRepository<EtatCmd, String> {

}
