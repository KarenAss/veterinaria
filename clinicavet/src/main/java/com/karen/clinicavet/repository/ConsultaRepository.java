package com.karen.clinicavet.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karen.clinicavet.domain.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Integer>{

	@Transactional
	@Modifying
	@Query("DELETE FROM Consulta WHERE cliente_id =id")
	void deleteFromIdCliente(@Param("cliente_id") Integer id);
}
