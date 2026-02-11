package app;

public interface StatusReservasi {
    String getNama();
    void setujui(Reservasi reservasi);
    void mulai(Reservasi reservasi);
    void selesai(Reservasi reservasi);
    void batalkan(Reservasi reservasi);
}
