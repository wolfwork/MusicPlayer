package de.music.player.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.Song;

import de.music.player.Plugin;
import de.music.player.methods.listSongs;

public class ListSongs implements CommandExecutor {
			
	public ListSongs(Plugin plugin) {
		plugin.getCommand("listsongs").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args) {
		
		if(sender.hasPermission("musicplayer.listsongs") == false){
			sender.sendMessage(Plugin.plugin.mm.error_no_permissions);
			return true;
		}
		
		List<Song> songs = listSongs.getList();
		
		sender.sendMessage(Plugin.plugin.mm.music_all_songs);
		
		for(int i = 0; i < songs.size(); i++){
			if(sender instanceof Player){
				Player p = (Player) sender;
				p.sendMessage("§a" + i + ": §f" + songs.get(i).getTitle());
			} else {
				sender.sendMessage(i + ": " + songs.get(i).getTitle());
			}
		}
		
		return false;
	}
}
