package com.music_streaming;

import java.util.ArrayList;
import java.util.HashMap;

public class SongServiceProxy implements SongServiceTemplate{
    private final DummyServer server = DummyServer.getInstance();
    // The latest "cached" search results
    private Song IDSearchResult;
    private ArrayList<Song> titleSearchResult;
    private ArrayList<Song> albumSearchResult;

    public SongServiceProxy(){
        IDSearchResult = null;
        titleSearchResult = new ArrayList<>();
        albumSearchResult = new ArrayList<>();
    }

    public HashMap<Integer, Song> getServerSnapshot(){
        return server.getSongs();
    }

    public Song searchById(Integer songID){
        HashMap<Integer, Song> songs = getServerSnapshot();
        Song finding = songs.get(songID);
        IDSearchResult = finding;

        return finding;
    }

    public ArrayList<Song> searchByTitle(String title){
        HashMap<Integer, Song> songs = getServerSnapshot();
        ArrayList<Song> findings = new ArrayList<>();

        for(Song song : songs.values()){
            if(song.getTitle().equals(title)){
                findings.add(song);
            }
        }

        titleSearchResult = findings;

        return findings;
    }

    public ArrayList<Song> searchByAlbum(String album){
        HashMap<Integer, Song> songs = getServerSnapshot();
        ArrayList<Song> findings = new ArrayList<>();

        for(Song song : songs.values()){
            if(song.getAlbum().equals(album)){
                findings.add(song);
            }
        }

        albumSearchResult = findings;

        return findings;
    }

    public Song getIDSearchResult(){
        return IDSearchResult;
    }

    public ArrayList<Song> getTitleSearchResult(){
        return titleSearchResult;
    }

    public ArrayList<Song> getAlbumSearchResult(){
        return albumSearchResult;
    }
}
