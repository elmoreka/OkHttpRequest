package com.example.gohee_000.okhttprequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private Button btnSendHttpRequest;

    private EditText etJsonResponse;

    private OkHttpClient okHttpClient;

    private Request request;

    private String url ="http://www.mocky.io/v2/5a1cddc92e0000a20948b53c";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendHttpRequest = (Button) findViewById(R.id.btnSendRequest);

        etJsonResponse = (EditText) findViewById(R.id.etJson);

        btnSendHttpRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Initialize a http client
                okHttpClient = new OkHttpClient();
                // Initialize a request
                request = new Request.Builder().url(url).build();
                //execute the request
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i(TAG, e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.i(TAG, response.body().string());
                    }
                });

            }
        });
    }
}