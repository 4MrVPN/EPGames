package de.funit.system.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.funit.system.Main;

public class GamemodeCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if (!(s instanceof Player))
			return true;

		if (!s.hasPermission("system.gamemode")) {
			s.sendMessage(Main.getNoPermission());
			return true;
		}
		
		Player p = (Player) s;
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
		
		if (a.length == 1) {
			if (a[0].equalsIgnoreCase("1") || a[0].equalsIgnoreCase("c")) {
				if (!p.hasPermission("system.gamemode.1")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}
				p.setGameMode(GameMode.CREATIVE);
				
				p.sendMessage(Main.getPrefix() + "ß7Du bist nun im ßeKreativmodusß7!");

			} else if (a[0].equalsIgnoreCase("0") || a[0].equalsIgnoreCase("s")) {
				if (!p.hasPermission("system.gamemode.0")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}

				p.setGameMode(GameMode.SURVIVAL);
				
				p.sendMessage(Main.getPrefix() + "ß7Du bist nun im ße‹berlebensmodusß7!");

			} else if (a[0].equalsIgnoreCase("2") || a[0].equalsIgnoreCase("a")) {
				if (!p.hasPermission("system.gamemode.2")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}
				p.setGameMode(GameMode.ADVENTURE);
				
				p.sendMessage(Main.getPrefix() + "ß7Du bist nun im ßeAbenteuermodusß7!");

			} else if (a[0].equalsIgnoreCase("3") || a[0].equalsIgnoreCase("spec")) {
				if (!p.hasPermission("system.gamemode.3")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}
				p.setGameMode(GameMode.SPECTATOR);
				
				p.sendMessage(Main.getPrefix() + "ß7Du bist nun im ßeZuschauermodusß7!");
			}else {
				p.sendMessage(Main.getPrefix() + "ß7Nutze: /gm (ße0-3ß7)"); 
			}

		} else if (a.length == 2) {
			Player t = Bukkit.getPlayer(a[1]);
			if (t == null) {
				p.sendMessage(Main.getPrefix() + "ße" + a[1] + " ß7ist Offline!");
				return true;
			}

			if (a[0].equalsIgnoreCase("1") || a[0].equalsIgnoreCase("c")) {
				if (!p.hasPermission("system.gamemode.1")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}
				t.setGameMode(GameMode.CREATIVE);

				t.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				

				p.sendMessage(Main.getPrefix() + "ße" + a[1] + " ß7ist nun im ßeKreativmodusß7!");
				t.sendMessage(Main.getPrefix() + "ß7Du bist nun im ßeKreativmodusß7!");
			} else if (a[0].equalsIgnoreCase("0") || a[0].equalsIgnoreCase("s")) {
				if (!p.hasPermission("system.gamemode.0")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}

				p.setGameMode(GameMode.SURVIVAL);

				
				t.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);

				p.sendMessage(Main.getPrefix() + "ße" + a[1] + " ß7ist nun im ße‹berlebensmodusß7!");
				t.sendMessage(Main.getPrefix() + "ß7Du bist nun im ße‹berlebensmodusß7!");
			} else if (a[0].equalsIgnoreCase("2") || a[0].equalsIgnoreCase("a")) {
				if (!p.hasPermission("system.gamemode.2")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}
				p.setGameMode(GameMode.ADVENTURE);

				
				t.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);

				p.sendMessage(Main.getPrefix() + "ße" + a[1] + " ß7ist nun im ßeAbenteuermodusß7!");
				t.sendMessage(Main.getPrefix() + "ß7Du bist nun im ßeAbenteuermodusß7!");
				
			} else if (a[0].equalsIgnoreCase("3") || a[0].equalsIgnoreCase("spec")) {
				if (!p.hasPermission("system.gamemode.3")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}
				p.setGameMode(GameMode.SPECTATOR);

				
				t.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);

				p.sendMessage(Main.getPrefix() + "ße" + a[1] + " ß7ist nun im ßeZuschauermodusß7!");
				t.sendMessage(Main.getPrefix() + "ß7Du bist nun im ßeZuschauermodusß7!");
			}else {
				p.sendMessage(Main.getPrefix() + "ß7Nutze: /gm (ße0-3ß7) (ßeSpielerß7)"); 
			}
		}else {
			p.sendMessage(Main.getPrefix() + "ß7Nutze: /gm (ße0-3ß7) (ßeSpielerß7)"); 
		}
		return false;
	}

}
