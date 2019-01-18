package de.funit.system.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DSGVOCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		p.sendMessage(" ");
		p.sendMessage(" §8» §eDatenschutz Info§7:");
		p.sendMessage("   §8» §7folgende Daten werden gespeichert:");
		p.sendMessage(" ");
		p.sendMessage("   §8» §7Nutzungsdaten");
		p.sendMessage("   §8» §7Bestandsdaten");
		p.sendMessage("   §8» §7Inhaltsdaten");
		p.sendMessage("   §8» §7Metadaten");
		p.sendMessage("   §8» §7Kommunikationsdaten");
		p.sendMessage(" ");
		p.sendMessage("   §8» §efür weitere Infos bitte an den Support wenden");
		p.sendMessage(" ");
		
		return false;
	}
	
}
