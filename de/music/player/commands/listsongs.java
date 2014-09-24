package de.music.player.commands;

import java.util.List;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.Song;

import de.music.player.MessageManager;
import de.music.player.methods.listSongs;

public class listsongs implements CommandExecutor {
			
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args) {
		
		if(sender.hasPermission("musicplayer.listsongs") == false){
			sender.sendMessage(MessageManager.error_no_permissions);
			return true;
		}
		
		List<Song> songs = listSongs.getList();
		
		sender.sendMessage(MessageManager.music_all_songs);
		
		for(int i = 0; i < songs.size(); i++){
			if(sender instanceof Player){
				Player p = (Player) sender;
				IChatBaseComponent comp = ChatSerializer.a("{\"text\":\"\",\"extra\":[{\"text\":\"%SONG_ID%\",\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/play %SONG_ID%\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"Click to hear %SONG_NAME% by %SONG_AUTHOR%\"}}},{\"text\":\": %SONG_NAME%\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/play %SONG_ID%\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"Click to hear %SONG_NAME% by %SONG_AUTHOR%\"}}}]}".replace("%SONG_NAME%", songs.get(i).getTitle()).replace("%SONG_ID%", i + "").replace("%SONG_AUTHOR%", songs.get(i).getAuthor()));
				PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
			} else {
				sender.sendMessage(i + ": " + songs.get(i).getTitle());
			}
		}
		
		return false;
	}
}
