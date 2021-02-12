package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import items.CustomSword;



public class itemCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String command, String[] arg3) {
		if(sender instanceof Player) {
			if(sender.isOp()) {
				
				Player senderPlayer = (Player) sender;
				CustomSword sword = new CustomSword();	
				senderPlayer.sendMessage(command);
				System.out.println(sword.getClass());
				senderPlayer.getWorld().dropItem(senderPlayer.getLocation(), sword);
				senderPlayer.sendMessage("Ýtem düþürüldü... "+ sword.getItemName());
			}
		}
		return false;
	}

}
