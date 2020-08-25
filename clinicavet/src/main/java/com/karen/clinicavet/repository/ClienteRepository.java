package com.karen.clinicavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karen.clinicavet.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Integer> {

}
