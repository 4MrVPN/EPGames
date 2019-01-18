package de.funit.system.fakeplayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.funit.system.Main;

public class FakePlayerCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if (p.hasPermission("gg.fakepl")) {

				FakePlayer.spawn(p, p.getUniqueId());

			}else {
				p.sendMessage(Main.getNoPermission());
			}
		}

		return false;
	}

}
