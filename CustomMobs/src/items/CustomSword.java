package items;

import org.bukkit.Material;


public class CustomSword extends ItemsBase{
	@SuppressWarnings("deprecation")
	public CustomSword() {

		this.setId(1);
		this.setAmount(1);
		this.setDurability((short) 2500);
		this.setItemMaterial(Material.WOODEN_SWORD);
		this.update();
		
		
		
	}

}
