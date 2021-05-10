package com.tinnova.apiRest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.sun.istack.NotNull;

@Entity
public class Aeronave {

	
	private int id;
	private String nome;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
	private Date created;
	private Date updated;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@NotNull
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull
	public String getMarca() {
		return marca;
	}

	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@NotNull
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	@NotNull
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@NotNull
	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeronave other = (Aeronave) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
