package GameSystem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import items.CustomSword;
import items.Detector;

public class Alchemy extends AlchemyBase{
	public void StartAlchemy(Inventory inv,Player player,ItemStack item) {
		if(inv.getSize() == 9*6) {
		int weaponSlot = 10;
		int anotherslot = 16;
		int resultSlot = 40;
		ItemStack weapon =item;
		ItemStack another = inv.getItem(anotherslot);
		if(weapon != null && another != null && weapon.getType() != Material.AIR && another.getType() != Material.AIR) {
			
			Detector detItem = new Detector(item);
			
				if(detItem.isCustomItem()) {
				if(another.getType() == Material.GLOWSTONE_DUST) {
					inv.setItem(11, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(12, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(13, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(14, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(15, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(22, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));					
					inv.setItem(31, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
				if(detItem.getType().equalsIgnoreCase("weapon")) {
					ItemStack newItem = this.incrasePlus(detItem.getSword());
					inv.setItem(resultSlot, newItem);
					inv.setItem(weaponSlot, new ItemStack(Material.AIR,1));
					inv.setItem(anotherslot, new ItemStack(another.getType(),another.getAmount()-1));}
				else if(detItem.getType().equalsIgnoreCase("armor")) {
					ItemStack newItem = this.incrasePlus(detItem.getArmor());
					inv.setItem(resultSlot, newItem);
					inv.setItem(weaponSlot, new ItemStack(Material.AIR,1));
					inv.setItem(anotherslot, new ItemStack(another.getType(),another.getAmount()-1));}//itemsBase ver
					
					}
				else if(another.getType() == Material.REDSTONE || another.getType() == Material.SUGAR || another.getType() == Material.GUNPOWDER) {
					inv.setItem(11, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
					inv.setItem(12, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
					inv.setItem(13, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
					inv.setItem(14, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
					inv.setItem(15, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
					inv.setItem(22, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
					inv.setItem(31, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
					ItemStack newItem = this.addBlue(another,item);//itemstack ver
					inv.setItem(resultSlot, newItem);
					inv.setItem(weaponSlot, new ItemStack(Material.AIR,1));
					inv.setItem(anotherslot, new ItemStack(another.getType(),another.getAmount()-1));}
				}
				else {
					player.sendMessage("<SimyaSistemi>: Bu eþyayý güçlendiremezsin");
					
				}
			
		}
		
		
		
		
	}}

}
