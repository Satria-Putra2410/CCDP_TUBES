package app;

public class KebijakanRuangMultimedia implements KebijakanPenggunaan {
    @Override
    public String getAturan() {
        return "Maks 2 jam, wajib cek peralatan";
    }

    @Override
    public boolean bolehReservasi(int durasiJam) {
        return durasiJam > 0 && durasiJam <= 2;
    }
}
