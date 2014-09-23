package de.music.player.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.music.player.MessageManager;
import de.music.player.Plugin;
import de.music.player.SongManager;

public class stopsong implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args) {
		
		if(sender.hasPermission("musicplayer.play") == false){
			sender.sendMessage(MessageManager.error_no_permissions);
			return true;
		}
		
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(SongManager.checkSong(p) == true){
				SongManager.stopSong(p);
				if(Plugin.playing_songs.containsKey(p)){
					Plugin.playing_songs.remove(p);
				}
				return true;
			}
			p.sendMessage(MessageManager.error_no_music_to_stop);
		}
		
		return false;
	}
}
