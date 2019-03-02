package com.example.king.dsjweek03.application;

import android.app.Application;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DiskCacheConfig diskConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryName("IMage")
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskConfig)
                .build();
        Fresco.initialize(this,config);
    }
}
