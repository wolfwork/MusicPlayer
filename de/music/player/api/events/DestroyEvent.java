package de.music.player.api.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.xxmicloxx.NoteBlockAPI.SongDestroyingEvent;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

import de.music.player.Plugin;

public class DestroyEvent implements Listener {
	
	public DestroyEvent(Plugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onDestroy(SongDestroyingEvent e){
		SongPlayer sp = e.getSongPlayer();
		if(Plugin.playing_songs.containsValue(sp)){
			for(String p : sp.getPlayerList()){
				if(Bukkit.getPlayer(p) != null){
					Plugin.playing_songs.remove(p);
				}
			}
		}
	}
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		stopSongs(e.getPlayer());
	}
	@EventHandler
	public void onQUit(PlayerKickEvent e){
		stopSongs(e.getPlayer());
	}
	private void stopSongs(Player p){
		if(Plugin.playing_songs.containsKey(p)){
			SongPlayer sp = Plugin.playing_songs.get(p);
			if(Plugin.playing_songs.containsKey(p)){
				Plugin.playing_songs.remove(p);
			}
			sp.destroy();
		}
	}
}
