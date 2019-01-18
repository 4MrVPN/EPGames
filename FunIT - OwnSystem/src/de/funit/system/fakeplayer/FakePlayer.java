package de.funit.system.fakeplayer;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;

public class FakePlayer {
	static PacketPlayOutPlayerInfo pi;
	static PacketPlayOutNamedEntitySpawn spawn;

	public static void spawn(Player p, UUID uuid) {

		net.minecraft.server.v1_8_R3.World w = ((CraftWorld) p.getWorld()).getHandle();
		PlayerInteractManager interact = new PlayerInteractManager(w);

		Custom c = new Custom(MinecraftServer.getServer(), ((CraftWorld) p.getWorld()).getHandle(),
				new GameProfile(uuid, "§6§lRewards"), interact);

		Location loc = p.getLocation();

		c.setInvisible(false);
		c.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		c.setPositionRotation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		System.out.println(c.aq());

		pi = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, c);
		spawn = new PacketPlayOutNamedEntitySpawn(c);
		PlayerConnection co = ((CraftPlayer) p).getHandle().playerConnection;

		co.sendPacket(pi);
		co.sendPacket(spawn);
		return;

	}

	public static void send(Player p) {
		PlayerConnection co = ((CraftPlayer) p).getHandle().playerConnection;

		co.sendPacket(pi);
		co.sendPacket(spawn);

	}

}
