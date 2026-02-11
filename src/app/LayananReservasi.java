package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LayananReservasi {
    private final Map<String, Reservasi> aktif = new HashMap<>();
    private final RiwayatReservasi riwayat = new RiwayatReservasi();

    public void tambahReservasi(Reservasi reservasi) {
        aktif.put(reservasi.getId(), reservasi);
    }

    public Reservasi ambilReservasi(String id) {
        return aktif.get(id);
    }

    public void batalkanReservasi(String id) {
        Reservasi res = aktif.get(id);
        if (res != null) {
            res.batalkan();
            riwayat.catat(res);
            aktif.remove(id);
        }
    }

    public void selesaiReservasi(String id) {
        Reservasi res = aktif.get(id);
        if (res != null) {
            res.selesai();
            riwayat.catat(res);
            aktif.remove(id);
        }
    }

    public List<Reservasi> getReservasiAktif() {
        return new ArrayList<>(aktif.values());
    }

    public List<Reservasi> getRiwayat() {
        return riwayat.getSemua();
    }
}
