package com.gusmas.indo.retrofitdagger;

import retrofit2.Call;
import retrofit2.http.GET;

interface ServiceUtil {
    @GET("GetCarCategories.php")
    Call<CarCategoryResponse>getCarCategory();
}
