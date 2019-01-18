package de.funit.system.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.funit.system.Main;

public class TeamchatCMD implements CommandExecutor {

	public static ArrayList<Player> tc = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if (!(s instanceof Player))
			return true;
		if (!s.hasPermission("system.teamchat")) {
			s.sendMessage(Main.getNoPermission());
			return true;
		}
		Player p = (Player) s;
		if (args.length >= 1) {
			if (args[0].equalsIgnoreCase("login")) {
				if (tc.contains(p)) {
					p.sendMessage("§8● §e§lTeamChat §8» " + "§7Du bist bereits §eeingeloggt§7!");
					return true;
				} else {
					tc.add(p);
					p.sendMessage("§8● §e§lTeamChat §8» " + "§7Du hast dich §eeingeloggt§7!");

					for (Player all : Bukkit.getOnlinePlayers()) {
						if (tc.contains(all)) {
							all.sendMessage("§8● §e§lTeamChat §8» §e§n" + s.getName() + " §7hat sich eingeloggt!");
						}
					}
				}
			} else if (args[0].equalsIgnoreCase("logout")) {
				if (!tc.contains(p)) {
					p.sendMessage("§8● §e§lTeamChat §8» " + "§7Du bist bereits §eausgeloggt§7!");
					return true;
				} else {
					tc.remove(p);
					p.sendMessage("§8● §e§lTeamChat §8» " + "§7Du hast dich §eausgeloggt§7!");

					for (Player all : Bukkit.getOnlinePlayers()) {
						if (tc.contains(all)) {
							all.sendMessage("§8● §e§lTeamChat §8» §e§n" + s.getName() + " §7hat sich ausgeloggt!");
						}
					}
				}
			} else {
				String message = args[0];
				for (int i = 1; i < args.length; i++) {
					message = message + " " + args[i];
				}
				message = message.replace("&", "§");

				if (!tc.contains(p)) {
					p.sendMessage("§8● §e§lTeamChat §8» " + "§cDu bist ausgeloggt!");
					return true;
				}
				for (Player all : Bukkit.getOnlinePlayers()) {
					if (tc.contains(all)) {
						all.sendMessage("§8● §e§lTeamChat §8» §e§n" + s.getName() + "§7 » " + message);
					}
				}
			}

		} else {
			s.sendMessage("§8● §e§lTeamChat §8» " + "§7Nutze: /tc (§eNachricht, Login, Logout§7)");
		}
		return false;
	}
}
