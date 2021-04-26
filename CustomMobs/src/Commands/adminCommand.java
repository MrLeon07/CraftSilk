package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Inventories.AdminItemsWindow;

public class adminCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.isOp()) {
			AdminItemsWindow adminPanel = new AdminItemsWindow();
			
			player.openInventory(adminPanel.Pages.get(1).create(player));
		}}
		return false;
	}

}
