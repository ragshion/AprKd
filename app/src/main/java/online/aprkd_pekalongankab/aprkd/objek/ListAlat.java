package online.aprkd_pekalongankab.aprkd.objek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListAlat {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_perlengkapan")
    @Expose
    private String namaPerlengkapan;
    @SerializedName("jumlah")
    @Expose
    private String jumlah;
    @SerializedName("penanggung_jawab_id")
    @Expose
    private String penanggungJawabId;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("no_hp")
    @Expose
    private String noHp;

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

    public String getPenanggungJawabId() {
        return penanggungJawabId;
    }

    public void setPenanggungJawabId(String penanggungJawabId) {
        this.penanggungJawabId = penanggungJawabId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

}
