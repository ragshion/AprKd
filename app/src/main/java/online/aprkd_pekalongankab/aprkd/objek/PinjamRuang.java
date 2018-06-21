package online.aprkd_pekalongankab.aprkd.objek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PinjamRuang {

    @SerializedName("id")
    @Expose
    private String id;
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
    private String fotoKesiapan;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
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
    @SerializedName("nama_ruang")
    @Expose
    private String namaRuang;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("fasilitas")
    @Expose
    private String fasilitas;
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

    public String getFotoKesiapan() {
        return fotoKesiapan;
    }

    public void setFotoKesiapan(String fotoKesiapan) {
        this.fotoKesiapan = fotoKesiapan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
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

    public String getNamaRuang() {
        return namaRuang;
    }

    public void setNamaRuang(String namaRuang) {
        this.namaRuang = namaRuang;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
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
