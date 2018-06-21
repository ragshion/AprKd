package online.aprkd_pekalongankab.aprkd.objek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LihatAlat {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("perlengkapan_id")
    @Expose
    private String perlengkapanId;
    @SerializedName("jumlah")
    @Expose
    private String jumlah;
    @SerializedName("peminjaman_id")
    @Expose
    private String peminjamanId;
    @SerializedName("peminjam_id")
    @Expose
    private String peminjamId;
    @SerializedName("tanggal_peminjaman")
    @Expose
    private String tanggalPeminjaman;
    @SerializedName("ruang_id")
    @Expose
    private String ruangId;
    @SerializedName("mobil_id")
    @Expose
    private Object mobilId;
    @SerializedName("foto_kesiapan")
    @Expose
    private Object fotoKesiapan;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("keterangan")
    @Expose
    private Object keterangan;
    @SerializedName("jumlah_peserta")
    @Expose
    private String jumlahPeserta;
    @SerializedName("acara")
    @Expose
    private String acara;
    @SerializedName("tempat")
    @Expose
    private String tempat;
    @SerializedName("penanggung_jawab_id")
    @Expose
    private String penanggungJawabId;
    @SerializedName("nama_perlengkapan")
    @Expose
    private String namaPerlengkapan;
    @SerializedName("no_surat")
    @Expose
    private String noSurat;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("no_hp")
    @Expose
    private String noHp;
    @SerializedName("nama_peminjam")
    @Expose
    private String namaPeminjam;
    @SerializedName("keperluan")
    @Expose
    private String keperluan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPerlengkapanId() {
        return perlengkapanId;
    }

    public void setPerlengkapanId(String perlengkapanId) {
        this.perlengkapanId = perlengkapanId;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getPeminjamanId() {
        return peminjamanId;
    }

    public void setPeminjamanId(String peminjamanId) {
        this.peminjamanId = peminjamanId;
    }

    public String getPeminjamId() {
        return peminjamId;
    }

    public void setPeminjamId(String peminjamId) {
        this.peminjamId = peminjamId;
    }

    public String getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public void setTanggalPeminjaman(String tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public String getRuangId() {
        return ruangId;
    }

    public void setRuangId(String ruangId) {
        this.ruangId = ruangId;
    }

    public Object getMobilId() {
        return mobilId;
    }

    public void setMobilId(Object mobilId) {
        this.mobilId = mobilId;
    }

    public Object getFotoKesiapan() {
        return fotoKesiapan;
    }

    public void setFotoKesiapan(Object fotoKesiapan) {
        this.fotoKesiapan = fotoKesiapan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(Object keterangan) {
        this.keterangan = keterangan;
    }

    public String getJumlahPeserta() {
        return jumlahPeserta;
    }

    public void setJumlahPeserta(String jumlahPeserta) {
        this.jumlahPeserta = jumlahPeserta;
    }

    public String getAcara() {
        return acara;
    }

    public void setAcara(String acara) {
        this.acara = acara;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getPenanggungJawabId() {
        return penanggungJawabId;
    }

    public void setPenanggungJawabId(String penanggungJawabId) {
        this.penanggungJawabId = penanggungJawabId;
    }

    public String getNamaPerlengkapan() {
        return namaPerlengkapan;
    }

    public void setNamaPerlengkapan(String namaPerlengkapan) {
        this.namaPerlengkapan = namaPerlengkapan;
    }

    public String getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

}