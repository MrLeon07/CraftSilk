package items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class Detector {
	private final ItemsBase item = new ItemsBase();
	private boolean is = false;
	public Detector(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		for(int i = 0; i<meta.getLore().size();i++) {
			System.out.println(meta.getLore().get(i));
		}
		

	}
	public boolean isCustomItem() {
		
		return is;
	}
	public ItemsBase getItem() {
		return this.item;
	}
	















}