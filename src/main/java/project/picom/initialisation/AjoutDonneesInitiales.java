package project.picom.initialisation;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import project.picom.business.Administrateur;
import project.picom.business.Annonce;
import project.picom.business.Arret;
import project.picom.business.Client;
import project.picom.business.TrancheHoraire;
import project.picom.business.Zone;
import project.picom.service.AnnonceService;
import project.picom.service.ArretService;
import project.picom.service.TrancheHoraireService;
import project.picom.service.UtilisateurService;
import project.picom.service.ZoneService;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner{

    private final ZoneService zoneService;
    private final ArretService arretService;
    private final TrancheHoraireService trancheHoraireService;
    private final UtilisateurService utilisateurService;
    private final AnnonceService annonceService;

    @Override
    public void run(String... args) throws Exception {
        ajoutZones();
        ajoutArrets();
        ajoutTranchesHoraires();
        ajoutClient();
        ajoutAdmin();
        ajoutAnnonces();
    }

    public void ajoutZones(){
        zoneService.addZone(new Zone("Zone 1"));
        zoneService.addZone(new Zone("Zone 2"));
        zoneService.addZone(new Zone("Zone 3"));
        zoneService.addZone(new Zone("Zone 4"));
        zoneService.addZone(new Zone("Zone 5"));
    }

    public void ajoutArrets(){
        for(int i = 1; i <= 5; i++) {
            Zone z = zoneService.getZone(i);
            for(int j = 1; j <= 4; j++) {
                Arret a = new Arret("Arret " + j, 1.0d,1.0d);
                a.setZone(z);
                arretService.addArret(a);
            }
        }
    }

    public void ajoutTranchesHoraires(){
        for(int i = 0; i<14; i++){
            TrancheHoraire th = new TrancheHoraire(i);
            trancheHoraireService.addTrancheHoraire(th);
        }
    }

    public void ajoutClient(){
        Client c = new Client("Client","TropBien","client1@orsys.fr","12345678","0600000000");
        utilisateurService.addClient(c);
    }

    public void ajoutAdmin(){
        Administrateur a = new Administrateur("Admin","TropBien","admin1@orsys.fr","12345678");
        utilisateurService.addAdministrateur(a);
    }

    public void ajoutAnnonces(){
        Annonce a1 = new Annonce("Annonce 1",(byte)1,LocalDateTime.of(2022, 8, 24, 17, 0, 0),LocalDateTime.of(2022, 8, 25, 17,0,0));
        Client c = utilisateurService.getClient(1);
        a1.setClient(c);
        Annonce a2 = new Annonce("Annonce 2",(byte)1,LocalDateTime.of(2022, 9, 12, 17, 0, 0),LocalDateTime.of(2022, 9, 15, 17, 0, 0));
        a2.setClient(c);
        annonceService.addAnnonce(a1);
        annonceService.addAnnonce(a2);
    }
    
}
