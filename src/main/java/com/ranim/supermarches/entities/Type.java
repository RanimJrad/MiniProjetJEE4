package com.ranim.supermarches.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idType;
	private String nomType;
	private String descriptionType;

	@OneToMany(mappedBy = "type")
	@JsonIgnore
	private List<Supermarche> supermarches;

	@Override
	public String toString() {
		return "Type [idType=" + idType + ", nomType=" + nomType + ", descriptionType=" + descriptionType + "]";
	}


}
