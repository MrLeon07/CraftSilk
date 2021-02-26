package items;

import org.bukkit.Material;


public class CustomSword extends ItemsBase{
	private int customDamage = 4;
	@SuppressWarnings("deprecation")
	public CustomSword() {

		this.setId(1);
		this.setAmount(1);
		this.setDurability((short) 2500);
		this.setItemMaterial(Material.WOODEN_SWORD);
		this.update();
		
		
		
	}
	public int getCustomDamage() {
		return customDamage;
	}
	public void setCustomDamage(int customDamage) {
		this.customDamage = customDamage;
	}

}
