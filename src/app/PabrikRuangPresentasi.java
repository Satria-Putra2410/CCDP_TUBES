package app;

public class PabrikRuangPresentasi implements PabrikRuangan {
    @Override
    public Ruangan buatRuangan() {
        return new RuanganDasar("Ruang Presentasi", new KebijakanRuangPresentasi(), buatFasilitasBawaan(), 80000);
    }

    @Override
    public KomponenFasilitas buatFasilitasBawaan() {
        PaketFasilitas paket = new PaketFasilitas("Fasilitas Dasar Presentasi");
        paket.tambah(new Fasilitas("Proyektor", 20000));
        paket.tambah(new Fasilitas("Papan Tulis", 10000));
        return paket;
    }
}
