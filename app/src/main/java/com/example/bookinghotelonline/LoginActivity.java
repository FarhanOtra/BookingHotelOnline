package com.example.bookinghotelonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookinghotelonline.model.AuthClass;
import com.example.bookinghotelonline.model.AuthData;
import com.example.bookinghotelonline.retrofit.PortalClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void checkLogin(View view) {
        EditText editUsername;
        EditText editPassword;

        editUsername = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);

        String email = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        //Buat Object Client Retrofit
        String API_BASE_URL = "https://9803-36-69-14-214.ngrok.io/hotelapi/public/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PortalClient client = retrofit.create(PortalClient.class);

        //Panggil Method
        Call<AuthClass> call =  client.checkLogin(email, password);
//        toogleState(true);
        call.enqueue(new Callback<AuthClass>() {
            @Override
            public void onResponse(Call<AuthClass> call, Response<AuthClass> response) {
                    AuthClass authClass = response.body();
                    if(authClass != null){
                        AuthData data = authClass.getData();
                        String token = data.getToken();

                        Intent homeIntent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(homeIntent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Email dan Password Salah", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(Call<AuthClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
//                toogleState(false);
            }
        });
    }

//    public void toogleState(Boolean onProgress){
//        ProgressBar progressBar = findViewById(R.id.progressBar);
//        Button buttonLogin  = findViewById(R.id.buttonLogin);
//
//        if(onProgress){
//            progressBar.setVisibility(View.VISIBLE);
//            buttonLogin.setVisibility(View.GONE);
//        }else{
//            progressBar.setVisibility(View.GONE);
//            buttonLogin.setVisibility(View.VISIBLE);
//        }
//    }
}