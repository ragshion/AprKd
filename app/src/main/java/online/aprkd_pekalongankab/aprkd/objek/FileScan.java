package online.aprkd_pekalongankab.aprkd.objek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileScan {

    @SerializedName("id_files")
    @Expose
    private String idFiles;
    @SerializedName("file_name")
    @Expose
    private String fileName;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("no_urut")
    @Expose
    private String noUrut;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;

    public String getIdFiles() {
        return idFiles;
    }

    public void setIdFiles(String idFiles) {
        this.idFiles = idFiles;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(String noUrut) {
        this.noUrut = noUrut;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}
