package com.aamir.javaprograms;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Latest Songs", "Arijit Singh");
        album.addSong("Tumhi ho", 4.5);
        album.addSong("Muskurane", 4.1);
        album.addSong("Chanda", 3.5);
        album.addSong("Wajah tum ho", 4.6);
        album.addSong("Barish", 3.9);
        album.addSong("Tu hi hai", 4.0);
        album.addSong("Tera fitoor", 3.58);
        album.addSong("Kah do na", 3.8);

        albums.add(album);

        album = new Album("New Songs", "Atif Aslam");
        album.addSong("Tajedare haram", 10.5);
        album.addSong("O sathi", 4.1);
        album.addSong("Dekhte Dekhte", 5.1);
        album.addSong("Mahiya ve soniya", 2.6);
        album.addSong("Gulabi ankhen", 3.9);
        album.addSong("Barish by atif", 3.0);
        album.addSong("Paniyon sa", 4.58);
        album.addSong("Pehli nazar me", 3.8);

        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addSongToPlaylist("Tumhi ho", playlist);
        albums.get(0).addSongToPlaylist("Barish", playlist);
        albums.get(0).addSongToPlaylist("Chanda", playlist);
        albums.get(0).addSongToPlaylist("Song nahi", playlist); //Doesn't exist in album
        albums.get(0).addSongToPlaylist(8, playlist);
        albums.get(0).addSongToPlaylist(6, playlist);
        albums.get(1).addSongToPlaylist(2, playlist);
        albums.get(1).addSongToPlaylist(4, playlist);
        albums.get(1).addSongToPlaylist("Paniyon sa", playlist);
        albums.get(1).addSongToPlaylist(8, playlist);
        albums.get(1).addSongToPlaylist(10, playlist); //There is no track 10

        play(playlist);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("There is no song in playlist");
            return;
        } else {
            System.out.println("No Playing : " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist Complete..");
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing.... " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing.. " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are now start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing.. " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at start of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing.. " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached end of playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing.." + listIterator.next().toString());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println(("Now playing.. " + listIterator.previous().toString()));
                        }else {
                            System.out.println("playlist is empty..");
                        }
                    }else {
                        System.out.println("playlist is empty..");
                    }
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions\nPress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay current song\n" +
                "4 - to print the list of songs in playlist\n" +
                "5 - to print available actions." +
                "6 - to delete current song");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("===========================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===========================");
    }
}
