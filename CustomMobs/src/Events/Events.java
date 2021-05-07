package Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import GameSystem.Alchemy;
import Inventories.AdminItemsWindow;
import inventoryPages.IPage;

public class Events implements Listener{
	
	
	@EventHandler

	public void InventoryClick2(InventoryClickEvent e) {
		if(e != null && e.getInventory() != null) {
		Player player = (Player) e.getWhoClicked();
		InventoryView invView = player.getOpenInventory();
		Inventory inv = e.getClickedInventory();
		ItemStack item = e.getCurrentItem();
		item = e.getCurrentItem();
		if(invView.getTitle().equalsIgnoreCase("Alchemy") && (item != null)) {
			
			if(item.getType() == Material.BLACK_STAINED_GLASS_PANE || item.getType() == Material.GREEN_STAINED_GLASS_PANE || 
					item.getType() == Material.RED_STAINED_GLASS_PANE || item.getType() == Material.YELLOW_STAINED_GLASS_PANE) {
				e.setCancelled(true);
			}
			if(item.getType() == Material.GREEN_DYE) {
				player.sendMessage("Simya basladý");
				Alchemy alc = new Alchemy();
				alc.StartAlchemy(inv,player);
				e.setCancelled(true);
				
			}
			else if(item.getType() == Material.RED_DYE) {
				player.sendMessage("Bu özellik henüz aktif deðil.");
				e.setCancelled(true);
			}
			}
			
		

			
		}
		
	}
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		AdminItemsWindow adminPage = new AdminItemsWindow();
		if(e != null && e.getInventory() != null) {
		Player player = (Player) e.getWhoClicked();
		InventoryView view = player.getOpenInventory();
		if(adminPage.PageNames.containsKey(view.getTitle())) {
			IPage page = adminPage.Pages.get(adminPage.PageNames.get(view.getTitle()));
			e.setCancelled(true);
			ItemStack item = e.getCurrentItem();
			if(item.getType().equals(Material.ARROW)) {
				ItemMeta arrowMeta = item.getItemMeta();
				if(arrowMeta.getDisplayName().equalsIgnoreCase("<- Önceki Sayfa")) {
					int pageNumber = page.getPageNumber();
					if(adminPage.Pages.containsKey(pageNumber-1)) {
						IPage nextPage = adminPage.Pages.get(pageNumber-1);
						player.closeInventory();
						player.openInventory(nextPage.create(player));
					}
				}
				else if(arrowMeta.getDisplayName().equalsIgnoreCase("Sonraki sayfa ->")) {
					int pageNumber = page.getPageNumber();
					if(adminPage.Pages.containsKey(pageNumber+1)) {
						IPage nextPage = adminPage.Pages.get(pageNumber+1);
						player.closeInventory();
						player.openInventory(nextPage.create(player));}}}
			else if(item.getType().equals(Material.PAPER) || item.getType().equals(Material.GREEN_STAINED_GLASS_PANE)){}
			else {if(player.isOp()) {
				player.getInventory().addItem(e.getCurrentItem().clone());
			}
			}
			}}
		
	}
	@EventHandler
	public void DamageEvent(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() instanceof Player) {
			
			Player player = (Player) e.getEntity();
			double damage = e.getDamage();
			double totalDeffence = 0.0;
			for (ItemStack item : player.getInventory().getArmorContents()) {
				if(item != null) {
					ItemMeta meta = item.getItemMeta();
					try {
					for (AttributeModifier modifier : meta.getAttributeModifiers(Attribute.GENERIC_ARMOR)) {
						totalDeffence += modifier.getAmount();}}
					catch(Exception exc) {
						
					}
					}}
			Bukkit.getServer().broadcastMessage("Damage = "+damage+" defans = "+totalDeffence);
			if(damage < totalDeffence) {
				double chance = Math.random();
				double value = damage/totalDeffence;
				Bukkit.getServer().broadcastMessage("value = "+(int)(value*100)+" chance = "+(int)(chance*100));

				if(chance<value) {
					e.setDamage(0.5);
				}else {
					e.setDamage(0);
				}
			}
			else {
				e.setDamage(damage-totalDeffence);
			}
			
			
		}
	}
}

