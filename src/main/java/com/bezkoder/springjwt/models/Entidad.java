package com.bezkoder.springjwt.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_entidad")
public class Entidad implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_tipo_documento")
	private Documento documento;
	//private int id_tipo_documento;

	@ManyToOne
	@JoinColumn(name = "id_tipo_contribuyente")
	private Contribuyente contribuyente;
	//private int id_tipo_contribuyente;

	@Column(name = "nro_documento")
	private String nro_documento;
	
	@Column(name = "razon_social")
	private String razon_social;
	
	@Column(name = "nombre_comercial")
	private String nombre_comercial;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "estado")
	private boolean estado;
	
	public Entidad( Documento documento, Contribuyente contribuyente, String nro_documento, String razon_social, String nombre_comercial, 
			String direccion, String telefono, boolean estado) {
		
		this.documento = documento;
		this.contribuyente = contribuyente;
	    this.nro_documento = nro_documento;
	    this.razon_social = razon_social;
	    this.nombre_comercial = nombre_comercial;
	    this.direccion = direccion;
	    this.telefono = telefono;
	    this.estado = estado;
	   
	}
	

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Documento getDocumento()
	{
		return documento;
	}

	public void setDocumento(Documento documento)
	{
		this.documento = documento;
	}

	public Contribuyente getContribuyente()
	{
		return contribuyente;
	}

	public void setContribuyente(Contribuyente contribuyente)
	{
		this.contribuyente = contribuyente;
	}

	public String getNro_documento()
	{
		return nro_documento;
	}

	public void setNro_documento(String nro_documento)
	{
		this.nro_documento = nro_documento;
	}
	
	public String getRazon_social()
	{
		return razon_social;
	}
	
	public void setRazon_social(String razon_social)
	{
		this.razon_social = razon_social;
	}
	
	public String getNombre_comercial()
	{
		return nombre_comercial;
	}
	
	public void setNombre_comercial(String nombre_comercial)
	{
		this.nombre_comercial = nombre_comercial;
	}
	
	public String getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public String getTelefono()
	{
		return telefono;
	}
	
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public boolean isEstado() {
	    return estado;
	 }

	 public void setEstado(boolean estado) {
	    this.estado = estado;
	 }
}
