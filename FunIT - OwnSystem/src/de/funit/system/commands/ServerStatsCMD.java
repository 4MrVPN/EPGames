package de.funit.system.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerStatsCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			int registered = Bukkit.getOfflinePlayers().length;
			int online = Bukkit.getOnlinePlayers().size();
			int operators = Bukkit.getOperators().size();
			int plugins = Bukkit.getServer().getPluginManager().getPlugins().length;
			long maxram = Runtime.getRuntime().maxMemory() / 0x100000L;
			long usedram = maxram - Runtime.getRuntime().freeMemory() / 0x100000L;
			
			p.sendMessage("§8» §7Serverstatistiken:");
			p.sendMessage("§eRegistrierte §7Spieler §8» §e" + registered);
			p.sendMessage("§eOnline §7Spieler §8» §e" + online);
			p.sendMessage(" ");
			p.sendMessage("§eOperatoren §8» §e" + operators);
			p.sendMessage("§ePlugins §8» §e" + plugins);
			p.sendMessage("§eWhitelist §8» §e" + Bukkit.getServer().hasWhitelist());
			p.sendMessage(" ");
			p.sendMessage("§eMaximaler §7Arbeitsspeicher §8» §e" + maxram + " §7MB");
			p.sendMessage("§eVerbrauchter §7Arbeitsspeicher §8» §e" + usedram + " §7MB");
			p.sendMessage(" ");

		}

		return false;
	}

}
