package com.heythere.final_app;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by shubhigupta on 29/01/17.
 */

public class MainSErvice extends IntentService {

    public static void YoCompress(File source, File destination) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        //BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        //StringBuilder sb = new StringBuilder();
        //String str = null;
        byte[] buffer = new byte[1024];
        int read;
        try {
            while ((read = fis.read()) != -1){
                gzip.write(buffer,0,read);
            }
            gzip.finish();
            gzip.close();
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MainSErvice() {
        super(MainSErvice.class.toString());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        File source = new File(Environment.getExternalStorageDirectory() + "/Download/TestFile.txt");
        File destination = new File(Environment.getExternalStorageDirectory() + "/Download/TestCompressedServiceFile.txt");
        try {
            YoCompress(source,destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
