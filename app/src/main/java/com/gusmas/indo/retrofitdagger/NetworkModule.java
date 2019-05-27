package com.gusmas.indo.retrofitdagger;


import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module(includes=ApplicationContextModule.class)
class NetworkModule {

    @Provides
    @CustomApplicationScope
    HttpLoggingInterceptor getInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return  interceptor;
    }

    @Provides
    @CustomApplicationScope
    Cache getCache(File cahaFile){
        return  new Cache(cahaFile, 10*1000*1000);
    }

    @Provides
    @CustomApplicationScope
    File getFile(@ApplicationContextQualifier Context context){
        File file = new File(context.getCacheDir(),"cache_dir");
        if(!file.exists()){
            file.mkdirs();
        }
        return file;
    }
    @Provides
    @CustomApplicationScope
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor  interceptor, Cache cache){
        return  new OkHttpClient.Builder()
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .cache( cache)
                .addInterceptor(interceptor)
                .build();
    }
}
