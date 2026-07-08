package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Query method - finds countries whose name contains the given text
    // (case-insensitive partial match)
    List<Country> findByNameContainingIgnoreCase(String partialName);

}
