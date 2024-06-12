package banka;


import java.util.*;
 
public class BankDriver 
{
 
    public static CentralBank KreirajRacun(ArrayList<CentralBank> C)
    {
        int izbor;
        String ime, broj_racuna, tip_racuna;
        long stanje;
        boolean pronadjeno;
 
        CentralBank cus1;
 
        System.out.println("Unesite Vašu banku");
        System.out.println("1.Bancaintesa 2.Erstebanka 3. Unicredit");
        Scanner sc = new Scanner(System.in);
        izbor = sc.nextInt();
 
        System.out.print("Unesite Vaše ime: ");  
        ime = sc.next(); 
        System.out.print("Unesite broj Vašeg računa: ");  
        broj_racuna = sc.next();  
        System.out.print("Unesite tip Vašeg računa: ");  
        tip_racuna = sc.next();   
        System.out.print("Unesite stanje Vašeg računa: ");  
        stanje = sc.nextLong();
 
        pronadjeno = false;
        for (int i = 0; i < C.size(); i++) 
        {  
            pronadjeno = C.get(i).Pretrazi(broj_racuna);  
            if (pronadjeno) 
            {  
                System.out.println("Račun sa unetim brojem ne postoji."); 
                break;  
            }  
        }  
        if (!pronadjeno) 
        {  
            switch(izbor)
            {
                case 1:if(stanje < 1000)
                        {
                            System.out.println("Na računu mora da bude minimalan iznos od 1000 RSD.");
                        }
                        else
                        {
                            cus1 = new Bancaintesa(ime, broj_racuna, tip_racuna, stanje);
                            System.out.println("Vaš nalog je uspešno otvoren. Hvala Vam što koristite Banca Intesu.");
                            return cus1;
                        }
                        break;
                case 2:if(stanje < 2000)
                        {
                            System.out.println("Na računu mora da bude minimalan iznos od 2000 RSD.");
                        }
                        else
                        {
                            cus1 = new Erstebanka(ime, broj_racuna, tip_racuna, stanje);
                            System.out.println("Vaš nalog je uspešno otvoren. Hvala Vam što koristite Erste Banku.");
                            return cus1;
                        }
                        break;
     
                case 3:if(stanje < 3000)
                        {
                            System.out.println("Na računu mora da bude minimalan iznos od 500 RSD");
                        }
                        else
                        {
                            cus1 = new Unicredit(ime, broj_racuna, tip_racuna, stanje);
                            System.out.println("Vaš nalog je uspešno otvoren. Hvala Vam što koristite UniCredit Banku.");
                            return cus1;
                        }
                        break;
     
                default: System.out.println("Došlo je do greške.");
     
            }
        }
 
         
        return null;
 
    }
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
        ArrayList<CentralBank> C = new ArrayList<>();
        System.out.println("Ne postoji ni jedan nalog u sistemu. Molimo Vas da napravite nalog.");
        CentralBank cus1 = KreirajRacun(C);
        if(cus1 != null) 
        {
            C.add(cus1);
        }
         
        int ch;  
        do 
        {  
            System.out.println("\n #Banking System Application#");  
            System.out.println("1.Otvorite nalog \n2. Prikaži sve podatke o nalogu \n 3. Pretraga po broju naloga \n 4. Spustite određenu sumu \n 5. Podignite određenu sumu \n 6. Zatvorite nalog \n 7. Izlaz iz programa ");  
            System.out.println("Unesite broj kako biste pokrenuli program: ");  
            ch = sc.nextInt(); 
             
            switch (ch) 
            {  
                case 1: CentralBank cus = KreirajRacun(C);
                        if(cus != null) 
                        {
                            C.add(cus);
                        }
                        break;
                case 2:  
                    if(C.isEmpty())
                    {
                        System.out.println("U sistemu ne postoji ni jedan nalog.");
                    } 
                    for (int i = 0; i < C.size(); i++) 
                    {  
                        C.get(i).PrikaziRacun();  
                    } 
                    break;  
                case 3:  
                    System.out.print("Unesite broj naloga koji biste želeli da pretražite: ");  
                    String br_nal = sc.next();  
                    boolean nadjeno = false;  
                    for (int i = 0; i < C.size(); i++) 
                    {  
                        nadjeno = C.get(i).Pretrazi(br_nal);  
                        if (nadjeno) 
                        {  
                            break;  
                        }  
                    }  
 
                    if (!nadjeno) 
                    {  
                        System.out.println("Pretraga je neuspešna. U sistemu ne postoji nalog sa unetim brojem.");  
                    }  
                    break;  
                case 4:  
                    System.out.print("Unesite broj naloga: ");  
                    br_nal = sc.next();  
                    nadjeno = false;  
                    for (int i = 0; i < C.size(); i++) 
                    {  
                        nadjeno = C.get(i).Pretrazi(br_nal);  
                        if (nadjeno) 
                        {
                            System.out.println("Unesite sumu koju biste želeli da spustite: "); 
                            long suma = sc.nextLong(); 
                            C.get(i).UbaciNovac(suma);  
                            break;  
                        }  
                    }  
                    if (!nadjeno) 
                    {  
                        System.out.println("Pretraga je neuspešna. U sistemu ne postoji nalog sa unetim brojem.");  
                    }  
                    break;  
                case 5:  
                    System.out.print("Unesite broj naloga: ");  
                    br_nal = sc.next();  
                    nadjeno = false;  
                    for (int i = 0; i < C.size(); i++) 
                    {  
                        nadjeno = C.get(i).Pretrazi(br_nal);  
                        if (nadjeno) 
                        {  
                            System.out.println("Unesite sumu koju biste želeli da isplatite: "); 
                            long suma = sc.nextLong(); 
                            C.get(i).PodigniNovac(suma);  
                            break;  
                        }  
                    }  
                    if (!nadjeno) 
                    {  
                        System.out.println("Pretraga je neuspešna. U sistemu ne postoji nalog sa unetim brojem.");  
                    }  
                    break;  
                case 6:  
                    System.out.println("Unesite broj naloga: ");
                    String temp = sc.next();
                    nadjeno = false;
                    for (int i = 0; i < C.size(); i++) 
                    {  
                        nadjeno = C.get(i).Pretrazi(temp);  
                        if (nadjeno) 
                        {  
                            C.remove(i); 
                            System.out.println("Račun uspešno zatvoren."); 
                            break;  
                        }  
                    }  
                    if (!nadjeno) 
                    {  
                        System.out.println("Pretraga je neuspešna. U sistemu ne postoji nalog sa unetim brojem.");  
                    }
                    break;  
                case 7: 
                	break;
                default: System.out.println("Molimo Vas unesite validnu opciju.");
                         break;
            }  
        }  
        while (ch != 7);  
    }  
 
}
