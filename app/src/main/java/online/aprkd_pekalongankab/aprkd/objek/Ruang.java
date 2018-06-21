package online.aprkd_pekalongankab.aprkd.objek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ruang {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_ruang")
    @Expose
    private String namaRuang;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("fasilitas")
    @Expose
    private String fasilitas;
    @SerializedName("penanggung_jawab_id")
    @Expose
    private String penanggungJawabId;
    @SerializedName("kapasitas")
    @Expose
    private String kapasitas;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("no_hp")
    @Expose
    private String no_hp;

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getPenanggungJawabId() {
        return penanggungJawabId;
    }

    public void setPenanggungJawabId(String penanggungJawabId) {
        this.penanggungJawabId = penanggungJawabId;
    }

    public String getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}


