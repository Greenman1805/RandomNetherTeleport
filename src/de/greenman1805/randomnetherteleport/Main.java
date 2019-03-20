package de.greenman1805.randomnetherteleport;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Random random;
	public static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;
		random = new Random();
		getCommand("rnt").setExecutor(new RNTCommand());
		new PortalListener();
	}

	public static Location getRandomLocation(Location startFrom, int radius, int i) {
		if (i == 40) {
			return null;
		}

		Location output = startFrom.clone();
		output.setY(20);
		output.add(random.nextInt(radius) - random.nextInt(radius), 0, random.nextInt(radius) - random.nextInt(radius));
		while (output.getBlockY() < 255) {
			if (checkLocation(output)) {
				return output;
			}
			output.add(0, 1, 0);
		}
		i++;
		return getRandomLocation(startFrom, radius, i);
	}

	private static boolean checkLocation(Location loc) {
		Location test = loc.clone();
		Material below = test.getBlock().getType();
		Material p1 = test.add(0, 1, 0).getBlock().getType();
		Material p2 = test.add(0, 1, 0).getBlock().getType();

		if (below == Material.NETHERRACK && p1 == Material.AIR && p2 == Material.AIR) {
			return true;
		}
		return false;
	}

}
