package Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import items.Attributes;



public class itemCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String command, String[] arg3) {
		if(sender instanceof Player) {
			if(sender.isOp()) {
				
				Player senderPlayer = (Player) sender;
				senderPlayer.sendMessage(command);
				Attributes att = new Attributes();
				ItemStack item = new ItemStack(Material.DIAMOND_SWORD,1);
				senderPlayer.getInventory().addItem(att.gen(item));
				//senderPlayer.getWorld().dropItem(senderPlayer.getLocation(),att.gen());
				try {
				senderPlayer.sendMessage("Ýtem düþürüldü... ");}
				catch(Exception e ) {
					System.out.println("item oluþturulamadý. ");
					
				}
			}
		}
		return false;
	}

}
