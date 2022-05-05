package com.bezkoder.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_contribuyente")
public class Contribuyente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "estado")
    private boolean estado;

	//@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	//private Set<BookPublisher> bookPublishers;

	public Contribuyente()
	{
	}
	
	public Contribuyente( String nombre, boolean estado) {
	    this.nombre = nombre;
	    this.estado = estado;
	  }


	/*public Book(String name)
	{
		this.name = name;
		bookPublishers = new HashSet<>();
	}*/

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public boolean isEstado() {
	    return estado;
	 }

	 public void setEstado(boolean estado) {
	    this.estado = estado;
	 }

}


