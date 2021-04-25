package Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import GameSystem.Alchemy;

public class Events implements Listener{

	@EventHandler
	public void BlocPlaceEvent(InventoryClickEvent e) {
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
				//asdasdasd}
				
			
			}
			else if(item.getType() == Material.RED_DYE) {
				player.sendMessage("Bu özellik henüz aktif deðil.");
				e.setCancelled(true);
			}
			}
			
		

			
		}
		
	}}

	


