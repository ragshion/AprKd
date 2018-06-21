package online.aprkd_pekalongankab.aprkd.objek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiapAlat {

    @SerializedName("no_surat")
    @Expose
    private String noSurat;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("nama_peminjam")
    @Expose
    private String namaPeminjam;
    @SerializedName("nama_perlengkapan")
    @Expose
    private String namaPerlengkapan;
    @SerializedName("penanggung_jawab_id")
    @Expose
    private String penanggungJawabId;
    @SerializedName("jumlah")
    @Expose
    private String jumlah;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("tanggal_peminjaman")
    @Expose
    private String tanggalPeminjaman;

    public String getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getNamaPerlengkapan() {
        return namaPerlengkapan;
    }

    public void setNamaPerlengkapan(String namaPerlengkapan) {
        this.namaPerlengkapan = namaPerlengkapan;
    }

    public String getPenanggungJawabId() {
        return penanggungJawabId;
    }

    public void setPenanggungJawabId(String penanggungJawabId) {
        this.penanggungJawabId = penanggungJawabId;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public void setTanggalPeminjaman(String tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
