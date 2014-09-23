package de.music.player.api.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.Song;

import de.music.player.Plugin;

public class getSong {
	
	public static Song get(Player p, String songString){
		
		Song s = null;
		for(Entry<Song, String> songs : Plugin.listed_songs.entrySet()){
			if(songs.getValue().equalsIgnoreCase(songString)){
				s = songs.getKey();
			}
		}
		
		if(s != null){
			return s;
		}
		
		List<Song> song = new ArrayList<>();
		for(Entry<Song, String> songs : Plugin.listed_songs.entrySet()){
			song.add(songs.getKey());
		}
		
		try{
			if(Integer.parseInt(songString) < song.size()){
				s = song.get(Integer.parseInt(songString));
			}
		}catch(NumberFormatException e){
			return null;
		}
			
		return s;
	}

}
