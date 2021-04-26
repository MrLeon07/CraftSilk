package inventoryPages;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface IPage {
	
	public int getPageNumber();
	public Inventory create(Player Player);
	public Inventory getInventory();
	public ItemStack getItemAt(int Slot);
	public String getPageName();
	public int getSize();
	

}
