package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Contribuyente;
import com.bezkoder.springjwt.models.Documento;

public interface ContribuyenteRepository extends JpaRepository<Contribuyente, Integer>{
	 List<Contribuyente> findByEstado(boolean estado);

	 List<Contribuyente> findByNombreContaining(String nombre);

}
