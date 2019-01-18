package de.funit.system.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			p.sendMessage(" ");
			p.sendMessage(" §8» §9§lDiscord §8» §e§lhttps://discord.gg/ar5wtAU");
			p.sendMessage(" ");

		}

		return false;
	}

}
