package de.music.player;

public class MessageManager {

//	help commands: (a = Admin Help / u = User help)
	public static String help_a1 = "§a-- Music Player Admin Commands --";
	public static String help_a2 = "/musicplayer reloadsongs";
	public static String help_a3 = "/musicplayer listsongs";
	public static String help_a4 = "/musicplayer disableMusic";
	public static String help_a5 = "/musicplayer enableMusic";
	public static String help_a9 = "/musicplayer stopall";
	public static String help_u1 = "§a-- Music Player User Commands --";
	public static String help_u2 = "/play <Song>";
	public static String help_u3 = "/stop";
	public static String help_u4 = "/listsongs";
	
//	error commands:
	public static String error_song_not_found = "§cError: The Song: %SONG% was not found! Please check!";
	public static String error_music_disabled = "§cError: The Music was disabled! Please contact an Administrator!";
	public static String error_no_permissions = "§cError: You do not have enough permissions to perform this command!";
	public static String error_no_music_to_stop = "§cError: You cant stop no song.";
	public static String error_music_already_playing = "§cError: You already have an active song!";
	
//	info messages:
	public static String reload_songs = "§cWarning: All songs have been reloaded!";
	public static String music_enabled = "§cThe Music was enabled for the whole Server!";
	public static String music_disabled = "§cThe Music was disabled for the whole Server!";
	public static String music_playing = "§aNow playing: %SONG%";
	public static String music_all_songs = "§aAll Songs: ";
	public static String music_stopped = "§cThe music stopped!";
	
	
	public static void load(Plugin plugin) {
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
