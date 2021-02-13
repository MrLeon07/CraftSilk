package GameSystem;

import org.bukkit.enchantments.Enchantment;

import items.ItemsBase;

public class AlchemyBase {

	public void resetPlus(ItemsBase item) {
		item.setItemPlus(0);
	
		item.removeEnchantment(Enchantment.DAMAGE_ALL);
		item.update();
	}
	public void incrasePlus(ItemsBase item) {
		item.setItemPlus(item.getItemPlus()+1);
		item.removeEnchantment(Enchantment.DAMAGE_ALL);
		//this.Enchant.remove(Enchantment.DAMAGE_ALL);
		int enchantlevel = item.getItemPlus()+item.getItemStageLevel();
		item.getEnch().put(Enchantment.DAMAGE_ALL,enchantlevel);// stagelevel+enchant level kadar damageall verir
		item.update();
	}


}
