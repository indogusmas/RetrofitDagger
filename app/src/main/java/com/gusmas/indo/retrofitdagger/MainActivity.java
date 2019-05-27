package com.gusmas.indo.retrofitdagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Inject
    Picasso picasso;
    @Inject
    ServiceUtil serviceUtil;
    private List<CarCategoryResponse.CarCategory> carCategories = new ArrayList<>();
    private String TAG =getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServiceApplicationComponent component = DaggerServiceApplicationComponent.builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .build();
        component.inject(this);
        serviceUtil.getCarCategory().enqueue(new Callback<CarCategoryResponse>() {
            @Override
            public void onResponse(Call<CarCategoryResponse> call, Response<CarCategoryResponse> response) {
                Log.e(TAG, "onResponse: "+ response.toString());
            }

            @Override
            public void onFailure(Call<CarCategoryResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage() );
            }
        });
    }
}
