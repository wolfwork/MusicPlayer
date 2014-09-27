package de.music.player.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.Song;

import de.music.player.Plugin;

public class Play implements CommandExecutor {
		
	public Play(Plugin plugin) {
		plugin.getCommand("play").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args) {
		
		if(sender.hasPermission("musicplayer.play") == false){
			sender.sendMessage(Plugin.plugin.mm.error_no_permissions);
			return true;
		}
		if(sender instanceof Player){
			Player p = (Player) sender;
			
			if(args.length == 1){
				if(Plugin.plugin.musicplayer.music_enabled_boolean == false){
					sender.sendMessage(Plugin.plugin.mm.error_music_disabled);
					return true;
				}
				
				Song s = Plugin.plugin.sm.getSong(p, args[0]);
				
				if(Plugin.plugin.sm.checkSong(p) == true){
					p.sendMessage(Plugin.plugin.mm.error_music_already_playing);
					return true;
				}
				if(s != null){
					Plugin.plugin.sm.playSong(p, s);
					p.sendMessage(Plugin.plugin.mm.music_playing.replace("%SONG%", s.getTitle()));
					return true;
				}
				sender.sendMessage(Plugin.plugin.mm.error_song_not_found.replace("%SONG%", args[0]));
				return true;
			}
			sender.sendMessage(Plugin.plugin.mm.help_u2);
		}
		return false;
	}
}
