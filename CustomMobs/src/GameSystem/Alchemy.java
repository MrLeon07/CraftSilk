package GameSystem;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import items.Detector;
import items.ItemsBase;

public class Alchemy extends AlchemyBase{
	public void StartAlchemy(Inventory inv,ItemStack item) {
		if(inv.getSize() == 9*6) {
		int weaponSlot = 10;
		int anotherslot = 16;
		int resultSlot = 40;
		ItemStack weapon =item;
		ItemStack another = inv.getItem(anotherslot);
		if(weapon != null && another != null && weapon.getType() != Material.AIR && another.getType() != Material.AIR) {
			System.out.println("Weapon = "+weapon);
			Detector detItem = new Detector(item);
			
				if(detItem.isCustomItem()) {
					ItemsBase itembased = detItem.getItem();
				if(another.getType() == Material.NETHERITE_INGOT) {
					inv.setItem(11, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(12, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(13, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(14, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(15, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					inv.setItem(22, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					
					inv.setItem(31, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
					ItemsBase newItem = this.incrasePlus(itembased);
					inv.setItem(resultSlot, newItem);
					inv.setItem(weaponSlot, new ItemStack(Material.AIR,1));
					inv.setItem(anotherslot, new ItemStack(Material.AIR,1));
				
			}}
			
		}
		
		
		
		
	}}

}
