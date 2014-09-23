package de.music.player.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.Song;

import de.music.player.MessageManager;
import de.music.player.SongManager;

public class play implements CommandExecutor {
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args) {
		
		if(sender.hasPermission("musicplayer.play") == false){
			sender.sendMessage(MessageManager.error_no_permissions);
			return true;
		}
		if(sender instanceof Player){
			Player p = (Player) sender;
			
			if(args.length == 1){
				if(musicplayer.music_enabled_boolean == false){
					sender.sendMessage(MessageManager.error_music_disabled);
					return true;
				}
				
				Song s = SongManager.getSong(p, args[0]);
				
				if(SongManager.checkSong(p) == true){
					p.sendMessage(MessageManager.error_music_already_playing);
					return true;
				}
				if(s != null){
					SongManager.playSong(p, s);
					p.sendMessage(MessageManager.music_playing.replace("%SONG%", s.getTitle()));
					return true;
				}
				sender.sendMessage(MessageManager.error_song_not_found.replace("%SONG%", args[0]));
				return true;
			}
			sender.sendMessage(MessageManager.help_u2);
		}
		return false;
	}
}
