package com.karen.clinicavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karen.clinicavet.domain.MedicoVeterinario;

@Repository
public interface MedicoVeterinarioRepository extends JpaRepository <MedicoVeterinario, Integer>{

}
