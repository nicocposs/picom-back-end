package project.picom.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Tarif {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Digits(fraction = 2, integer = 7)
	private double prixEnEuros;
	@OneToOne
	
	private TrancheHoraire trancheHoraire;
	@OneToOne
	@JsonIgnore
	private Administrateur administrateur;
	@OneToOne
	
	private Zone zone;


}
