package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mobs.bossZombie;

public class commandEx implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		System.out.println("Komut kullanma!!");
		if(sender instanceof Player ) {
			if(sender.isOp()) {
				
				bossZombie boss = new bossZombie(((Player) sender).getWorld());
				boss.spawn(((Player) sender).getLocation());
			}
			
		}
		else {
			System.out.println("Komut satýrýndan yaratýk olusturamazsýn. Oyuna girmen gerekiyor!!");
		}
		return true;
	}

}
