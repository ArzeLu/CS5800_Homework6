package com.music_streaming;

import java.util.ArrayList;
import java.util.HashMap;

public class SongService {
    private final DummyServer server = DummyServer.getInstance();
    // No other variables here because the class isn't supposed to have a "cache"

    public HashMap<Integer, Song> getServerSnapshot(){
        return server.getSongs();
    }

    public Song searchById(Integer songID){
        HashMap<Integer, Song> songs = getServerSnapshot();
        Song finding;

        try {
            finding = songs.get(songID);
            Thread.sleep(1000);
        }catch(Exception e){
            finding = null;
        }

        return finding;
    }

    public ArrayList<Song> searchByTitle(String title){
        HashMap<Integer, Song> songs = getServerSnapshot();
        ArrayList<Song> findings = new ArrayList<>();

        try {
            for (Song song : songs.values()) {
                if (song.getTitle().equals(title)) {
                    findings.add(song);
                }
            }

            Thread.sleep(1000);
        }catch(Exception e){

        }

        return findings;
    }

    public ArrayList<Song> searchByAlbum(String album){
        HashMap<Integer, Song> songs = getServerSnapshot();
        ArrayList<Song> findings = new ArrayList<>();

        try {
            for (Song song : songs.values()) {
                if (song.getAlbum().equals(album)) {
                    findings.add(song);
                }
            }
            Thread.sleep(1000);
        }catch(Exception e){

        }

        return findings;
    }
}
