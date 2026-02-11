package app;

public class Utama {
    public static void main(String[] args) {
        PabrikRuangan pabrik = new PabrikRuangDiskusi();
        Ruangan ruanganDasar = pabrik.buatRuangan();

        // Prototype: salin konfigurasi populer
        Ruangan ruanganSalinan = ruanganDasar.salin();

        // Decorator + Composite: tambah fasilitas tambahan
        KomponenFasilitas fasilitasTambahan = new PaketFasilitas("Fasilitas Tambahan")
                .tambah(new Fasilitas("Proyektor", 20000))
                .tambah(new Fasilitas("Sistem Suara", 25000));
        Ruangan ruanganUpgrade = new DekoratorRuangan(ruanganSalinan, fasilitasTambahan);

        // Builder: bangun reservasi
        Reservasi reservasi = new Reservasi.Builder()
                .id("RSV-001")
                .namaMahasiswa("Alya")
                .ruangan(ruanganUpgrade)
                .durasiJam(3)
                .fasilitas(ruanganUpgrade.getFasilitas())
                .strategiHarga(new StrategiHargaPaket(3, 120000))
                .catatan("Kelompok belajar untuk ujian akhir")
                .bangun();

        // Command: eksekusi reservasi
        LayananReservasi layanan = new LayananReservasi();
        Perintah perintahReservasi = new PerintahReservasi(layanan, reservasi);
        perintahReservasi.eksekusi();

        // Perubahan status
        reservasi.setujui();
        reservasi.mulai();
        // Layanan menangani penyelesaian dan arsip
        layanan.selesaiReservasi(reservasi.getId());

        System.out.println("Status Reservasi: " + reservasi.getStatus());
        System.out.println("Total Biaya: " + reservasi.hitungTotalBiaya());
        System.out.println("Jenis Ruangan: " + reservasi.getRuangan().getJenis());
        System.out.println("Aturan: " + reservasi.getRuangan().getKebijakan().getAturan());
        System.out.println("Fasilitas: " + reservasi.getFasilitas().getDeskripsi());
        System.out.println("Jumlah Riwayat: " + layanan.getRiwayat().size());

        // Contoh batal dan undo
        Reservasi reservasi2 = new Reservasi.Builder()
                .id("RSV-002")
                .namaMahasiswa("Bima")
                .ruangan(new PabrikRuangPresentasi().buatRuangan())
                .durasiJam(2)
                .strategiHarga(new StrategiHargaPerJam())
                .bangun();

        Perintah perintahReservasi2 = new PerintahReservasi(layanan, reservasi2);
        perintahReservasi2.eksekusi();
        Perintah perintahBatal2 = new PerintahBatal(layanan, reservasi2.getId());
        perintahBatal2.eksekusi();
        perintahBatal2.batal();

        System.out.println("Reservasi Aktif: " + layanan.getReservasiAktif().size());
    }
}
