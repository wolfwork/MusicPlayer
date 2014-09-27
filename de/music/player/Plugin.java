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
import de.music.player.commands.ListSongs;
import de.music.player.commands.MusicPlayer;
import de.music.player.commands.Play;
import de.music.player.commands.StopSong;

public class Plugin extends JavaPlugin {
	
	public static HashMap<Player, SongPlayer> playing_songs = new HashMap<>();
	public static HashMap<Song, String> listed_songs = new HashMap<>();
	
	File config_file = new File("plugins/MusicPlayer/config.yml");
	FileConfiguration file_config = YamlConfiguration.loadConfiguration(config_file);
	
	File lang_file = new File("plugins/MusicPlayer/lang.yml");
	FileConfiguration file_lang = YamlConfiguration.loadConfiguration(config_file);
	
	public DestroyEvent destroyEvent;
	public MusicPlayer musicplayer;
	public ListSongs listsongs;
	public Play play;
	public StopSong stopsong;
	public SongManager sm;
	public MessageManager mm;
	public FileManager fm;
	public static Plugin plugin;
	
	@Override
	public void onEnable() {
		destroyEvent = new DestroyEvent(this);
		musicplayer = new MusicPlayer(this);
		listsongs = new ListSongs(this);
		play = new Play(this);
		stopsong = new StopSong(this);
		
		sm = new SongManager();
		mm = new MessageManager();
		fm = new FileManager();
		plugin = this;
		
		if(fm.checkConfig(this) == false){
			fm.createConfig(this);
		}
		fm.loadConfig(this);
		mm.load(this);
		
		listed_songs = sm.loadAllSongs();
	}
	@Override
	public void onDisable(){
		for(Entry<Player, SongPlayer> songs : playing_songs.entrySet()){
			sm.stopSong(songs.getKey());
		}
	}
}
