package app;

import java.util.ArrayList;
import java.util.List;

public class PaketFasilitas implements KomponenFasilitas {
    private final String deskripsi;
    private final List<KomponenFasilitas> item = new ArrayList<>();

    public PaketFasilitas(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public PaketFasilitas tambah(KomponenFasilitas komponen) {
        if (komponen != null) {
            item.add(komponen);
        }
        return this;
    }

    public List<KomponenFasilitas> getItem() {
        return new ArrayList<>(item);
    }

    @Override
    public String getDeskripsi() {
        StringBuilder sb = new StringBuilder(deskripsi);
        if (!item.isEmpty()) {
            sb.append(" [");
            for (int i = 0; i < item.size(); i++) {
                sb.append(item.get(i).getDeskripsi());
                if (i < item.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    @Override
    public double getBiaya() {
        double total = 0.0;
        for (KomponenFasilitas k : item) {
            total += k.getBiaya();
        }
        return total;
    }
}
