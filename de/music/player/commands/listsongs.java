package de.music.player.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.music.player.MessageManager;

public class listsongs implements CommandExecutor {
			
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args) {
		
		if(sender.hasPermission("musicplayer.listsongs") == false){
			sender.sendMessage(MessageManager.error_no_permissions);
			return true;
		}
		
		musicplayer.listSongs(sender);
		
//		for(Entry<Song, String> songs : Plugin.listed_songs.entrySet()){
//			Song s = songs.getKey();
//			sender.sendMessage(s.getTitle() + " by " + s.getAuthor());
//		}
		
		return false;
	}
}
