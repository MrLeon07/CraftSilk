package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import items.CustomArmor;
import items.CustomSword;



public class itemCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String command, String[] arg3) {
		if(sender instanceof Player) {
			if(sender.isOp()) {
				
				Player senderPlayer = (Player) sender;
				senderPlayer.sendMessage(command);
				CustomSword item = new CustomSword();
				CustomArmor armor = new CustomArmor();
				senderPlayer.getWorld().dropItem(senderPlayer.getLocation(),armor);
				senderPlayer.getWorld().dropItem(senderPlayer.getLocation(),item);
				try {
				senderPlayer.sendMessage(item.getItemName()+" düþürüldü... ");}
				catch(Exception e ) {
					System.out.println("item oluþturulamadý. ");
					
				}
			}
		}
		return false;
	}

}
