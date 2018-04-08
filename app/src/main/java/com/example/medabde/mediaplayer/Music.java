package com.example.medabde.mediaplayer;

public class Music {
    private String songName;
    private String artistName;
    private int song;


    public Music(String songName, String artistName, int song) {
        this.songName = songName;
        this.artistName = artistName;
        this.song = song;
    }


    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
