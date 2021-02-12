package Inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class AlchemyInventory{
	private Inventory inv;
	int invSize;
	public AlchemyInventory(Player player,int satir) {
		invSize = satir*9;
		this.setInv(Bukkit.createInventory(player, invSize, "Alchemy"));

		for(int i = 0;i<invSize;i++) {
			if(i != 10 && i != 16 && i !=40) {
			ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
			ItemMeta meta = item.getItemMeta();
			
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			this.inv.setItem(i,item);
			}
			else;
		}
		ItemStack start = new ItemStack(Material.GREEN_DYE,1);
		ItemMeta startMeta = start.getItemMeta();
		startMeta.setDisplayName("Simyayý Baslat");
		start.setItemMeta(startMeta);
		this.inv.setItem(invSize-1, start);
		ItemStack cancel = new ItemStack(Material.RED_DYE,1);
		ItemMeta cancelMeta = cancel.getItemMeta();
		cancelMeta.setDisplayName("Iptal Et");
		cancel.setItemMeta(cancelMeta);
		this.inv.setItem(invSize-2, cancel);
	
		
		
	}
	public Inventory getInv() {
		return inv;
	}
	private void setInv(Inventory inv) {
		this.inv = inv;
	}

	

}
