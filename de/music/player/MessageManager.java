package de.music.player;

public class MessageManager {

//	help commands: (a = Admin Help / u = User help)
	public String help_a1 = "§a-- Music Player Admin Commands --";
	public String help_a2 = "/musicplayer reloadsongs";
	public String help_a3 = "/musicplayer listsongs";
	public String help_a4 = "/musicplayer disableMusic";
	public String help_a5 = "/musicplayer enableMusic";
	public String help_a6 = "/musicplayer stopall";
	public String help_a7 = "/musicplayer playingsongs";
	public String help_u1 = "§a-- Music Player User Commands --";
	public String help_u2 = "/play <Song>";
	public String help_u3 = "/stopsog";
	public String help_u4 = "/listsongs";
	
//	error commands:
	public String error_song_not_found = "§cError: The Song: %SONG% was not found! Please check!";
	public String error_music_disabled = "§cError: The Music was disabled! Please contact an Administrator!";
	public String error_no_permissions = "§cError: You do not have enough permissions to perform this command!";
	public String error_no_music_to_stop = "§cError: You cant stop no song.";
	public String error_music_already_playing = "§cError: You already have an active song!";
	
//	info messages:
	public String reload_songs = "§cWarning: All songs have been reloaded!";
	public String music_enabled = "§cThe Music was enabled for the whole Server!";
	public String music_disabled = "§cThe Music was disabled for the whole Server!";
	public String music_playing = "§aNow playing: %SONG%";
	public String music_all_songs = "§aAll Songs: ";
	public String music_stopped = "§cThe music stopped!";
	
	
	public void load(Plugin plugin) {
		error_song_not_found = plugin.file_lang.getString("error.song.not_found").replace("&", "§");
		error_music_disabled = plugin.file_lang.getString("error.music.disabled").replace("&", "§");
		error_no_permissions = plugin.file_lang.getString("error.no_permissions").replace("&", "§");
		error_no_music_to_stop = plugin.file_lang.getString("error.song.no_song_active").replace("&", "§");
		error_music_already_playing = plugin.file_lang.getString("error.music.already_playing").replace("&", "§");
		reload_songs = plugin.file_lang.getString("message.songs_reload").replace("&", "§");
		music_enabled = plugin.file_lang.getString("message.songs_enabled").replace("&", "§");
		music_disabled = plugin.file_lang.getString("message.songs_disabled").replace("&", "§");
		music_playing = plugin.file_lang.getString("message.song_playing").replace("&", "§");
		music_all_songs = plugin.file_lang.getString("message.list_songs").replace("&", "§");
		music_stopped = plugin.file_lang.getString("message.song_stopped").replace("&", "§");
	}
	
}
