package de.funit.system.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.funit.system.Main;

public class TeleportHereCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if (!(s instanceof Player))
			return true;
		
		Player p = (Player) s;
		
		if(p.hasPermission("system.teleporthere")) {
			if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				
				if(t == null) {
					p.sendMessage(Main.getPrefix() + "§e" + args[0] + " §7ist Offline!");
					return true;
				}
				
				World pw = p.getWorld();
				double px = p.getLocation().getX();
				double py = p.getLocation().getY() +1;
				double pz = p.getLocation().getZ();
				Location ploc = new Location(pw, px, py, pz);
				ploc.setPitch(t.getLocation().getPitch());
				ploc.setYaw(t.getLocation().getYaw());
				
				t.teleport(ploc);
				p.sendMessage(Main.getPrefix() + "§7Du hast §e" + t.getName() + " §7zu dir teleportiert!");
			}else {
				p.sendMessage(Main.getPrefix() + "§7Nutze: /tphere (§eSpieler§7)");
			}
		}else {
			p.sendMessage(Main.getNoPermission());
		}
		return false;
	}

}
