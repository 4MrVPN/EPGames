package de.funit.system;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.funit.system.commands.BroadcastCMD;
import de.funit.system.commands.DSGVOCMD;
import de.funit.system.commands.DiscordCMD;
import de.funit.system.commands.GamemodeCMD;
import de.funit.system.commands.Release;
import de.funit.system.commands.ServerStatsCMD;
import de.funit.system.commands.TeamchatCMD;
import de.funit.system.commands.TeleportCMD;
import de.funit.system.commands.TeleportHereCMD;
import de.funit.system.dailyreward.RewardCMD;
import de.funit.system.fakeplayer.FakePlayer;
import de.funit.system.fakeplayer.FakePlayerCMD;
import de.funit.system.listener.Join_Quit_Listener;

public class Main extends JavaPlugin implements Listener {
	public static Main main;

	public void onEnable() {
		main = this;
		
		System.out.println("Marvin ist Doof");
		
		this.getCommand("discord").setExecutor(new DiscordCMD());
		this.getCommand("serverstats").setExecutor(new ServerStatsCMD());
		this.getCommand("dsgvo").setExecutor(new DSGVOCMD());
		this.getCommand("release").setExecutor(new Release());
		this.getCommand("fp").setExecutor(new FakePlayerCMD());

		this.getCommand("tc").setExecutor(new TeamchatCMD());
		this.getCommand("bc").setExecutor(new BroadcastCMD());

		this.getCommand("gm").setExecutor(new GamemodeCMD());
		this.getCommand("tp").setExecutor(new TeleportCMD());
		this.getCommand("tphere").setExecutor(new TeleportHereCMD());

		this.getCommand("reward").setExecutor(new RewardCMD());

		this.getCommand("fp").setExecutor(new FakePlayerCMD());

		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(this, this);
		pm.registerEvents(new Join_Quit_Listener(), this);

	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCMD(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String s = e.getMessage();

		if (p.isOp() || p.hasPermission("system.serverinfo"))
			return;

		if (s.equalsIgnoreCase("/pl") || s.equalsIgnoreCase("/plugins") || s.equalsIgnoreCase("/help")
				|| s.equalsIgnoreCase("/?") || s.equalsIgnoreCase("/bukkit:help") || s.equalsIgnoreCase("/bukkit:?")
				|| s.equalsIgnoreCase("/minecraft:help")) {

			e.setCancelled(true);
			p.sendMessage(getNoPermission());
			return;
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPreJoin(PlayerLoginEvent e) {
		Player p = e.getPlayer();

		if (!Bukkit.hasWhitelist())
			return;

		if (Bukkit.getWhitelistedPlayers().contains(p) || p.hasPermission("system.whitelist")) {
			e.allow();

		} else {
			e.disallow(Result.KICK_WHITELIST, "§c§lDer Server ist in Wartungen!");
			Bukkit.broadcastMessage("§8» §e" + p.getName() + " §7versuchte zu joinen!");
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		FakePlayer.send(p);

	}

	public static String getPrefix() {
		return "§8● §eSystem §8» ";
	}

	public static String getNoPermission() {
		return getPrefix() + "§cDu hast keine Rechte!";
	}
}
