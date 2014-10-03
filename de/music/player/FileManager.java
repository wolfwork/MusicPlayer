package de.music.player;

import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;

public class FileManager {
	
	public void loadConfig(Plugin plugin){
		try {
			plugin.file_config.load(plugin.config_file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		try {
			plugin.file_lang.load(plugin.lang_file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	public void saveConfig(Plugin plugin){
		try {
			plugin.file_config.save(plugin.config_file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			plugin.file_lang.save(plugin.lang_file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean checkLANGConfig(Plugin plugin){
		if(plugin.lang_file.exists() == true){
			return true;
		}
		return false;
	}
	public void createLANGConfig(Plugin plugin) {
		plugin.file_lang.set("error.song.not_found", "&cError: The Song: %SONG% was not found! Please check!");
		plugin.file_lang.set("error.music.disabled", "&cError: The Music was disabled! Please contact an Administrator!");
		plugin.file_lang.set("error.no_permissions", "&cError: You do not have enough permissions to perform this command!");
		plugin.file_lang.set("error.song.no_song_active", "&cError: You cant stop no song.");
		plugin.file_lang.set("error.music.already_playing", "&cError: You already have an active song!");
		plugin.file_lang.set("message.songs_reload", "&cWarning: All songs have been reloaded!");
		plugin.file_lang.set("message.songs_enabled", "&cThe Music was enabled for the whole Server!");
		plugin.file_lang.set("message.songs_disabled", "&cThe Music was disabled for the whole Server!");
		plugin.file_lang.set("message.song_playing", "&aNow playing: %SONG%");
		plugin.file_lang.set("message.list_songs", "&aAll Songs: ");
		plugin.file_lang.set("message.song_stopped", "&cThe music stopped!");
		saveConfig(plugin);
	}
}
