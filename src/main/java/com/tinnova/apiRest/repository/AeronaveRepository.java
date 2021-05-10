package com.tinnova.apiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinnova.apiRest.model.Aeronave;

public interface AeronaveRepository extends JpaRepository<Aeronave, Integer>{

	Aeronave findById(int id);
}
