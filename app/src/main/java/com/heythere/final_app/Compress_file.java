package com.heythere.final_app;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compress_file extends AppCompatActivity {
    Button Compress,backBtn;
    EditText et2;
/*
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
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compress_file);
        Compress = (Button) findViewById(R.id.button3);
        backBtn = (Button) findViewById(R.id.button4);
        et2 = (EditText) findViewById(R.id.editText);

        Compress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // File source = new File(Environment.getExternalStorageDirectory() + "/Download/TestFile.txt");
               // File destination = new File(Environment.getExternalStorageDirectory() + "/Download/TestCompressedFile.txt");
               // try {
                    Intent i = new Intent(Compress_file.this,MainSErvice.class);
                    startService(i);
                    //YoCompress(source,destination);
                    Toast.makeText(getApplicationContext(),"File successfully compressed",Toast.LENGTH_SHORT).show();
               // } catch (IOException e) {
                   // Toast.makeText(getApplicationContext(),"File did'nt compress",Toast.LENGTH_SHORT).show();
                   // e.printStackTrace();
               // }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Compress_file.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}
