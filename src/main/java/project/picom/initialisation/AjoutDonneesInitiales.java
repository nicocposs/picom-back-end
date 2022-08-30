package project.picom.initialisation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import project.picom.business.Administrateur;
import project.picom.business.Annonce;
import project.picom.business.Arret;
import project.picom.business.Client;
import project.picom.business.Tarif;
import project.picom.business.TrancheHoraire;
import project.picom.business.Zone;
import project.picom.dao.AdministrateurDao;
import project.picom.dao.AnnonceDao;
import project.picom.dao.ArretDao;
import project.picom.dao.TarifDao;
import project.picom.dao.TrancheHoraireDao;
import project.picom.dao.UtilisateurDao;
import project.picom.dao.ZoneDao;
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
    private final TarifDao tarifDao;
    private final TrancheHoraireDao trancheHoraireDao;
    private final ZoneDao zoneDao;
    private final AdministrateurDao administrateurDao;
    private final ArretDao arretDao;
    private final UtilisateurDao utilisateurDao;
    private final AnnonceDao annonceDao;

    @Override
    public void run(String... args) throws Exception {
        ajoutZones();
        ajoutArrets();
        ajoutTranchesHoraires();
        ajoutUtilisateurs();
        ajoutAnnonces();
        ajouterTarif(2);
    }

    public void ajoutZones(){
        if(zoneService.recupererZones().isEmpty()){
            zoneService.addZone(new Zone("Zone 1"));
            zoneService.addZone(new Zone("Zone 2"));
            zoneService.addZone(new Zone("Zone 3"));
            zoneService.addZone(new Zone("Zone 4"));
            zoneService.addZone(new Zone("Zone 5"));
        }
    }
 
    public void ajoutArrets(){
        if(arretDao.count() == 0){
            for(int i = 1; i <= 5; i++) {
                Zone z = zoneService.getZone(i);
                for(int j = 1; j <= 4; j++) {
                    Arret a = new Arret("Arret " + j, 1.0d,1.0d);
                    a.setZone(z);
                    arretService.addArret(a);
                }
            }
        }
    }

    public void ajoutTranchesHoraires(){
        if(trancheHoraireService.recupererTranches().isEmpty()){
            TrancheHoraire th = new TrancheHoraire(7);
            trancheHoraireService.addTrancheHoraire(th);
            TrancheHoraire th2 = new TrancheHoraire(12);
            trancheHoraireService.addTrancheHoraire(th2);
            TrancheHoraire th3 = new TrancheHoraire(15);
            trancheHoraireService.addTrancheHoraire(th3);
        }
        
    }

    private void ajouterTarif(long idAdmin) {
        if (tarifDao.count() == 0) {
            for (TrancheHoraire t : trancheHoraireDao.findAll()) {
                double budget = 100.0;
                for (Zone z : zoneDao.findAll()) {
                    Tarif tarif = new Tarif();
                    tarif.setPrixEnEuros(budget);
                    tarif.setTrancheHoraire(t);
                    Optional<Zone> z2 = zoneDao.findById(z.getId());
                    if(z2.isPresent()){
                        tarif.setZone(z2.get());
                    }
                    Optional<Administrateur> a = administrateurDao.findById(idAdmin);
                    if(a.isPresent()){
                        tarif.setAdministrateur(a.get());
                    }
                    tarifDao.save(tarif);
                    if (t.getId() % 2L == 0){
                        budget -= 20.0;
                    }
                    else {
                        budget -= 10.0;
                    }
                    
                }
            }
        }
    }

    public void ajoutUtilisateurs(){
        if(utilisateurDao.count() == 0){
            Client c = new Client("Client","TropBien","client1@orsys.fr","12345678","0660091761");
            utilisateurService.addClient(c);
            Administrateur a = new Administrateur("Admin","TropBien","admin1@orsys.fr","12345678");
            utilisateurService.addAdministrateur(a);
        }
    }

    public void ajoutAnnonces(){
        if(annonceDao.count() == 0){
            Annonce a1 = new Annonce();
            Client c = utilisateurService.getClient(1L);
            a1.setAnneeExpiration(2023);
            a1.setClient(c);
            a1.setContenu("<b>Bonjour</b>");
            a1.setCryptogramme("123");
            a1.setDateHeureCreation(LocalDateTime.now());
            a1.setDateHeureDebut(LocalDateTime.now().plusDays(10));
            a1.setDateHeureFin(LocalDateTime.now().plusDays(15));
            a1.setMoisExpiration((byte)1);
            a1.setMontantRegleEnEuros(100.0d);
            a1.setNumeroCarte("5555555555554444");
            a1.setTitre("Annonce 1");
            List<TrancheHoraire> tranches = new ArrayList<>();
            Optional<TrancheHoraire> t1 = trancheHoraireDao.findById(1L);
            Optional<TrancheHoraire> t2 = trancheHoraireDao.findById(2L);
            if(t1.isPresent()) tranches.add(t1.get());
            if(t2.isPresent()) tranches.add(t2.get());
            a1.setTrancheHoraires(tranches);
            List<Zone> zones = new ArrayList<>();
            Optional<Zone> z1 = zoneDao.findById(1L);
            Optional<Zone> z2 = zoneDao.findById(2L);
            if(z1.isPresent()) zones.add(z1.get());
            if(z2.isPresent()) zones.add(z2.get());
            System.out.println(zones);
            a1.setZones(zones);
            Annonce a2 = new Annonce("Annonce 2",(byte)1,LocalDateTime.of(2022, 9, 12, 17, 0, 0),LocalDateTime.of(2022, 9, 15, 17, 0, 0));
            a2.setAnneeExpiration(2026);
            a2.setClient(c);
            a2.setContenu("<b>Bonjour</b>");
            a2.setCryptogramme("234");
            a2.setDateHeureCreation(LocalDateTime.now());
            a2.setDateHeureDebut(LocalDateTime.now().minusDays(15));
            a2.setDateHeureFin(LocalDateTime.now().minusDays(10));
            a2.setMoisExpiration((byte)1);
            a2.setMontantRegleEnEuros(100.0d);
            a2.setNumeroCarte("5555555555554444");
            a2.setTitre("Annonce 1");
            List<TrancheHoraire> tranches2 = new ArrayList<>();
            Optional<TrancheHoraire> t3 = trancheHoraireDao.findById(2L);
            Optional<TrancheHoraire> t4 = trancheHoraireDao.findById(3L);
            if(t3.isPresent()) tranches2.add(t3.get());
            if(t4.isPresent()) tranches2.add(t4.get());
            a2.setTrancheHoraires(tranches);
            List<Zone> zones2 = new ArrayList<>();
            Optional<Zone> z3 = zoneDao.findById(3L);
            Optional<Zone> z4 = zoneDao.findById(4L);
            if(z3.isPresent()) zones2.add(z3.get());
            if(z4.isPresent()) zones2.add(z4.get());
            a2.setZones(zones2);
            annonceService.addAnnonce(a1);
            annonceService.addAnnonce(a2);
        }
    }
    
}
