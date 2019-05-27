package com.gusmas.indo.retrofitdagger;


import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public  class ApplicationContextModule {

    private  final Context context;

    public ApplicationContextModule(Context context) {
        this.context=context;
    }

    @Provides
    @CustomApplicationScope
    @ApplicationContextQualifier
    Context getContext(){
        return context;
    }
}
