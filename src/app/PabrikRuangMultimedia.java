package app;

public class PabrikRuangMultimedia implements PabrikRuangan {
    @Override
    public Ruangan buatRuangan() {
        return new RuanganDasar("Ruang Multimedia", new KebijakanRuangMultimedia(), buatFasilitasBawaan(), 100000);
    }

    @Override
    public KomponenFasilitas buatFasilitasBawaan() {
        PaketFasilitas paket = new PaketFasilitas("Fasilitas Dasar Multimedia");
        paket.tambah(new Fasilitas("Sistem Suara", 25000));
        paket.tambah(new Fasilitas("Layar", 30000));
        return paket;
    }
}
