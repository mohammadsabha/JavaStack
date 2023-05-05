package com.sabha.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sabha.demo.models.Travels;

@Repository
public interface TravelsRepository extends CrudRepository<Travels, Long> {
	// this method retrieves all the travels from the database
    List<Travels> findAll();
    void deleteById(Long id);
    Optional<Travels> findById(Long id);
}
