package de.music.player.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

import de.music.player.MessageManager;
import de.music.player.Plugin;
import de.music.player.SongManager;

public class musicplayer implements CommandExecutor {
	
	static boolean music_enabled_boolean = true;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args) {
		
//		reloadSongs / list / disableSong <song> / enableSong <song> / disableMusic / enableMusic / playall <song> / stopall
		if(args.length == 1){
//			reloadsongs / list / disableMusic / enableMusic / stopall
			
			if(args[0].equalsIgnoreCase("reloadsongs")){ 
				if(sender.hasPermission("music.reloadsongs")){
					reloadSongs(sender);
					return true;
				}
				sender.sendMessage(MessageManager.error_no_permissions);
				return true;
			}
			if(args[0].equalsIgnoreCase("listsongs")){
				if(sender.hasPermission("music.listsongs")){
					listSongs(sender);
					return true;
				}
				sender.sendMessage(MessageManager.error_no_permissions);
				return true;
			}
			if(args[0].equalsIgnoreCase("disableMusic")){
				if(sender.hasPermission("music.disableMusic")){
					disableMusic(sender);
					return true;
				}
				sender.sendMessage(MessageManager.error_no_permissions);
				return true;
			}
			if(args[0].equalsIgnoreCase("enableMusic")){
				if(sender.hasPermission("music.enableMusic")){
					enableMusic(sender);
					return true;
				}
				sender.sendMessage(MessageManager.error_no_permissions);
				return true;
			}
			if(args[0].equalsIgnoreCase("stopall")){
				if(sender.hasPermission("music.stopall")){
					stopall();
					return true;
				}
				
				sender.sendMessage(MessageManager.error_no_permissions);
				return true;
			}
			
		} else if (args.length == 2){
//			disableSong <song> / enableSong <Song>
			
//			if(args[0].equalsIgnoreCase("disablesong")){	if(sender.hasPermission("music.enablesong"))		{ stopall(); 				} else {sender.sendMessage(error_no_permissions);}} else { return true; }
//			if(args[0].equalsIgnoreCase("enablesong")){ 	if(sender.hasPermission("music.disablesong"))		{ stopall(); 				} else {sender.sendMessage(error_no_permissions);}} else { return true; }
			
		} else {
			if(sender.hasPermission("musicplayer.adminhelp")){
				sender.sendMessage(MessageManager.help_a1);
				sender.sendMessage(MessageManager.help_a2);
				sender.sendMessage(MessageManager.help_a3);
				sender.sendMessage(MessageManager.help_a4);
				sender.sendMessage(MessageManager.help_a5);
				sender.sendMessage(MessageManager.help_a9);
				sender.sendMessage(MessageManager.help_u1);
				sender.sendMessage(MessageManager.help_u2);
				sender.sendMessage(MessageManager.help_u3);
				sender.sendMessage(MessageManager.help_u4);
				return true;
			}else if(sender.hasPermission("musicplayer.userhelp")){
				sender.sendMessage(MessageManager.help_u1);
				sender.sendMessage(MessageManager.help_u2);
				sender.sendMessage(MessageManager.help_u3);
				sender.sendMessage(MessageManager.help_u4);
				return true;
			}
		}
		
		return false;
	}
	private void enableMusic(CommandSender sender) {
		music_enabled_boolean = true;
		sender.sendMessage(MessageManager.music_enabled);
	}
	private void stopall() {
		for(Entry<Player, SongPlayer> songs : Plugin.playing_songs.entrySet()){
			SongManager.stopSong(songs.getKey());
		}
	}
	private void disableMusic(CommandSender sender) {
		stopall();
		music_enabled_boolean = false;
		sender.sendMessage(MessageManager.music_disabled);
	}
	public static void listSongs(CommandSender sender) {
		sender.sendMessage(MessageManager.music_all_songs);
		List<Song> song = new ArrayList<>();
		for(Entry<Song, String> songs : Plugin.listed_songs.entrySet()){
			song.add(songs.getKey());
		}
		for(int i = 0; i < song.size(); i++) {
			sender.sendMessage("§a" + i + "§f: " + song.get(i).getTitle().replace(" ", "_"));
		}
	}
	private void reloadSongs(CommandSender sender) {
		sender.sendMessage(MessageManager.reload_songs);
		Plugin.listed_songs = SongManager.loadAllSongs();
	}
}
