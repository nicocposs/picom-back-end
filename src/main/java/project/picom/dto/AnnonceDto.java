package project.picom.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class AnnonceDto {
	LocalDateTime dateHeureDebut;
	LocalDateTime dateHeureFin;
	String titre;
	String contenu;
	String numeroCarte;
	int anneeExpiration;
	byte moisExpiration;
	String cryptogramme;
	double montantRegleEnEuros;
	
	Long clientId;
	List<Long> zonesIds;
	List<Long> trancheHorairesIds;
}
