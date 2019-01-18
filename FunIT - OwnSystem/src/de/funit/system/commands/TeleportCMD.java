package de.funit.system.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.funit.system.Main;

public class TeleportCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if (!(s instanceof Player))
			return true;

		Player p = (Player) s;

		if (p.hasPermission("system.teleport")) {
			if (args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);

				if (t == null) {
					p.sendMessage(Main.getPrefix() + "§e" + args[0] + " §7ist Offline!");
					return true;
				}

				World tw = t.getWorld();
				double tx = t.getLocation().getX();
				double ty = t.getLocation().getY() + 1;
				double tz = t.getLocation().getZ();
				Location tloc = new Location(tw, tx, ty, tz);
				tloc.setPitch(t.getLocation().getPitch());
				tloc.setYaw(t.getLocation().getYaw());

				p.teleport(tloc);
				p.sendMessage(Main.getPrefix() + "§7Du hast dich zu §e" + t.getName() + " §7teleportiert!");
			} else {
				p.sendMessage(Main.getPrefix() + "§7Nutze: /tp (§eSpieler§7)");
			}
		} else {
			p.sendMessage(Main.getNoPermission());
		}
		return false;
	}

}
