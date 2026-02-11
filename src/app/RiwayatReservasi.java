package app;

import java.util.ArrayList;
import java.util.List;

public class RiwayatReservasi {
    private final List<Reservasi> selesai = new ArrayList<>();

    public void catat(Reservasi reservasi) {
        selesai.add(reservasi);
    }

    public List<Reservasi> getSemua() {
        return new ArrayList<>(selesai);
    }
}
