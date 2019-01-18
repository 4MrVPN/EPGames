package de.funit.system.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.funit.system.Main;

public class BroadcastCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if(!s.hasPermission("system.broadcast")) {
			s.sendMessage(Main.getNoPermission());
			return true;
		}
		
		if (args.length >= 1) {
			String message = args[0];
			for (int i = 1; i < args.length; i++) {
				message = message + " " + args[i];
			}
			message = message.replace("&", "§");
			
			Bukkit.broadcastMessage("§8»");
			Bukkit.broadcastMessage("§e§lRUNDRUF");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("§4" + message);
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("§8»");
		}else {
			s.sendMessage(Main.getPrefix() + "§7Nutze: /bc (§eNachricht§7)");
		}
		return false;
	}
}
