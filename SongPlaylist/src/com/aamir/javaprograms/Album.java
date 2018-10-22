package com.aamir.javaprograms;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if (findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for (Song checkedSong : this.songs){
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }

        }
        return null;
    }

    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> linkedList){
        int index = trackNumber - 1;
        if (index > 0 && index <= this.songs.size()){
            linkedList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track : " + trackNumber);
        return false;
    }

    public boolean addSongToPlaylist(String title, LinkedList<Song> linkedList){
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            linkedList.add(checkedSong);
            return true;
        }
        System.out.println("This song \" " + title + " \" is not in the album");
        return false;
    }
}
