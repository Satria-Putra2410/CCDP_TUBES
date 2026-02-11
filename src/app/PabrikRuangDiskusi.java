package app;

public class PabrikRuangDiskusi implements PabrikRuangan {
    @Override
    public Ruangan buatRuangan() {
        return new RuanganDasar("Ruang Diskusi", new KebijakanRuangDiskusi(), buatFasilitasBawaan(), 50000);
    }

    @Override
    public KomponenFasilitas buatFasilitasBawaan() {
        PaketFasilitas paket = new PaketFasilitas("Fasilitas Dasar Diskusi");
        paket.tambah(new Fasilitas("Papan Tulis", 10000));
        paket.tambah(new Fasilitas("WiFi", 0));
        return paket;
    }
}
