package GameSystem;

import org.bukkit.enchantments.Enchantment;
import items.ItemsBase;

public class AlchemyBase {

	public ItemsBase resetPlus(ItemsBase item) {

		/*ItemsBase newBased  = new ItemsBase();
		newBased.setItemStageLevel(item.getItemStageLevel());
		newBased.setId(item.getId());
		newBased.setItemDesc(item.getItemDesc());
		newBased.setItemMaterial(item.getType());
		newBased.setItemMeta(item.getItemMeta());
		newBased.setItemName(item.getItemName());
		newBased.setItemPlus(0);
		newBased.setItemStageName(item.getItemStageName());
		newBased.setAmount(1);
		newBased.update();*/
		item.removeEnchantment(Enchantment.DAMAGE_ALL);
		item.setItemPlus(0);
		item.update();
		return item;
	}
	public ItemsBase incrasePlus(ItemsBase item) {
		
		//this.Enchant.remove(Enchantment.DAMAGE_ALL);
	
		if(item.getItemStageLevel()<=3) {
		
			if(item.getItemPlus()<10) {
			item.setItemPlus(item.getItemPlus()+1);}
			
			
		if(item.getItemPlus()>5) {
			item.removeEnchantment(Enchantment.DAMAGE_UNDEAD);
			item.addEnchantment(Enchantment.DAMAGE_UNDEAD, item.getItemPlus()-5);
			item.removeEnchantment(Enchantment.DAMAGE_ALL);
			item.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			}
		else {
			
			item.removeEnchantment(Enchantment.DAMAGE_ALL);
			item.addEnchantment(Enchantment.DAMAGE_ALL, item.getItemPlus());
		}
		item.removeEnchantment(Enchantment.LOOT_BONUS_MOBS);			
		item.addEnchantment(Enchantment.LOOT_BONUS_MOBS, item.getItemStageLevel());
		item.update();}
		
		

		return item;
	
		
	}


}
