package com.gusmas.indo.retrofitdagger;


import com.squareup.picasso.Picasso;

import dagger.Component;


@CustomApplicationScope
@Component(modules={ServiceUtilsModule.class, PicassoModule.class})
public interface ServiceApplicationComponent {

    Picasso getPicasso();

    ServiceUtil getServiceUtil();

    void inject(MainActivity mainActivity);


}
