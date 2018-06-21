package online.aprkd_pekalongankab.aprkd.objek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListPegawai {

    @SerializedName("id_pegawai")
    @Expose
    private String idPegawai;
    @SerializedName("nip")
    @Expose
    private String nip;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("no_hp")
    @Expose
    private String noHp;
    @SerializedName("bidang")
    @Expose
    private String bidang;

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public String getBidang() {
        return bidang;
    }

    public void setBidang(String bidang) {
        this.bidang = bidang;
    }

}
