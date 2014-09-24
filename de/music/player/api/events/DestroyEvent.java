package de.music.player.api.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.xxmicloxx.NoteBlockAPI.SongDestroyingEvent;
import com.xxmicloxx.NoteBlockAPI.SongEndEvent;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.SongStoppedEvent;

import de.music.player.Plugin;

public class DestroyEvent implements Listener {
	
	public DestroyEvent(Plugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onDestroy(SongDestroyingEvent e){
		removeFromList(e.getSongPlayer().getPlayerList());
	}
	@EventHandler
	public void onSF(SongEndEvent e){
		removeFromList(e.getSongPlayer().getPlayerList());
	}
	@EventHandler
	public void sff(SongStoppedEvent e){
		removeFromList(e.getSongPlayer().getPlayerList());
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
	private void removeFromList(List<String> playerList) {
		for(String playerstring : playerList){
			Player p = Bukkit.getPlayer(playerstring);
			if(p != null){
				if(Plugin.listed_songs.containsKey(p)){
					Plugin.listed_songs.remove(p);
				}
			}
		}
	}
}
