package de.music.player.api.methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

import de.music.player.Plugin;

public class playSong {
	
	private Plugin plugin;
	
	public static void start(Song s, Player p) {
		if(Plugin.playing_songs.containsKey(p) == false){
			SongPlayer sp = new RadioSongPlayer(s);
			sp.setAutoDestroy(true);
			sp.addPlayer(p);
			sp.setPlaying(true);
			Plugin.playing_songs.put(p, sp);
		}
	}
	public void start(final Player p, Song s, int ticks){
		Plugin.plugin.sm.playSong(p, s);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run() {
				Plugin.plugin.sm.stopSong(p);
			}
		}, ticks);
	}
}
