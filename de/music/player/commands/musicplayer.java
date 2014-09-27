package de.music.player.commands;

import java.util.List;
import java.util.Map.Entry;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

import de.music.player.Plugin;
import de.music.player.methods.listSongs;

public class MusicPlayer implements CommandExecutor {
	
	boolean music_enabled_boolean = true;
	
	public MusicPlayer(Plugin plugin) {
		plugin.getCommand("musicplayer").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args) {
		
		if(args.length == 1){
//			reloadsongs / list / disableMusic / enableMusic / stopall / PlayingSongs
			
			if(args[0].equalsIgnoreCase("playingsongs")){
				if(sender.hasPermission("music.playingsongs")){
					playingsongs(sender);
					return true;
				}
				sender.sendMessage(Plugin.plugin.mm.error_no_permissions);
				return true;
			}
			if(args[0].equalsIgnoreCase("reloadsongs")){ 
				if(sender.hasPermission("music.reloadsongs")){
					reloadSongs(sender);
					return true;
				}
				sender.sendMessage(Plugin.plugin.mm.error_no_permissions);
				return true;
			}
			if(args[0].equalsIgnoreCase("listsongs")){
				if(sender.hasPermission("music.listsongs")){
					listSongs(sender);
					return true;
				}
				sender.sendMessage(Plugin.plugin.mm.error_no_permissions);
				return true;
			}
			if(args[0].equalsIgnoreCase("disableMusic")){
				if(sender.hasPermission("music.disableMusic")){
					disableMusic(sender);
					return true;
				}
				sender.sendMessage(Plugin.plugin.mm.error_no_permissions);
				return true;
			}
			if(args[0].equalsIgnoreCase("enableMusic")){
				if(sender.hasPermission("music.enableMusic")){
					enableMusic(sender);
					return true;
				}
				sender.sendMessage(Plugin.plugin.mm.error_no_permissions);
				return true;
			}
			if(args[0].equalsIgnoreCase("stopall")){
				if(sender.hasPermission("music.stopall")){
					stopall();
					return true;
				}
				
				sender.sendMessage(Plugin.plugin.mm.error_no_permissions);
				return true;
			}
			
		} else if (args.length == 2){
//			disableSong <song> / enableSong <Song>
			
//			if(args[0].equalsIgnoreCase("disablesong")){	if(sender.hasPermission("music.enablesong"))		{ stopall(); 				} else {sender.sendMessage(error_no_permissions);}} else { return true; }
//			if(args[0].equalsIgnoreCase("enablesong")){ 	if(sender.hasPermission("music.disablesong"))		{ stopall(); 				} else {sender.sendMessage(error_no_permissions);}} else { return true; }
			
		} else {
			if(sender.hasPermission("musicplayer.adminhelp")){
				sender.sendMessage(Plugin.plugin.mm.help_a1);
				sender.sendMessage(Plugin.plugin.mm.help_a2);
				sender.sendMessage(Plugin.plugin.mm.help_a3);
				sender.sendMessage(Plugin.plugin.mm.help_a4);
				sender.sendMessage(Plugin.plugin.mm.help_a5);
				sender.sendMessage(Plugin.plugin.mm.help_a6);
				sender.sendMessage(Plugin.plugin.mm.help_a7);
				sender.sendMessage(Plugin.plugin.mm.help_u1);
				sender.sendMessage(Plugin.plugin.mm.help_u2);
				sender.sendMessage(Plugin.plugin.mm.help_u3);
				sender.sendMessage(Plugin.plugin.mm.help_u4);
				return true;
			}else if(sender.hasPermission("musicplayer.userhelp")){
				sender.sendMessage(Plugin.plugin.mm.help_u1);
				sender.sendMessage(Plugin.plugin.mm.help_u2);
				sender.sendMessage(Plugin.plugin.mm.help_u3);
				sender.sendMessage(Plugin.plugin.mm.help_u4);
				return true;
			}
		}
		
		return false;
	}
	private void playingsongs(CommandSender sender) {
		for(Entry<Player, SongPlayer> songs : Plugin.playing_songs.entrySet()){
			sender.sendMessage("§a" + songs.getKey().getName() + "§f: " + songs.getValue().getSong().getTitle());
		}
	}
	private void enableMusic(CommandSender sender) {
		music_enabled_boolean = true;
		sender.sendMessage(Plugin.plugin.mm.music_enabled);
	}
	private void stopall() {
		for(Entry<Player, SongPlayer> songs : Plugin.playing_songs.entrySet()){
			Plugin.plugin.sm.stopSong(songs.getKey());
		}
	}
	private void disableMusic(CommandSender sender) {
		stopall();
		music_enabled_boolean = false;
		sender.sendMessage(Plugin.plugin.mm.music_disabled);
	}
	public static void listSongs(CommandSender sender) {
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
	}
	private void reloadSongs(CommandSender sender) {
		sender.sendMessage(Plugin.plugin.mm.reload_songs);
		Plugin.listed_songs = Plugin.plugin.sm.loadAllSongs();
	}
}
