package banka;


public class Bancaintesa implements CentralBank {
   
    String ime;
    String brojNaloga;
    String tipNaloga;
    long stanje;  
 
    Bancaintesa(String ime, String brojNaloga, String tipNaloga, long stanje)
    {
        this.ime = ime; 
        this.brojNaloga = brojNaloga; 
        this.tipNaloga = tipNaloga;  
        this.stanje = stanje;
    }
 
    public long PrikaziStanje(){
        return stanje;
    }
 
    public void PodigniNovac(long suma)
    {
        if (stanje >= suma) 
        {  
            stanje = stanje - suma;  
            System.out.println("Stanje nakon isplate: " + stanje);  
        } 
        else 
        {  
            System.out.println("Vaše stanje je manje od unete vrednosti. \nTransakcija je neuspešna." );  
        }  
    }
 
    public void UbaciNovac(long suma)
    {
        stanje = stanje + suma;
    }
 
    public void PrikaziRacun(){
        System.out.println("Banca Intesa račun");
        System.out.println("Ime korisnika: " + ime);  
        System.out.println("Broj računa: " + brojNaloga);  
        System.out.println("Tip naloga: " + tipNaloga);  
        System.out.println("Trenutno stanje: " + stanje);  
 
    }
 
    public boolean Pretrazi(String brojNaloga)
    {  
        if (brojNaloga.equals(brojNaloga)) 
        {  
            PrikaziRacun();  
            return (true);  
        }  
        return (false);  
    } 
 
}
