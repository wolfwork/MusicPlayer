package de.music.player.api.methods;

import org.bukkit.entity.Player;

import de.music.player.Plugin;

public class checkSong {
		
	public static boolean check(Player p){
		if(Plugin.playing_songs.containsKey(p) == true){
			return true;
		}
		return false;
	}
}
