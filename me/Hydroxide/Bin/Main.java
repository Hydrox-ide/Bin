package me.Hydroxide.Bin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public boolean onCommand (CommandSender sender, Command command, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("bin") && player.hasPermission(getConfig().getString("permission"))) {
			openBin(player);
		}
		return false;
	}
	
	public void openBin(Player player) {
		Inventory binInven = Bukkit.createInventory(null, 54, "Bin");
		
		player.openInventory(binInven);
	}
	
	@EventHandler
	public void onBinClose(InventoryCloseEvent event) {
		if(event.getInventory().getName() == "Bin") {
		event.getInventory().clear();
		}
	}
}
