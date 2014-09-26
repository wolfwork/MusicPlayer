package de.music.player;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
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
	
	File config_file = new File("plugins/MusicPlayer/config.yml");
	FileConfiguration file_config = YamlConfiguration.loadConfiguration(config_file);
	
	File lang_file = new File("plugins/MusicPlayer/lang.yml");
	FileConfiguration file_lang = YamlConfiguration.loadConfiguration(config_file);
	
	DestroyEvent destroyEvent;
	
	@Override
	public void onEnable() {
		
		if(FileManager.checkConfig(this) == false){
			FileManager.createConfig(this);
		}
		FileManager.loadConfig(this);
		MessageManager.load(this);
		
		destroyEvent = new DestroyEvent(this);
		listed_songs = SongManager.loadAllSongs();
		
		loadcommands();
		
	}
	@Override
	public void onDisable(){
		for(Entry<Player, SongPlayer> songs : playing_songs.entrySet()){
			SongManager.stopSong(songs.getKey());
		}
	}
	
	
	private void loadcommands() {
		this.getCommand("musicplayer").setExecutor(new musicplayer());
		this.getCommand("listsongs").setExecutor(new listsongs());
		this.getCommand("play").setExecutor(new play());
		this.getCommand("stopsong").setExecutor(new stopsong());
	}
}
