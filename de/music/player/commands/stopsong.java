package de.music.player.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.music.player.Plugin;

public class StopSong implements CommandExecutor {
	
	public StopSong(Plugin plugin) {
		plugin.getCommand("stopsong").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args) {
		
		if(sender.hasPermission("musicplayer.play") == false){
			sender.sendMessage(Plugin.plugin.mm.error_no_permissions);
			return true;
		}
		
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(Plugin.plugin.sm.checkSong(p) == true){
				Plugin.plugin.sm.stopSong(p);
				if(Plugin.playing_songs.containsKey(p)){
					Plugin.playing_songs.remove(p);
				}
				p.sendMessage(Plugin.plugin.mm.music_stopped);
				return true;
			}
			p.sendMessage(Plugin.plugin.mm.error_no_music_to_stop);
		}
		
		return false;
	}
}
