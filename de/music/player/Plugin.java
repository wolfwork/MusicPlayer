package de.music.player;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

import de.music.player.api.events.DestroyEvent;
import de.music.player.commands.listsongs;
import de.music.player.commands.musicplayer;
import de.music.player.commands.play;
import de.music.player.commands.stopsong;

public class Plugin extends JavaPlugin {
	
	public static HashMap<Player, SongPlayer> playing_songs = new HashMap<>();
	public static HashMap<Song, String> listed_songs = new HashMap<>();
		
	DestroyEvent destroyEvent;
	
	@Override
	public void onEnable() {
		
		destroyEvent = new DestroyEvent(this);
		listed_songs = SongManager.loadAllSongs();
		
		this.getCommand("musicplayer").setExecutor(new musicplayer());
		this.getCommand("listsongs").setExecutor(new listsongs());
		this.getCommand("play").setExecutor(new play());
		this.getCommand("stopsong").setExecutor(new stopsong());
		
	}
	
	@Override
	public void onDisable(){
		for(Entry<Player, SongPlayer> songs : playing_songs.entrySet()){
			SongManager.stopSong(songs.getKey());
		}
	}
}
