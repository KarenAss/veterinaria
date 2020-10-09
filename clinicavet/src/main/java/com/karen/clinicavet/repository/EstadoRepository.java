package com.karen.clinicavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karen.clinicavet.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository <Estado,Integer>{

}
