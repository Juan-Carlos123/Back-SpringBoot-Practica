package com.bezkoder.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_documento")
public class Documento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "codigo")
	private String codigo;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private boolean estado;

	//@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	//private Set<BookPublisher> bookPublishers;

	public Documento()
	{
	}
	
	public Documento(String codigo, String nombre, String descripcion, boolean estado) {
	    this.codigo = codigo;
	    this.nombre = nombre;
	    this.descripcion = descripcion;
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

	public String getCodigo()
	{
		return codigo;
	}
	
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	public boolean isEstado() {
	    return estado;
	 }

	 public void setEstado(boolean estado) {
	    this.estado = estado;
	 }
	 
	 @Override
	  public String toString() {
	    return "Documento [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	  }

}
