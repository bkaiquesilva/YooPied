package com.edebelzaakso.yoopied;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import yuku.ambilwarna.AmbilWarnaDialog;

public class BBB extends AppCompatActivity {

    TextView topText, bottomText;
    EditText editTop,editBottom;
    private static int RESULT_IMAGE_LOAD = 0;
    private static int RESULT_IMAGE_L = 1;
    Button trepp;
    ImageView imag,imageV;
    private GridView a,b,c,d;
    private DrawerLayout mDrawerLayout,drew,mDrawerLayout1;
    private LinearLayout na,navigation_layout1;
    private ImageView image2,image3,image4,image5, im_emoji1, im_emoji2, im_emoji3, im_emoji4, delet_emoji1, delet_emoji2, delet_emoji3, delet_emoji4;
    private int xDelta;
    private int yDelta;
    RelativeLayout relativo, relaty;
    int mDefaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kox);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout1 = (DrawerLayout) findViewById(R.id.drawer_layout1);
        navigation_layout1 = (LinearLayout) findViewById(R.id.navigation_layout1);
        navigation_layout1.bringToFront();
        drew = (DrawerLayout) findViewById(R.id.drawer_layo);
        na = (LinearLayout) findViewById(R.id.navigation_lay);
        na.bringToFront();
        topText = (TextView) findViewById(R.id.memeTopText);
        bottomText = (TextView) findViewById(R.id.memeBottomText);
        editTop = (EditText) findViewById(R.id.editTop);
        editBottom = (EditText) findViewById(R.id.editBottom);
        trepp = (Button) findViewById(R.id.trep);
        imag = (ImageView) findViewById(R.id.memeImage);
        imageV = (ImageView) findViewById(R.id.memeImag);
        image2= (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        im_emoji1 = (ImageView) findViewById(R.id.im_emoji1);
        im_emoji2 = (ImageView) findViewById(R.id.im_emoji2);
        im_emoji3 = (ImageView) findViewById(R.id.im_emoji3);
        im_emoji4 = (ImageView) findViewById(R.id.im_emoji4);
        delet_emoji1 = (ImageView) findViewById(R.id.delet_emoji1);
        delet_emoji2 = (ImageView) findViewById(R.id.delet_emoji2);
        delet_emoji3 = (ImageView) findViewById(R.id.delet_emoji3);
        delet_emoji4 = (ImageView) findViewById(R.id.delet_emoji4);
        a = (GridView) findViewById(R.id.GridView1);
        b = (GridView) findViewById(R.id.GridView2);
        c = (GridView) findViewById(R.id.GridView3);
        d = (GridView) findViewById(R.id.GridView4);
        relativo = (RelativeLayout) findViewById(R.id.relativo);
        relaty = (RelativeLayout) findViewById(R.id.relaty);

        a.setAdapter(new ADT(this));
        b.setAdapter(new ADT(this));
        c.setAdapter(new ADT(this));
        d.setAdapter(new ADT(this));

        mDefaultColor = ContextCompat.getColor(BBB.this, R.color.laranja);

        a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               drew.closeDrawers();
               Integer resourceIda= (Integer)a.getItemAtPosition(position);
                image2.setImageResource(resourceIda);
                a.setVisibility(View.GONE);
                delet_emoji1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.VISIBLE);
                im_emoji1.setVisibility(View.GONE);
            }
        });

        b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drew.closeDrawers();
                Integer resourceIda= (Integer)b.getItemAtPosition(position);
                image3.setImageResource(resourceIda);
                b.setVisibility(View.GONE);
                delet_emoji2.setVisibility(View.VISIBLE);
                image3.setVisibility(View.VISIBLE);
                im_emoji2.setVisibility(View.GONE);
            }
        });

        c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drew.closeDrawers();
                Integer resourceIda= (Integer)c.getItemAtPosition(position);
                image4.setImageResource(resourceIda);
                c.setVisibility(View.GONE);
                delet_emoji3.setVisibility(View.VISIBLE);
                image4.setVisibility(View.VISIBLE);
                im_emoji3.setVisibility(View.GONE);
            }
        });

        d.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drew.closeDrawers();
                Integer resourceIda= (Integer)d.getItemAtPosition(position);
                image5.setImageResource(resourceIda);
                d.setVisibility(View.GONE);
                delet_emoji4.setVisibility(View.VISIBLE);
                image5.setVisibility(View.VISIBLE);
                im_emoji4.setVisibility(View.GONE);
            }
        });

        im_emoji1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drew.openDrawer(Gravity.CENTER);
                a.setVisibility(View.VISIBLE);
                mDrawerLayout1.closeDrawers();
            }
        });

        im_emoji2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drew.openDrawer(Gravity.CENTER);
                b.setVisibility(View.VISIBLE);
                mDrawerLayout1.closeDrawers();
            }
        });

        im_emoji3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drew.openDrawer(Gravity.CENTER);
                c.setVisibility(View.VISIBLE);
                mDrawerLayout1.closeDrawers();
            }
        });

        im_emoji4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drew.openDrawer(Gravity.CENTER);
                d.setVisibility(View.VISIBLE);
                mDrawerLayout1.closeDrawers();
            }
        });

        delet_emoji1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im_emoji1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.GONE);
                delet_emoji1.setVisibility(View.GONE);
                mDrawerLayout1.closeDrawers();
            }
        });

        delet_emoji2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im_emoji2.setVisibility(View.VISIBLE);
                image3.setVisibility(View.GONE);
                delet_emoji2.setVisibility(View.GONE);
                mDrawerLayout1.closeDrawers();
            }
        });

        delet_emoji3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im_emoji3.setVisibility(View.VISIBLE);
                image4.setVisibility(View.GONE);
                delet_emoji3.setVisibility(View.GONE);
                mDrawerLayout1.closeDrawers();
            }
        });

        delet_emoji4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im_emoji4.setVisibility(View.VISIBLE);
                image5.setVisibility(View.GONE);
                delet_emoji4.setVisibility(View.GONE);
                mDrawerLayout1.closeDrawers();
            }
        });

        image2.setOnTouchListener(onTouchListener2());
        image3.setOnTouchListener(onTouchListener2());
        image4.setOnTouchListener(onTouchListener2());
        image5.setOnTouchListener(onTouchListener2());

        editTop.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                topText.setShadowLayer(3.0f, 1.5f, 2.0f, Color.BLACK);
                Typeface font = Typeface.createFromAsset(getAssets(), "fonts/frijole.ttf");
                topText.setTypeface(font);
                topText.setText(s);
            }
        });


        editBottom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bottomText.setShadowLayer(3.0f, 1.5f, 2.0f, Color.BLACK);
                Typeface font = Typeface.createFromAsset(getAssets(), "fonts/frijole.ttf");
                bottomText.setTypeface(font);
                bottomText.setText(s);
            }
        });

        trepp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);
                mDrawerLayout.closeDrawers();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_IMAGE_LOAD && resultCode == RESULT_OK && null!= data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturPath = cursor.getString(columnIndex);
            cursor.close();

            imag.setImageBitmap(BitmapFactory.decodeFile(picturPath));

            Bitmap realImage = BitmapFactory.decodeFile(picturPath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            realImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] b = baos.toByteArray();

            String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

            SharedPreferences shre = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor edit=shre.edit();
            edit.putString("image_dat",encodedImage);
            edit.commit();
        }else {
            if (requestCode == RESULT_IMAGE_L && resultCode == RESULT_OK && null!= data) {
                Uri selectedImag = data.getData();
                String[] filePathColum = {MediaStore.Images.Media.DATA};

                Cursor curso = getContentResolver().query(selectedImag, filePathColum, null, null, null);
                curso.moveToFirst();

                int columnInde = curso.getColumnIndex(filePathColum[0]);
                String picturPat = curso.getString(columnInde);
                curso.close();

                imageV.setImageBitmap(BitmapFactory.decodeFile(picturPat));

                Bitmap realImage = BitmapFactory.decodeFile(picturPat);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                realImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] b = baos.toByteArray();

                String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

                SharedPreferences shre = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor edit=shre.edit();
                edit.putString("image_da",encodedImage);
                edit.commit();
            }
        }
    }

    public void hideKeyboard(View view)
    {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken() , 0);
    }

    public static Bitmap getScreenshot(View view)
    {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public void store(Bitmap bm , String filename) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(" dd-MM-yyyy (HH:mm:ss)");
        String formatted_date = df.format(c.getTime());
        filename = getString(R.string.app_minusculo) + formatted_date + ".jpeg";

        final File path =
                new File(Environment.getExternalStorageDirectory()+ "/YooPied");

        if (!path.exists()) {
            path.mkdirs();
        }

        final File file = new File(path, filename);

        try {
            final FileOutputStream fos = new FileOutputStream(file);
            final BufferedOutputStream bos = new BufferedOutputStream(fos, 8192);

            bm.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();

            BBB.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));

            AlertDialog.Builder builder = new AlertDialog.Builder(BBB.this);
            builder.setMessage("Sua imagem foi salva na galeria.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Uri photoURI = FileProvider.getUriForFile(BBB.this,
                            "com.edebelzaakso.yoopied.fileprovider",
                            file);

                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    shareIntent.setType("image/*");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Feito com " + getString(R.string.app_name) + ".  https://play.google.com/store/apps/details?id=com.edebelzaakso.yoopied");
                    startActivity(Intent.createChooser(shareIntent, "Compartilhe via..."));
                }
            });

            builder.setCancelable(false);
            builder.create().show();

        } catch (final IOException e) {
            Toast.makeText(BBB.this, "ERRO", Toast.LENGTH_SHORT).show();
        }
    }

    public void top(View view) {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                topText.setTextColor(mDefaultColor);
            }
        });
        colorPicker.show();
    }

    public void bottom(View view) {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                bottomText.setTextColor(mDefaultColor);
            }
        });
        colorPicker.show();
    }

    @Override
    protected void onResume() {
        SharedPreferences shr = PreferenceManager.getDefaultSharedPreferences(BBB.this);
        String previouslyEncodedImag = shr.getString("image_da", "");

        if (!previouslyEncodedImag.equalsIgnoreCase("")) {
            byte[] ba = Base64.decode(previouslyEncodedImag, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(ba, 0, ba.length);
            imageV.setImageBitmap(bitmap);
        }
        String previouslyEncodedImage = shr.getString("image_dat", "");

        if (!previouslyEncodedImage.equalsIgnoreCase("")) {
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            imag.setImageBitmap(bitmap);
        }
        super.onResume();
    }


    @Override
    protected void onRestart() {
        SharedPreferences shr = PreferenceManager.getDefaultSharedPreferences(BBB.this);
        String previouslyEncodedImag = shr.getString("image_da", "");

        if (!previouslyEncodedImag.equalsIgnoreCase("")) {
            byte[] ba = Base64.decode(previouslyEncodedImag, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(ba, 0, ba.length);
            imageV.setImageBitmap(bitmap);
        }
        String previouslyEncodedImage = shr.getString("image_dat", "");

        if (!previouslyEncodedImage.equalsIgnoreCase("")) {
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            imag.setImageBitmap(bitmap);
        }
        super.onRestart();
    }

    public void tre(View view) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, RESULT_IMAGE_L);
    }

    public void gad(View view) {
            Intent intent = new Intent(Intent.ACTION_PICK , MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent , RESULT_IMAGE_LOAD);
    }

    public void salve(View view) {
        View content = findViewById(R.id.relativeLayout);

        Bitmap bitmap = getScreenshot(content);
        String currentImage = getString(R.string.app_name) + System.currentTimeMillis() + ".jpeg";
        store(bitmap, currentImage);
    }


    private View.OnTouchListener onTouchListener2() {
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:
                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }
                relativo.invalidate();
                return true;
            }
        };
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent inten = new Intent(BBB.this, MainExMeme.class);
        startActivity(inten);
        finish();
    }

    public void retote(View view) {
        onBackPressed();
    }

    public void aemo(View view) {
        mDrawerLayout1.openDrawer(Gravity.START);
    }

    public void anovo(View view) {
        SharedPreferences shre1 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit1=shre1.edit();
        edit1.remove("image_da");
        edit1.remove("image_dat");
        edit1.commit();
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    public void atexto(View view) {
        mDrawerLayout.openDrawer(Gravity.START);
    }
}