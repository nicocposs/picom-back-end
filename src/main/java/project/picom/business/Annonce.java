package project.picom.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dateHeureCreation;
	private LocalDateTime dateHeureDebut;
	private LocalDateTime dateHeureFin;
	private String contenu;
	@CreditCardNumber 
	@Column(length=16)
	private String numeroCarte;
	private int anneeExpiration;
	@Min(1)
	@Max(12)
	private byte moisExpiration;
	@Length(min = 3, max = 3)
	@Column(length=3)
	private String cryptogramme;
	@Digits(fraction = 2, integer = 7)
	private double montantRegleEnEuros;
	
	@ManyToOne
	private Client client;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "annonces")
	private List<Zone> zones;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "annonces")
	private List<TrancheHoraire> trancheHoraires;
}
