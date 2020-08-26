package com.karen.clinicavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karen.clinicavet.domain.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Integer>{

}
