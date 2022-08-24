package project.picom.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
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
	private Administrateur administrateur;
	@OneToOne
	private Zone zone;

}
