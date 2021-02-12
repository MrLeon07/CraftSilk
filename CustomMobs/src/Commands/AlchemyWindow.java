package Commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import Inventories.AlchemyInventory;

public class AlchemyWindow implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String command, String[] arg3) {
		if(sender instanceof Player) {
			Player senderPlayer = (Player) sender;
			senderPlayer.sendMessage("Simya penceresi açýldý...");
			Inventory inv = (new AlchemyInventory(senderPlayer,6)).getInv();
			senderPlayer.openInventory(inv);
			
		}
		return true;
	}

}
