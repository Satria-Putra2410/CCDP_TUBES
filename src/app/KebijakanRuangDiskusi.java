package app;

public class KebijakanRuangDiskusi implements KebijakanPenggunaan {
    @Override
    public String getAturan() {
        return "Maks 4 jam, tanpa makanan, khusus diskusi";
    }

    @Override
    public boolean bolehReservasi(int durasiJam) {
        return durasiJam > 0 && durasiJam <= 4;
    }
}
