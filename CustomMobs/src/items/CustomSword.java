package items;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
//import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
//import org.bukkit.material.MaterialData;

public class CustomSword extends ItemsBase{
	public CustomSword() {
		
		
		this.setType(Material.WOODEN_SWORD);
		
		this.setItemName("Klasik Sword");
		this.setAmount(1);
		// E�yalarda amount en az 1 olmal� yoksa hata veriyor.
		List<String> lore = Arrays.asList("CustomSword","G��lendirme seviyesi: "+this.getItemPlus()," ","Bu e�ya �zel olarak olu�turulmu�tur.");
		this.setLore(lore);
		this.update();
		

	
		
		
	}

	public void update() {
		ItemMeta meta = this.getItemMeta();
	
		meta.setCustomModelData(9);
		meta.setUnbreakable(true);
		meta.setLore(this.getLore());
		meta.setLocalizedName("Etiketasdasdasd");
		meta.setDisplayName(this.getItemName());
		this.setItemMeta(meta);
	
		try {
			
			this.addEnchantments(this.getEnchantments());
		}
		catch(Exception e){
			System.out.println("Hata olu�tu");
			
		}
	}

}
