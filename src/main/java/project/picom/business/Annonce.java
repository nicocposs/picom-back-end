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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dateHeureCreation;
	@NotNull(message = "Veuillez remplir le champ de date de début")
	private LocalDateTime dateHeureDebut;
	@NotNull(message = "Veuillez remplir le champ de date de fin")
	private LocalDateTime dateHeureFin;
	@NotBlank(message = "Veuillez remplir le champ de titre")
	private String titre;
	@NotBlank(message = "Veuillez remplir le contenu")
	private String contenu;
	@CreditCardNumber(message = "Veuillez entrer un code de carte correct")
	@Column(length=16)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String numeroCarte;
	@JsonProperty(access = Access.WRITE_ONLY)
	private int anneeExpiration;
	@Min(1)
	@Max(12)
	@JsonProperty(access = Access.WRITE_ONLY)
	private byte moisExpiration;
	@Length(min = 3, max = 3, message = "Veuillez entrer un code de sécurité correct")
	@Column(length=3)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String cryptogramme;
	@Digits(fraction = 2, integer = 7)
	private double montantRegleEnEuros;
	
	@ManyToOne
	@JsonIgnore
	private Client client;
	@ManyToMany(cascade = CascadeType.MERGE)
	@Size(min = 1, message = "Veuillez sélectionner au moins une zone")
	private List<Zone> zones;
	@ManyToMany(cascade = CascadeType.MERGE)
	@Size(min = 1, message = "Veuillez sélectionner au moins une tranche horaire")
	private List<TrancheHoraire> trancheHoraires;

	public Annonce(String titre, byte moisExpiration, LocalDateTime dateHeureDebut,LocalDateTime dateHeureFin){
		this.titre = titre;
		this.moisExpiration = moisExpiration;
		this.dateHeureDebut = dateHeureDebut;
		this.dateHeureFin = dateHeureFin;
	}
	
	public Annonce(String contenu, byte moisExpiration){
		this.contenu = contenu;
		this.moisExpiration = moisExpiration;

	}
}
