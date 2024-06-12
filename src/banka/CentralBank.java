package banka;

public interface CentralBank
{
    long  PrikaziStanje();
    void PodigniNovac(long suma);
    void UbaciNovac(long suma);
    void PrikaziRacun();
    boolean Pretrazi(String br_naloga);
}

