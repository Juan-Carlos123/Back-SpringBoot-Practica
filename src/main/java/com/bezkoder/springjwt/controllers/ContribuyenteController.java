package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.models.Contribuyente;
import com.bezkoder.springjwt.repository.ContribuyenteRepository;


//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ContribuyenteController {

@Autowired
ContribuyenteRepository contribuyenteRepository;

@GetMapping("/contribuyentes")
public ResponseEntity<List<Contribuyente>> getAllContribuyentes(@RequestParam(required = false) String nombre) {
  List<Contribuyente> contribuyentes = new ArrayList<Contribuyente>();

  if (nombre == null)
	  contribuyenteRepository.findAll().forEach(contribuyentes::add);
  else
	  contribuyenteRepository.findByNombreContaining(nombre).forEach(contribuyentes::add);

  if (contribuyentes.isEmpty()) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  return new ResponseEntity<>(contribuyentes, HttpStatus.OK);
}

@GetMapping("/contribuyentes/{id}")
public ResponseEntity<Contribuyente> getContribuyenteById(@PathVariable("id") int id) {
	Contribuyente contribuyente = contribuyenteRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

  return new ResponseEntity<>(contribuyente, HttpStatus.OK);
}

@PostMapping("/contribuyentes")
public ResponseEntity<Contribuyente> createContribuyente(@RequestBody Contribuyente contribuyente) {
	Contribuyente _contribuyente = contribuyenteRepository.save(new Contribuyente(contribuyente.getNombre(), true));
  return new ResponseEntity<>(_contribuyente, HttpStatus.CREATED);
}

@PutMapping("/contribuyentes/{id}")
public ResponseEntity<Contribuyente> updateContribuyente(@PathVariable("id") int id, @RequestBody Contribuyente contribuyente) {
	Contribuyente _contribuyente = contribuyenteRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

  _contribuyente.setNombre(contribuyente.getNombre());
 // _documento.setEstado(documento.isEstado());
  
  return new ResponseEntity<>(contribuyenteRepository.save(_contribuyente), HttpStatus.OK);
}

@DeleteMapping("/contribuyentes/{id}")
public ResponseEntity<HttpStatus> deleteContribuyente(@PathVariable("id") int id) {
	contribuyenteRepository.deleteById(id);
  
  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

/*@DeleteMapping("/tutorials")
public ResponseEntity<HttpStatus> deleteAllTutorials() {
  tutorialRepository.deleteAll();
  
  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@GetMapping("/tutorials/published")
public ResponseEntity<List<Tutorial>> findByPublished() {
  List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

  if (tutorials.isEmpty()) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
  return new ResponseEntity<>(tutorials, HttpStatus.OK);
}*/
}
