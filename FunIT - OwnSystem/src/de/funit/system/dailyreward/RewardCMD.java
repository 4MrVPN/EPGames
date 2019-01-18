package de.funit.system.dailyreward;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.funit.system.Main;
import de.funit.system.UUIDFetcher;

public class RewardCMD implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if (!(s instanceof Player))
			return true;

		Player p = (Player) s;

		if (a.length == 1) {
			if (a[0].equalsIgnoreCase("test")) {
				if (!p.hasPermission("system.reward.test")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}
				
				Reward pr = new Reward(p.getUniqueId());
				Date date = new Date();

				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

				if (pr.getNormalRewarded().equals(sdf.format(date))) {
					p.sendMessage(Main.getPrefix() + "§cDu kannst deine §eBelohnung §cerst Morgen wieder abholen!");
					return true;
				}

				p.sendMessage(Main.getPrefix() + "§aDu hast deine §eBelohnung §aabgeholt!");
				pr.setNormalRewarded(sdf.format(date));

			}else if(a[0].equalsIgnoreCase("spawnmob")) {
				if(!p.hasPermission("system.reward.spawnmob")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}
				
				Pig z = (Pig) p.getWorld().spawnCreature(p.getLocation(), EntityType.PIG);		
				
				z.setCanPickupItems(true);
				z.setCustomNameVisible(true);
				z.setCustomName("§aBelohnungen");
				z.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 360000, 10, false, false));
				
				p.sendMessage(Main.getPrefix() + "§7Du hast das §aBelohnungsschwein §7erstellt!");
				
			}

		} else if (a.length == 2) {
			if (a[0].equalsIgnoreCase("reset")) {
				if(!p.hasPermission("system.reward.reset")) {
					p.sendMessage(Main.getNoPermission());
					return true;
				}
				
				UUID uuid = UUIDFetcher.getUUID(a[1]);
				Reward tr = new Reward(uuid);

				if (tr.dataExist() == false) {
					p.sendMessage(Main.getPrefix() + "§7Es wurden keine §eDaten §7von §e" + UUIDFetcher.getName(uuid)
							+ " §7gefunden!");
					return true;
				}

				tr.setFirstJoin();
				p.sendMessage(Main.getPrefix() + "§7Du hast die §eDaten §7von §e" + UUIDFetcher.getName(uuid) + " §7gelöscht!");
			}
		}
		return false;
	}

}
