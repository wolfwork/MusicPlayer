package de.music.player.api.methods;

import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.SongPlayer;

import de.music.player.Plugin;

public class stopSong {

	public static void stop(Player p) {
		SongPlayer sp = Plugin.playing_songs.get(p);
		sp.setPlaying(false);
		sp.destroy();
		if(Plugin.playing_songs.containsKey(p)){
			Plugin.playing_songs.remove(p);
		}
	}
}
