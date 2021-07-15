package com.edebelzaakso.yoopied;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SCN extends AppCompatActivity {

    private Button cont, mais;
    private ImageView imv;
    private TextView info, pesquisa,titu;
    Typeface font;
    private static final int MY_PERMISSION = 1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scn);

        mais = (Button) findViewById(R.id.mais);
        cont = (Button) findViewById(R.id.splash_next_imagebutton);
        progressBar = (ProgressBar) findViewById(R.id.progr);
        imv = (ImageView)findViewById(R.id.video_img);
        info = (TextView)findViewById(R.id.inform);
        titu = (TextView)findViewById(R.id.tit);
        pesquisa = (TextView)findViewById(R.id.pesquisa);
        font = Typeface.createFromAsset(getAssets(), "fonts/frijol.ttf");
        mais.setTypeface(font);
        pesquisa.setTypeface(font);
        cont.setTypeface(font);
        titu.setTypeface(font);
        info.setTypeface(font);

        if (ContextCompat.checkSelfPermission(SCN.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(SCN.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(SCN.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION);
            } else {
                ActivityCompat.requestPermissions(SCN.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION);
            }
        } else {
        }

        info.setText("Na {e}debelzaak s.o, acreditamos que é possível evoluir sem causar grandes danos a natureza, não por em risco a saúde dos seres vivos ao criar tecnologias e fazer ciência sem pensar no lucro." + "\n" + "\n" + "A {e}debelzaak s.o foi fundada em 316 N.E(Nosso calendário). Só viemos a existir para combater a desinformação, criar tecnologias, desenvolver pesquisas na área científica, recuperar dados sobre a história humana, desenvolver softwares e trabalhar com a possibilidade de haver vida fora do nosso planeta. Pertencente a Kaíque Silva de Águas Formosas, MG - Brasil.");

        mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentcjhghfj = new Intent(Intent.ACTION_VIEW, Uri.parse("http://edebelzaakso.rf.gd/?i=1"));
                startActivity(intentcjhghfj);
            }
        });

        imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCkgzIk7ug_KWyzDIN4oISdA"));
                startActivity(browser);
            }
        });

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(SCN.this, MainExMeme.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(SCN.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                    }
                } else {
                }
            }
        }
    }
}