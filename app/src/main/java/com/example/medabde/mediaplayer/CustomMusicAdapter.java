package com.example.medabde.mediaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomMusicAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<Music> arrayList;
    private MediaPlayer mediaPlayer;
    private boolean state = true;


    public CustomMusicAdapter(Context context, int layout, ArrayList<Music> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    private class ViewHolder{
        TextView textName,textArtistName;
        ImageView play,stop;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);

            holder.textName = convertView.findViewById(R.id.musicname);
            holder.textArtistName = convertView.findViewById(R.id.musicartist);

            holder.play = convertView.findViewById(R.id.play);
            holder.stop = convertView.findViewById(R.id.stop);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        final Music music = arrayList.get(position);

        holder.textName.setText(music.getSongName());
        holder.textArtistName.setText(music.getArtistName());



        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer ==null) mediaPlayer = MediaPlayer.create(context,music.getSong());
                if (state) {

                    mediaPlayer.start();
                    holder.play.setImageResource(R.drawable.pause);
                    state = !state;
                }else {
                    mediaPlayer.pause();
                    holder.play.setImageResource(R.drawable.play);
                    state = !state;
                }


            }
        });

        holder.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer !=null) {
                    holder.play.setImageResource(R.drawable.play);
                    mediaPlayer.release();
                    mediaPlayer=null;
                    state = !state;
                }
            }
        });


        return convertView;
    }
}
