package de.funit.system.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.funit.system.Main;
public class Release implements CommandExecutor {
	int TID;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (sender.hasPermission("system.release")) {
				if (args.length == 0) {
					countdown();
					
				} else if (args[0].equalsIgnoreCase("now")) {
					release();
				
			}
				
			}else {
				sender.sendMessage(Main.getNoPermission());

			}
		return false;
	}

	private void release() {

		System.out.println(" ");
		System.out.println("Server releasing...");
		System.out.println(" ");

		Bukkit.setWhitelist(false);
		Bukkit.broadcastMessage("§8» §7Der Server wurde §everöffentlicht§7!");
	}

	private void countdown() {
		TID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.main, new Runnable() {
			int idx = 10;

			public void run() {
				if (idx > 0) {

					Bukkit.broadcastMessage("§8» §7Der Server wird in §e" + idx + " §7Sekunden §everöffentlicht§7!");

				} else if (idx == 0) {

					Bukkit.getScheduler().cancelTask(TID);

					release();

				}
				idx--;

			}
		}, 0L, 20L);
	}

}
