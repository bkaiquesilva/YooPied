package com.edebelzaakso.yoopied;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ADT extends BaseAdapter {
    private Context mContext;

    int[] images= {
            R.drawable.a,R.drawable.e,R.drawable.g,R.drawable.i,R.drawable.j,R.drawable.p,R.drawable.r,R.drawable.x,R.drawable.ag,R.drawable.ar,R.drawable.as,R.drawable.ay,R.drawable.aac,R.drawable.aaj,R.drawable.aal,R.drawable.aap,R.drawable.aar,R.drawable.aaz,R.drawable.aaaa,R.drawable.aaab,R.drawable.aaad,R.drawable.aaaf,R.drawable.aaag,R.drawable.aaai,R.drawable.aaan,R.drawable.aaao,R.drawable.aaap,R.drawable.aaaq,R.drawable.aaaw,R.drawable.aaax,R.drawable.aaaab,R.drawable.aaaac,R.drawable.aaaae,R.drawable.aaaaf,R.drawable.aaaag,R.drawable.aaaah,R.drawable.aaaaj,R.drawable.aaaal,R.drawable.aaaam,R.drawable.aaaap,R.drawable.aaaaq,R.drawable.aaaat,R.drawable.aaaay,R.drawable.aaaaaa,R.drawable.aaaaac,R.drawable.aaaaad
    };
    public ADT(Context c){
        this.mContext=c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(mContext);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(64,64));

        return imageView;
    }
}
