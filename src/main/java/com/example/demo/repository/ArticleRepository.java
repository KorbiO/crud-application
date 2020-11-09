package com.example.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.demo.entity.Article;

@RepositoryRestResource(collectionResourceRel = "Articles", path = "article")
public interface ArticleRepository extends MongoRepository<Article, String> {

	
	
}
