package de.music.player.api.methods;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.xxmicloxx.NoteBlockAPI.NBSDecoder;
import com.xxmicloxx.NoteBlockAPI.Song;

public class getAllSongs {
	
	public static HashMap<Song, String> get() {
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
