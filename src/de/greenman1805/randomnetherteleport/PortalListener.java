package de.greenman1805.randomnetherteleport;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;



public class PortalListener implements Listener {
	
	
	public PortalListener() {
		Bukkit.getServer().getPluginManager().registerEvents(this, Main.plugin);
	}
	
	
	@EventHandler
	public void NetherPortalTest(PlayerPortalEvent e) {
		Player p = e.getPlayer();
		
		if (p.getWorld().getWorldType() == WorldType.NORMAL) {
			Location loc = new Location(Bukkit.getWorld("Nether"), 0, 10, 0);
			Location teleport = Main.getRandomLocation(loc, 1000, 0).add(0.5, 0.5, 0.5);
			if (teleport != null) {
				p.teleport(teleport);
				p.sendMessage("§5Wir haben einen schönen Platz zum Farmen für dich gefunden!");
			}
		}
	}

}
