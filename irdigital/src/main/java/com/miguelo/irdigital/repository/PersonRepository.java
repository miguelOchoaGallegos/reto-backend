package com.miguelo.irdigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelo.irdigital.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>  {}
