package com.music_streaming;

import java.util.ArrayList;
import java.util.HashMap;

public class DummyServer {
    private static DummyServer server;
    // Song ID, Song
    private HashMap<Integer, Song> songs = new HashMap<>();

    private DummyServer() {
        songs.put(7, new Song("Put On A Smile", "Bruno Mars", "An Evening With Silk Sonic", 255));
        songs.put(18, new Song("Bed Chem", "Sabrina Carpenter", "Short n' Sweet", 172));
        songs.put(59, new Song("Resume", "Jenevieve", "Division", 180));
        songs.put(22, new Song("Chunky", "Bruno Mars", "24K Magic", 186));
        songs.put(77, new Song("Thinking Out Loud", "Ed Sheeran", "x", 282));
    }

    public static DummyServer getInstance(){
        if(server == null){
            server = new DummyServer();
        }
        return server;
    }

    public HashMap<Integer, Song> getSongs() {
        return songs;
    }
}
