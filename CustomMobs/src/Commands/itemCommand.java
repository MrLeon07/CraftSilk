package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import items.Attributes;
import items.CustomSword;



public class itemCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String command, String[] arg3) {
		if(sender instanceof Player) {
			if(sender.isOp()) {
				
				Player senderPlayer = (Player) sender;
				CustomSword sword = new CustomSword();	
				senderPlayer.sendMessage(command);
				Attributes att = new Attributes();
				ItemStack it = att.gen();

				senderPlayer.getWorld().dropItem(senderPlayer.getLocation(), it);
				try {
				senderPlayer.sendMessage("�tem d���r�ld�... "+ it.getItemMeta().getDisplayName());}
				catch(Exception e ) {
					System.out.println("item olu�turulamad�. ");
					System.out.println(it.getType());
				}
			}
		}
		return false;
	}

}
