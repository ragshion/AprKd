package online.aprkd_pekalongankab.aprkd.api;

import com.google.gson.JsonArray;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import online.aprkd_pekalongankab.aprkd.objek.BaseResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

//import id.co.japps.fasilkes.objek.Faskes;

/**
 * Created by delaroy on 7/3/17.
 */

public interface Service {

    @FormUrlEncoded
    @POST("api/login_android")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);
    //Api Login Android

    @GET("api/peminjaman_ruang/{keterangan}")
    Call<JsonArray> getPeminjamanRuang(
            @Path("keterangan") String keterangan
    );
    //Keterangan adalah keterangan hari / minggu / bulan ini

    @GET("api/ruang")
    Call<JsonArray> getRuang();
    //Api untuk mengambil ruang yang dapat di pinjam

    @FormUrlEncoded
    @POST("api/detail_pinjam_ruang")
    Call<ResponseBody> getDetailPeminjamanRuang(
            @Field("id") String id
    );
    //Api mengambil detail ruang peminjaman



    @GET("api/peminjaman_kendaraan/{keterangan}")
    Call<JsonArray> getPeminjamanKendaraan(
            @Path("keterangan") String keterangan
    );
    //Keterangan adalah keterangan hari / minggu / bulan ini

    @GET("api/kendaraan")
    Call<JsonArray> getKendaraan();
    //Api untuk mengambil kendaraan yang dapat di pinjam

    @FormUrlEncoded
    @POST("api/detail_pinjam_kendaraan")
    Call<ResponseBody> getDetailPeminjamanKendaraan(
            @Field("id") String id
    );
    //Api mengambil detail kendaraan peminjaman


    @GET("api/peminjaman_alat/{keterangan}")
    Call<JsonArray> getPeminjamanAlat(
            @Path("keterangan") String keterangan
    );
    //Keterangan adalah keterangan hari / minggu / bulan ini

    @GET("api/alat")
    Call<JsonArray> getAlat();
    //Api untuk mengambil ruang yang dapat di pinjam

    @FormUrlEncoded
    @POST("api/detail_pinjam_alat")
    Call<ResponseBody> getDetailPinjamAlat(
            @Field("id") String id
    );
    //Api mengambil detail kendaraan peminjaman

    @FormUrlEncoded
    @POST("api/alat_by")
    Call<JsonArray> getAlatBy(@Field("no_surat") String no_surat);
    //Api get alat untuk detail ruang

    @Multipart
    @POST(Config.API_UPLOAD)
    Call<BaseResponse> uploadPhotoMultipart(
            @Part("action") RequestBody action,
            @Part MultipartBody.Part photo);
    //Api untuk upload foto

    @FormUrlEncoded
    @POST("api/peminjaman_siap")
    Call<JsonArray> getPeminjamanSiap(
            @Field("id_penanggungjawab") String id_penanggungjawab,
            @Field("status") String status,
            @Field("jenis") String jenis
    );


    @FormUrlEncoded
    @POST("api/update_status")
    Call<ResponseBody> updateSiap(
            @Field("status") String status,
            @Field("id") String id,
            @Field("tabel") String tabel,
            @Field("nama_file") String nama_file
    );

    @GET("disposisi/api/{status}")
    Call<JsonArray> getDisposisi(
            @Path("status") String status
    );

    @GET("disposisi/api_kabid/{bidang}/{ars}")
    Call<JsonArray> getBidang(
            @Path("bidang") String bidang,
            @Path("ars") String ars
    );

    @GET("files/view/{no_urut}")
    Call<JsonArray> getFiles(
            @Path("no_urut") String no_urut
    );

    @GET("disposisi/list_pegawai/{bidang}")
    Call<JsonArray> listPegawai(
            @Path("bidang") String bidang
    );

    @FormUrlEncoded
    @POST("disposisi/ubahjson")
    Call<ResponseBody> ubahDisposisi(
            @Field("id_disposisi") String id_disposisi,
            @Field("sekretaris") String sekretaris,
            @Field("litbang") String litbang,
            @Field("ekonomi") String ekonomi,
            @Field("program") String program,
            @Field("pemsosbud") String pemsosbud,
            @Field("catat") String catat,
            @Field("hadiri") String hadiri,
            @Field("siapkan") String siapkan,
            @Field("koordinasi") String koordinasi,
            @Field("kaji") String kaji,
            @Field("pedomani") String pedomani,
            @Field("pertimbangkan") String pertimbangkan,
            @Field("catatan") String catatan
    );

    @FormUrlEncoded
    @POST("disposisi/simpanPesan")
    Call<ResponseBody> simpanAkhir(
            @Field("nama_pegawai") String nama_pegawai,
            @Field("pesan") String pesan,
            @Field("id_disposisi") String id_disposisi,
            @Field("pendisposisi") String pendisposisi
    );



    @FormUrlEncoded
    @POST("disposisi/get_no_hp")
    Call<ResponseBody> get_no_hp(@Field("nama") String nama);

    @FormUrlEncoded
    @POST("disposisi/simpanterima")
    Call<ResponseBody> simpanTerima(@Field("id_disposisi") String id_disposisi, @Field("penerima") String penerima);

    @FormUrlEncoded
    @POST("login/updatepassword")
    Call<ResponseBody> updatepassword(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("disposisi/api_user")
    Call<JsonArray> getUser(@Field("nama") String nama);

    @FormUrlEncoded
    @POST("disposisi/api_user_arsip")
    Call<JsonArray> getArsipUser(@Field("nama") String nama, @Field("terlaksana") String terlaksana);

    @FormUrlEncoded
    @POST("disposisi/api_bidang_arsip")
    Call<JsonArray> arsipBidang(@Field("id_disposisi") String id_disposisi, @Field("arsip") String arsip);



}
