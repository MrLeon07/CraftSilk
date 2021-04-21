package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import items.CustomArmor;
import items.CustomStone;
import items.CustomSword;
import net.md_5.bungee.api.ChatColor;



public class itemCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String command, String[] args) {
		if(sender instanceof Player) {
			if(sender.isOp()) {
				Player player = (Player)sender;
				if(args.length==2) {
					if(args[0].equalsIgnoreCase("item")) {
						try {int id = Integer.parseInt(args[1]);
						if(main.Main.armors.containsKey(id)) {
							CustomArmor armor = main.Main.armors.get(id);
							player.getLocation().getWorld().dropItem(player.getLocation(),armor);
							player.sendMessage(ChatColor.AQUA+"<Game>: "+ChatColor.GREEN+"Eþya düþürüldü. Eþya adý: "+armor.getCustomName());
						}
						else if(main.Main.swords.containsKey(id)) {
							CustomSword sword = main.Main.swords.get(id);
							player.getLocation().getWorld().dropItem(player.getLocation(),sword);
							player.sendMessage(ChatColor.AQUA+"<Game>: "+ChatColor.GREEN+"Eþya düþürüldü. Eþya adý: "+sword.getCustomName());
						}
						else{player.sendMessage(ChatColor.AQUA+"<Game>: "+ChatColor.RED+"Eþya oluþturulamadý. Girmiþ olduðunuz id'yi kontrol ediniz lütfen.");}}
						catch(Exception e) {player.sendMessage(ChatColor.AQUA+"<Game>: "+ChatColor.RED+"Eþya oluþturulamadý. Bir hata oluþtu.");
						System.out.println("Eþya birakilamadi: "+e.getMessage());}
					}
					else if(args[0].equalsIgnoreCase("stone")) {
						try {
							int id= Integer.parseInt(args[1]);
							if(main.Main.stones.containsKey(id)) {
								CustomStone stone = main.Main.stones.get(id);
								player.getLocation().getWorld().dropItem(player.getLocation(),stone);
								player.sendMessage(ChatColor.AQUA+"<Game>: "+ChatColor.GREEN+"Eþya düþürüldü. Eþya adý: "+stone.getCustomName());
							}
							else {player.sendMessage(ChatColor.AQUA+"<Game>: "+ChatColor.RED+"Eþya oluþturulamadý. Girmiþ olduðunuz id'yi kontrol ediniz lütfen.");}
						}
						catch(Exception e) {player.sendMessage(ChatColor.AQUA+"<Game>: "+ChatColor.RED+"Eþya oluþturulamadý. Bir hata oluþtu.");
						System.out.println("Eþya birakilamadi: "+e.getMessage());}
					}
					
				}
			
				
			}
		}
		return false;
	}

}
