package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.models.Documento;
import com.bezkoder.springjwt.repository.DocumentoRepository;

//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DocumentoController {

  @Autowired
  DocumentoRepository documentoRepository;

  @GetMapping("/documentos")
  public ResponseEntity<List<Documento>> getAllDocumentos(@RequestParam(required = false) String codigo) {
    List<Documento> documentos = new ArrayList<Documento>();

    if (codigo == null)
      documentoRepository.findAll().forEach(documentos::add);
    else
      documentoRepository.findByCodigoContaining(codigo).forEach(documentos::add);

    if (documentos.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(documentos, HttpStatus.OK);
  }

  @GetMapping("/documentos/{id}")
  public ResponseEntity<Documento> getDocumentoById(@PathVariable("id") int id) {
    Documento documento = documentoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

    return new ResponseEntity<>(documento, HttpStatus.OK);
  }

  @PostMapping("/documentos")
  public ResponseEntity<Documento> createDocumento(@RequestBody Documento documento) {
	Documento _documento = documentoRepository.save(new Documento(documento.getCodigo(), documento.getNombre(), documento.getDescripcion(), true));
    return new ResponseEntity<>(_documento, HttpStatus.CREATED);
  }

  @PutMapping("/documentos/{id}")
  public ResponseEntity<Documento> updateDocumento(@PathVariable("id") int id, @RequestBody Documento documento) {
    Documento _documento = documentoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

    _documento.setCodigo(documento.getCodigo());
    _documento.setNombre(documento.getNombre());
    _documento.setDescripcion(documento.getDescripcion());
   // _documento.setEstado(documento.isEstado());
    
    return new ResponseEntity<>(documentoRepository.save(_documento), HttpStatus.OK);
  }

  @DeleteMapping("/documentos/{id}")
  public ResponseEntity<HttpStatus> deleteDocumento(@PathVariable("id") int id) {
    documentoRepository.deleteById(id);
    
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

