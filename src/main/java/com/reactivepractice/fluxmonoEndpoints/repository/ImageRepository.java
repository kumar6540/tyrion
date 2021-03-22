package com.reactivepractice.fluxmonoEndpoints.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactivepractice.fluxmonoEndpoints.Entity.Image;

import reactor.core.publisher.Mono;

@Repository
public interface ImageRepository extends ReactiveCrudRepository<Image, String> {

	Mono<Image> findByName(String name);
	
	
}
