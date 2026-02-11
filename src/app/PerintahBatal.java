package app;

public class PerintahBatal implements Perintah {
    private final LayananReservasi layanan;
    private final String idReservasi;
    private Reservasi sebelumnya;

    public PerintahBatal(LayananReservasi layanan, String idReservasi) {
        this.layanan = layanan;
        this.idReservasi = idReservasi;
    }

    @Override
    public void eksekusi() {
        sebelumnya = layanan.ambilReservasi(idReservasi);
        layanan.batalkanReservasi(idReservasi);
    }

    @Override
    public void batal() {
        if (sebelumnya != null) {
            layanan.tambahReservasi(sebelumnya);
        }
    }
}
