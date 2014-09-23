package de.music.player;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.NBSDecoder;
import com.xxmicloxx.NoteBlockAPI.Song;

import de.music.player.api.methods.checkSong;
import de.music.player.api.methods.playSong;
import de.music.player.api.methods.stopSong;

public class SongManager {
		
	public static void playSong(Player p, Song s){
		playSong.start(s, p);
	}
	public static void stopSong(Player p){
		stopSong.stop(p);
	}
	public static boolean checkSong(Player p){
		if(checkSong.check(p) == true){
			return true;
		}
		return false;
	}
	public static Song getSong(Player p, String songString){
		return de.music.player.api.methods.getSong.get(p, songString);
	}
	
	
	public static HashMap<Song, String> loadAllSongs() {
		HashMap<Song, String> songs_listed = new HashMap<>();
		File dir = new File("plugins/MusicPlayer/songs");
		List<File> files_songs = listFiles(dir);
		
		for(File f : files_songs) {
			if(f.getName().contains(".nbs")){
				songs_listed.put(NBSDecoder.parse(f), f.getName().replace(".nbs", "").replace(" ", "_"));
			}
		}
		return songs_listed;
	}
	private static List<File> listFiles(File dir) {
        File[] files = dir.listFiles();
        List<File> matches = new ArrayList<File> ();
        if (files != null) {
            for (int i = 0; i < files.length; i++){
                matches.add(files[i]);
            }
        }
        return matches;
    }
}
