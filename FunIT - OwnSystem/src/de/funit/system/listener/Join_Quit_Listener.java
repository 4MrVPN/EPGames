package de.funit.system.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import de.funit.system.commands.TeamchatCMD;
import de.funit.system.dailyreward.Reward;

import org.bukkit.event.Listener;

public class Join_Quit_Listener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Reward pr = new Reward(p.getUniqueId());
		if(p.hasPermission("system.teamchat")) {
			if(!TeamchatCMD.tc.contains(p)) {
				TeamchatCMD.tc.add(p);
				
				for (Player all : Bukkit.getOnlinePlayers()) {
					if (TeamchatCMD.tc.contains(all)) {
						all.sendMessage("§8● §e§lTeamChat §8» §e§n" + p.getName() + "§7 hat sich eingeloggt!");
					}
				}
				
				if(pr.dataExist() == false) {
					pr.setFirstJoin();
				}
				
			}
		}
	}

}
