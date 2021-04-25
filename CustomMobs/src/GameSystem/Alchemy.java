package GameSystem;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import customExceptions.AlchemyPlusLimitException;
import items.CustomStone;
import items.Detector;

public class Alchemy extends AlchemyBase{
	public void StartAlchemy(Inventory inv,Player player) {
		if(inv.getSize() == 9*6) {
		int weaponSlot = 10;
		int anotherslot = 16;
		int resultSlot = 40;
		ItemStack weapon =inv.getItem(weaponSlot);
		ItemStack another = inv.getItem(anotherslot);
		
		if(weapon != null && another != null && weapon.getType() != Material.AIR && another.getType() != Material.AIR) {
			Detector detItem = new Detector(weapon);
			Detector detStone = new Detector(another);
				if(detItem.isCustomItem() && detStone.isCustomItem()) {
					CustomStone stone = detStone.getStone();
					System.out.println(stone.getCustomName());
					System.out.println(stone.getGenericData());
				if(stone.getGenericData().equalsIgnoreCase("upgrade")) {
				if(detItem.getType().equalsIgnoreCase("weapon")) {
					
					try {ItemStack newItem;
						newItem = this.incrasePlus(detItem.getSword());
						int[] slots = {11,12,13,14,15,22,31};
						this.fillWithItems(inv, slots,new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
						inv.setItem(resultSlot, newItem);
						inv.setItem(weaponSlot, new ItemStack(Material.AIR,1));
						stone.setAmount(stone.getAmount()-1);
						inv.setItem(anotherslot,stone );
					} catch (AlchemyPlusLimitException e) {
						player.sendMessage(ChatColor.AQUA+"<Alchemy>: "+ChatColor.RED+"Bu eþya zaten maximum güçlendirme seviyesine sahip!!");
						int[] slots = {11,12,13,14,15,22,31};
						this.fillWithItems(inv, slots,new ItemStack(Material.RED_STAINED_GLASS_PANE));
					}
					}
				else if(detItem.getType().equalsIgnoreCase("armor")) {
					
					try {ItemStack newItem;
						newItem = this.incrasePlus(detItem.getArmor());
						int[] slots = {11,12,13,14,15,22,31};
						this.fillWithItems(inv, slots,new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
						inv.setItem(resultSlot, newItem);
						inv.setItem(weaponSlot, new ItemStack(Material.AIR,1));
						stone.setAmount(stone.getAmount()-1);
						inv.setItem(anotherslot,stone );//itemsBase ver
					} catch (AlchemyPlusLimitException e) {
						player.sendMessage(ChatColor.AQUA+"<Alchemy>: "+ChatColor.RED+"Bu eþya zaten maximum güçlendirme seviyesine sahip!!");
						int[] slots = {11,12,13,14,15,22,31};
						this.fillWithItems(inv, slots,new ItemStack(Material.RED_STAINED_GLASS_PANE));
					}
					
					
					
					}
				else{player.sendMessage(ChatColor.AQUA+"<Alchemy>: "+ChatColor.RED+"Bu eþyayý güçlendiremezsin");				}
				}
				else {
					int[] slots = {11,12,13,14,15,22,31};
					this.fillWithItems(inv, slots,new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
					if(detItem.getType().equalsIgnoreCase("weapon")) {
					ItemStack newItem = this.addBlue(stone,detItem.getSword());
					inv.setItem(resultSlot, newItem);
					inv.setItem(weaponSlot, new ItemStack(Material.AIR,1));
					stone.setAmount(stone.getAmount()-1);
					inv.setItem(anotherslot,stone );}					
					else if(detItem.getType().equalsIgnoreCase("armor")) {
					ItemStack newItem = this.addBlue(stone,detItem.getArmor());
					inv.setItem(resultSlot, newItem);
					inv.setItem(weaponSlot, new ItemStack(Material.AIR,1));
					stone.setAmount(stone.getAmount()-1);
					inv.setItem(anotherslot,stone );}
					else{ player.sendMessage(ChatColor.AQUA+"<Alchemy>:"+ChatColor.RED+" Bu eþya üzerinde deðiþiklik yapýlamaz");
						}}
					}
					
				}
				else {
					player.sendMessage(ChatColor.AQUA+"<Alchemy>:"+ChatColor.RED+" Eþya tanýnmadý. Yeniden oluþturulan eþyalar üzerinde simya kullanýlabilir.");
					
				}}}}
