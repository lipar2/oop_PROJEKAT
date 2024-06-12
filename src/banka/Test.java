package banka;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // Kreiraj listu za čuvanje bankovnih računa
        ArrayList <CentralBank> bankovniRacuni = new ArrayList<>();

        // Dodaj testne račune
        CentralBank racun1 = new Bancaintesa("Marinko", "BC001", "stedni", 1500);
        CentralBank racun2 = new Erstebanka("Luka", "EB256", "devizni", 2500);
        CentralBank racun3 = new Unicredit("Nikola", "UC003", "dinarski", 3500);
        
        bankovniRacuni.add(racun1);
        bankovniRacuni.add(racun2);
        bankovniRacuni.add(racun3);

        // Prikazi sve račune
        System.out.println("Prikaz svih računa:");
        for (CentralBank racun : bankovniRacuni) {
            racun.PrikaziRacun();
            System.out.println();
        }

        // Test pretrage računa
        System.out.println("Test pretrage računa sa brojem naloga 'BC001':");
        boolean pronadjeno = false;
        for (CentralBank racun : bankovniRacuni) {
            if (racun.Pretrazi("BC001")) {
                pronadjeno = true;
                break;
            }
        }
        if (!pronadjeno) {
            System.out.println("Račun nije pronađen.");
        }

        // Test ubacivanja novca
        System.out.println("Deponovanje 1000 na račun 'EB256':");
        for (CentralBank racun : bankovniRacuni) {
            if (racun.Pretrazi("EB256")) {
                racun.UbaciNovac(1000);
                racun.PrikaziRacun();
                break;
            }
        }

        // Test povlačenja iznosa
        System.out.println("Povlačenje 500 sa računa 'UC003':");
        for (CentralBank racun : bankovniRacuni) {
            if (racun.Pretrazi("FGB003")) {
                racun.PodigniNovac(500);
                racun.PrikaziRacun();
                break;
            }
        }

        // Test brisanja računa
        System.out.println("Brisanje računa 'UC003':");
        pronadjeno = false;
        for (int i = 0; i < bankovniRacuni.size(); i++) {
            if (bankovniRacuni.get(i).Pretrazi("UC003")) {
            	bankovniRacuni.remove(i);
                pronadjeno = true;
                break;
            }
        }
        if (!pronadjeno) {
            System.out.println("Račun nije pronađen.");
        } else {
            System.out.println("Račun je uspešno obrisan.");
        }

        // Prikazi sve račune nakon brisanja
        System.out.println("Prikaz svih računa nakon brisanja:");
        for (CentralBank racun : bankovniRacuni) {
            racun.PrikaziRacun();
            System.out.println();
        }
    }
}
