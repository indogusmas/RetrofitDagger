package com.gusmas.indo.retrofitdagger;


import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes=NetworkModule.class)
class PicassoModule {

    @Provides
    @CustomApplicationScope
    Picasso getPicasso(@ApplicationContextQualifier Context context, OkHttp3Downloader okHttp3Downloader){
        return  new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }
    @Provides
    @CustomApplicationScope
    OkHttp3Downloader getOkHttp3Downloader(OkHttpClient client){
        return  new OkHttp3Downloader(client);
    }
}
