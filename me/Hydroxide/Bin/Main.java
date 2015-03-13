package me.Hydroxide.Bin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "/BIN is a player only command.");
			return false;
		}
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("bin") && player.hasPermission("bin.bin")) {
			openBin(player);
			return true;
		} else if (!(player.hasPermission("bin.bin"))) {
			player.sendMessage(ChatColor.RED + "You do not have permission for that command.");
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
