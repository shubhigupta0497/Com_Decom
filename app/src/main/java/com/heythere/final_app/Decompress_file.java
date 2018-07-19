package com.heythere.final_app;

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
import java.util.zip.GZIPInputStream;

public class Decompress_file extends AppCompatActivity {
    Button Decompress,backBtn,browseBtn;
    EditText et1;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decompress_file);
        Decompress = (Button) findViewById(R.id.button);
        backBtn = (Button) findViewById(R.id.button5);
        browseBtn = (Button) findViewById(R.id.BrowseButton);
        et1 = (EditText) findViewById(R.id.editText2);

        Decompress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //File source = new File(Environment.getExternalStorageDirectory() + "/Download/TestCompressedFile.txt");
               // File destination = new File(Environment.getExternalStorageDirectory() + "/Download/TestFile1.txt");
                //try {
                Intent i = new Intent(Decompress_file.this,SecondWork.class);
                startService(i);
                    //YoDecompress(source,destination);
                    Toast.makeText(getApplicationContext(),"File successfully Decompressed",Toast.LENGTH_SHORT).show();
                //} catch (IOException e) {
                   // Toast.makeText(getApplicationContext(),"File did'nt compress",Toast.LENGTH_SHORT).show();
                   // e.printStackTrace();
                //}
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Decompress_file.this,MainActivity.class);
                startActivity(i);
            }
        });

        browseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File CameraDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString()));
            }
        });

    }
}
