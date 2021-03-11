package com.rest.RestApiServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.RestApiServices.entity.Knownlanguages;

@Repository
public interface KnownlanguagesRepository extends JpaRepository<Knownlanguages, Integer> {

}
