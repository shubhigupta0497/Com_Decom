package com.heythere.final_app;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * Created by shubhigupta on 29/01/17.
 */
//// how to zoom??
    //system app n third party app??
    //speech recog
    //flying waali mei how har word k saath attach ho rhi thi app??
    //how to browse through a button.
public class SecondWork extends IntentService {

    public static void YoDecompress(File source, File destination) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        GZIPInputStream gzis = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(destination);
        //BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        //StringBuilder sb = new StringBuilder();
        //String str = null;
        byte[] buffer = new byte[1024];
        int read;
        try {
            while ((read = gzis.read(buffer)) != -1){
                fos.write(buffer,0,read);
            }
            gzis.close();
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SecondWork() {
        super(SecondWork.class.toString());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        File source = new File(Environment.getExternalStorageDirectory() + "/Download/TestCompressedServiceFile.txt");
        File destination = new File(Environment.getExternalStorageDirectory() + "/Download/TestFileSER1.txt");
        try {
            YoDecompress(source,destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
