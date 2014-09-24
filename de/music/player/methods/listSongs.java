package de.music.player.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.xxmicloxx.NoteBlockAPI.Song;

import de.music.player.Plugin;

public class listSongs {
	
	public static List<Song> getList() {
		List<Song> song = new ArrayList<>();
		for(Entry<Song, String> songs : Plugin.listed_songs.entrySet()){
			song.add(songs.getKey());
		}
		return song;
	}

}
