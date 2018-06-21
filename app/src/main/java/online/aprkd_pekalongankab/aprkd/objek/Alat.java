package online.aprkd_pekalongankab.aprkd.objek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Alat {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_perlengkapan")
    @Expose
    private String namaPerlengkapan;
    @SerializedName("jumlah")
    @Expose
    private String jumlah;
    @SerializedName("nama_ruang")
    @Expose
    private String namaRuang;
    @SerializedName("tanggal_peminjaman")
    @Expose
    private String tanggalPeminjaman;
    @SerializedName("jam")
    @Expose
    private String jam;
    @SerializedName("no_surat")
    @Expose
    private String noSurat;
    @SerializedName("peminjaman_id")
    @Expose
    private String peminjamanId;
    @SerializedName("jumlah_peserta")
    @Expose
    private String jumlahPeserta;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("nama_peminjam")
    @Expose
    private String namaPeminjam;
    @SerializedName("foto_kesiapan")
    @Expose
    private String fotoKesiapan;
    @SerializedName("penanggung_jawab_id")
    @Expose
    private String penanggungJawabId;
    @SerializedName("acara")
    @Expose
    private String acara;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaPerlengkapan() {
        return namaPerlengkapan;
    }

    public void setNamaPerlengkapan(String namaPerlengkapan) {
        this.namaPerlengkapan = namaPerlengkapan;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getNamaRuang() {
        return namaRuang;
    }

    public void setNamaRuang(String namaRuang) {
        this.namaRuang = namaRuang;
    }

    public String getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public void setTanggalPeminjaman(String tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public String getPeminjamanId() {
        return peminjamanId;
    }

    public void setPeminjamanId(String peminjamanId) {
        this.peminjamanId = peminjamanId;
    }

    public String getJumlahPeserta() {
        return jumlahPeserta;
    }

    public void setJumlahPeserta(String jumlahPeserta) {
        this.jumlahPeserta = jumlahPeserta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getFotoKesiapan() {
        return fotoKesiapan;
    }

    public void setFotoKesiapan(String fotoKesiapan) {
        this.fotoKesiapan = fotoKesiapan;
    }

    public String getPenanggungJawabId() {
        return penanggungJawabId;
    }

    public void setPenanggungJawabId(String penanggungJawabId) {
        this.penanggungJawabId = penanggungJawabId;
    }

    public String getAcara() {
        return acara;
    }

    public void setAcara(String acara) {
        this.acara = acara;
    }

}
