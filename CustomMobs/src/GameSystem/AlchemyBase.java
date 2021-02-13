package GameSystem;

import org.bukkit.enchantments.Enchantment;
import items.ItemsBase;

public class AlchemyBase {

	public ItemsBase resetPlus(ItemsBase item) {

		ItemsBase newBased  = new ItemsBase();
		newBased.setItemStageLevel(item.getItemStageLevel());
		newBased.setId(item.getId());
		newBased.setItemDesc(item.getItemDesc());
		newBased.setItemMaterial(item.getType());
		newBased.setItemMeta(item.getItemMeta());
		newBased.setItemName(item.getItemName());
		newBased.setItemPlus(0);
		newBased.setItemStageName(item.getItemStageName());
		newBased.setAmount(1);
		newBased.update();
		return newBased;
	}
	public ItemsBase incrasePlus(ItemsBase item) {
		item.setItemPlus(item.getItemPlus()+1);
		//this.Enchant.remove(Enchantment.DAMAGE_ALL);
		int enchantlevel = item.getItemPlus()+item.getItemStageLevel();
		item.getEnch().put(Enchantment.DAMAGE_ALL,enchantlevel);
		ItemsBase newBased  = new ItemsBase();
		newBased.setItemStageLevel(item.getItemStageLevel());
		newBased.setId(item.getId());
		newBased.setItemDesc(item.getItemDesc());
		newBased.setItemMaterial(item.getType());
		newBased.setItemMeta(item.getItemMeta());
		newBased.setItemName(item.getItemName());
		newBased.setItemPlus(0);
		newBased.setItemStageName(item.getItemStageName());
		newBased.setAmount(1);
		
		newBased.setEnchantments(item.getEnchantments());// stagelevel+enchant level kadar damageall verir
		newBased.update();
		return newBased;
	
		
	}


}
