package com.music_streaming;

import java.util.List;

public interface SongServiceTemplate {
    Song searchById(Integer songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}
