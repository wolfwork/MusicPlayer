package de.music.player;

import java.util.HashMap;

import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.Song;

import de.music.player.api.methods.checkSong;
import de.music.player.api.methods.getAllSongs;
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
		return getAllSongs.get();
	}
}
