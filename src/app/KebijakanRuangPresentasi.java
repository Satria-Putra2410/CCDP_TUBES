package app;

public class KebijakanRuangPresentasi implements KebijakanPenggunaan {
    @Override
    public String getAturan() {
        return "Maks 3 jam, wajib setup presentasi";
    }

    @Override
    public boolean bolehReservasi(int durasiJam) {
        return durasiJam > 0 && durasiJam <= 3;
    }
}
