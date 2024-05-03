package com.ranim.supermarches.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Supermarche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSupermarche;
	
	@NotNull
	@Size (min = 2,max = 30)
	private String nomSupermarche;
	
	@Min(value = 3)
	@Max(value = 200)
	private int nbEmployee;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateConstruction;
	
	@ManyToOne
	private Type type;

	public Supermarche() {
		super();
	}

	public Supermarche(String nomSupermarche, int nbEmployee, Date dateConstruction) {
		super();
		this.nomSupermarche = nomSupermarche;
		this.nbEmployee = nbEmployee;
		this.dateConstruction = dateConstruction;
	}

	public Long getIdSupermarche() {
		return idSupermarche;
	}

	public void setIdSupermarche(Long idSupermarche) {
		this.idSupermarche = idSupermarche;
	}

	public String getNomSupermarche() {
		return nomSupermarche;
	}

	public void setNomSupermarche(String nomSupermarche) {
		this.nomSupermarche = nomSupermarche;
	}

	
	

	public int getNbEmployee() {
		return nbEmployee;
	}

	public void setNbEmployee(int nbEmployee) {
		this.nbEmployee = nbEmployee;
	}

	public Date getDateConstruction() {
		return dateConstruction;
	}

	public void setDateConstruction(Date dateConstruction) {
		this.dateConstruction = dateConstruction;
	}

	
	@Override
	public String toString() {
		return "Supermarche [idSupermarche=" + idSupermarche + ", nomSupermarche=" + nomSupermarche + ", nbEmployee="
				+ nbEmployee + ", dateConstruction=" + dateConstruction + "]";
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
