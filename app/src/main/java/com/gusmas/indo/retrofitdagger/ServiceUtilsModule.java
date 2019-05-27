package com.gusmas.indo.retrofitdagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
class ServiceUtilsModule {

    private static final String BASE_URL = "https://www.frisbeego.com/secure/index.php/";

    @Provides
    @CustomApplicationScope
    ServiceUtil getServiceUtil(Retrofit retrofit){
        return  retrofit.create(ServiceUtil.class);
    }

    @Provides
    @CustomApplicationScope
    Gson getGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return  gsonBuilder.create();
    }

    @Provides
    @CustomApplicationScope
    Retrofit getRertofit(OkHttpClient okHttpClient, Gson gson){
        return  new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();

    }
}
