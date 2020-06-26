package com.vs.reactive.reactiveMongo.persistence.repositories;

import com.vs.reactive.reactiveMongo.persistence.entity.Profile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {
    Flux<Profile> findByEmail(String email);
}
