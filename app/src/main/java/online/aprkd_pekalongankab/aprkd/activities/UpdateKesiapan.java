package online.aprkd_pekalongankab.aprkd.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.dd.processbutton.FlatButton;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.api.Client;
import online.aprkd_pekalongankab.aprkd.api.Service;
import online.aprkd_pekalongankab.aprkd.api.UploadService;
import online.aprkd_pekalongankab.aprkd.objek.BaseResponse;
import online.aprkd_pekalongankab.aprkd.utilities.FileUtils;
import online.aprkd_pekalongankab.aprkd.utilities.SharedPrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateKesiapan extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    private static final int PERMISSION_REQUEST_STORAGE = 2;

    MaterialEditText meKeterangan;
    MaterialSpinner mtStatus;
    FlatButton btnSimpan;
    MaterialDialog materialDialog, dialogEmpty, dialogSalah;
    ImageView imgThumb;
    String id_sesuatu, jenis, tabel;

    SharedPrefManager sharedPrefManager;

    private UploadService uploadService;
    private final ArrayList<String> mStrings = new ArrayList<>();

    String TYPE_1 = "gagal";

    private Uri uri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_kesiapan);
//        meKeterangan = findViewById(R.id.keterangan);
        mtStatus = findViewById(R.id.status);
        btnSimpan = findViewById(R.id.btnUpload);

        mtStatus.setItems("in progress","siap","selesai");

        sharedPrefManager = new SharedPrefManager(this);

        id_sesuatu = getIntent().getStringExtra("id");
        tabel = getIntent().getStringExtra("tabel");

        jenis = sharedPrefManager.getSpJenis();

        imgThumb = findViewById(R.id.img_thumb);
        imgThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePhoto();
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDialog = new MaterialDialog.Builder(UpdateKesiapan.this)
                        .content("Sedang Menyimpan...")
                        .progress(true, 0)
                        .cancelable(false)
                        .progressIndeterminateStyle(true)
                        .show();
                if(uri != null) {
                    File file = FileUtils.getFile(UpdateKesiapan.this, uri);
                    uploadMultipart(file);
                }else{
                    Toast.makeText(UpdateKesiapan.this, "You must choose the image", Toast.LENGTH_SHORT).show();
                    materialDialog.dismiss();
                }
            }
        });
    }

    private void uploadMultipart(File file) {
        TYPE_1 = id_sesuatu;
        RequestBody photoBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part photoPart = MultipartBody.Part.createFormData("photo",
                file.getName(), photoBody);

        RequestBody action = RequestBody.create(MediaType.parse("text/plain"), TYPE_1);

        uploadService = new UploadService();
        uploadService.uploadPhotoMultipart(action, photoPart, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Toast.makeText(UpdateKesiapan.this, "Berhasil Upload Foto", Toast.LENGTH_SHORT).show();
                updateKesiapan(mtStatus.getText().toString(),id_sesuatu, tabel);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                materialDialog.dismiss();
                t.printStackTrace();
//                Toast.makeText(UpdateKesiapan.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.v("Update Kesiapan", t.getMessage());
                onBackPressed();
            }
        });
    }

    void updateKesiapan(String status,String id_sesuatu, String tabel){
        Service serviceApi = Client.getClient();
        Call<ResponseBody> updateSiap = serviceApi.updateSiap(status,id_sesuatu,tabel,TYPE_1);
        updateSiap.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(UpdateKesiapan.this, "Berhasil Simpan", Toast.LENGTH_SHORT).show();
                materialDialog.dismiss();
                Intent kembali = new Intent(UpdateKesiapan.this, KesiapanActivity.class);
                kembali.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(kembali);
                finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                materialDialog.dismiss();
                Toast.makeText(UpdateKesiapan.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
                Log.v("UpdateStatusSiap",t.getMessage());
                onBackPressed();
            }
        });
    }

    private void choosePhoto() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_STORAGE);

        }else{
            openGallery();
        }
    }

    public void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if(data != null) {
                uri = data.getData();
                imgThumb.setImageURI(uri);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openGallery();
                }

                return;
            }
        }
    }
}
