package com.example.projectmpl;

import androidx.appcompat.app.AppCompatActivity;
import java.io.*;
import java.util.*;
import java.io.*;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private Button btnAll,btnAlreadyRead,btnWanttoRead,btnCurrentlyReading,btnFavorite,btnAbout;
    private EditText input;
    private TextView textView;
    private TextView textt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
      btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = input.getText().toString();
                  WritetoFile("file.txt",content);
            }

        });
btnAbout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent in = new Intent(MainActivity.this,AboutActivity.class);
        startActivity(in);
    }
});
btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
String content = ReadFromFile("file.txt");
textt.setText(content);
    }
});
    }
    public String ReadFromFile(String FileName){
        File path = getApplicationContext().getFilesDir();
                File readFrom = new File(path,FileName);
                byte[] content = new byte[(int) readFrom.length() ];
                try {
    FileInputStream stream = new FileInputStream(readFrom);
    stream.read(content);
    return new String(content);
                } catch (Exception e){
                    e.printStackTrace();
                    return e.toString();
        }
    }
    public void WritetoFile(String Filename,String content){
        File path = getApplicationContext().getFilesDir();
        try{
            FileOutputStream writer = new FileOutputStream(new File(path,Filename));
        writer.write(content.getBytes());
        writer.close();
            Toast.makeText(getApplicationContext(),"Wrote to file uccessfully" + Filename,Toast.LENGTH_SHORT );
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void initViews(){
        //btnAll=findViewById(R.id.btnAll);
        btnAlreadyRead=findViewById(R.id.btnAlreadyRead);
      //  btnWanttoRead=findViewById(R.id.btnWantToRead);
        btnCurrentlyReading=findViewById(R.id.btnCurrentReading);
      //  btnFavorite=findViewById(R.id.btnSaved);
        btnAbout=findViewById(R.id.btnAbout);
        input=findViewById(R.id.input);
        textt=findViewById(R.id.tex);
    }
}