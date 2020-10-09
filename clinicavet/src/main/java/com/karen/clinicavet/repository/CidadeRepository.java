package com.karen.clinicavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karen.clinicavet.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository <Cidade,Integer>{



}
