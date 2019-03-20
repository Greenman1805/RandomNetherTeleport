package de.greenman1805.randomnetherteleport;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RNTCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player) {
			return false;
		}

		if (cmd.getName().equalsIgnoreCase("rnt")) {
			if (args.length == 3) {
				Player p = Bukkit.getPlayer(args[0]);
				if (p != null) {
					World w = Bukkit.getWorld(args[1]);
					if (w != null) {
						try {
							int radius = Integer.parseInt(args[2]);
							Location loc = new Location(w, 0, 10, 0);
							Location teleport = Main.getRandomLocation(loc, radius, 0).add(0.5, 0.5, 0.5);
							if (teleport != null) {
								p.teleport(teleport);
							}
						} catch (NumberFormatException exc) {

						}
					}
				}
			}
		}

		return false;
	}

}
