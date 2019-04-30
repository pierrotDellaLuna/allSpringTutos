package ictcg.com.repository;



import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import ictcg.com.entities.Societes;

public interface SocieteRepository extends ReactiveMongoRepository<Societes , String> {

}
