package app;

public class StatusSelesai implements StatusReservasi {
    @Override
    public String getNama() {
        return "Selesai";
    }

    @Override
    public void setujui(Reservasi reservasi) {
        throw new IllegalStateException("Sudah selesai");
    }

    @Override
    public void mulai(Reservasi reservasi) {
        throw new IllegalStateException("Sudah selesai");
    }

    @Override
    public void selesai(Reservasi reservasi) {
        throw new IllegalStateException("Sudah selesai");
    }

    @Override
    public void batalkan(Reservasi reservasi) {
        throw new IllegalStateException("Tidak bisa batalkan reservasi yang sudah selesai");
    }
}
