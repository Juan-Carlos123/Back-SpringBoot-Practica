package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Documento;



public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
	  List<Documento> findByEstado(boolean estado);

	  List<Documento> findByCodigoContaining(String codigo);
	  
	  //List<Documento> findDocumentosByContribuyenteId(Long tagId);
}





