package com.karen.clinicavet.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karen.clinicavet.domain.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository <Endereco,Integer>{

	@Transactional
	@Modifying
	@Query("DELETE FROM Endereco e WHERE cliente_id =id")
	void deleteFromIdCliente(@Param("id") Integer id);
	
}
