package inventoryPages;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import customExceptions.ValueErrorException;
import database.DBconnector;
import net.md_5.bungee.api.ChatColor;

public class AdminInventoryPage1 implements IPage{
	private Inventory inv;
	Player player;
	private int PageNumber = 1;
	private int size = 54;
	private String name = "Admin Items Page 1";
	public AdminInventoryPage1() {
		
	}
	public Inventory create(Player player) {
		this.player = player;
		Inventory inv = Bukkit.createInventory(this.player,54,this.name);
		this.setInv(inv);
		this.fill();
		
		return this.getInv();
	}
	@Override

	public Inventory getInventory() {
		
		return inv;
	}
	@Override
	public ItemStack getItemAt(int Slot) {
		return this.inv.getItem(Slot); 
	}
	@Override
	public String getPageName() {
		return this.name;
	}
	@Override
	public int getSize() {
		return this.size;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	private void fill() {
		ArrayList<Integer> helmets;
		ArrayList<Integer> chestPlates;
		ArrayList<Integer> leggings;
		ArrayList<Integer> boots;
		ArrayList<Integer> swords;
		DBconnector database = main.Main.DbConnection;
		try {
			helmets = database.getAdminCommandItems("leather_helmet");
			chestPlates = database.getAdminCommandItems("leather_chestplate");
			leggings = database.getAdminCommandItems("leather_leggings");
			boots = database.getAdminCommandItems("leather_boots");
			swords = database.getAdminCommandItems("wooden_sword");
			ItemStack emptySlotItem = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
			ItemMeta emptyMeta = emptySlotItem.getItemMeta();
			ItemStack pageInfoPaper = new ItemStack(Material.PAPER);
			ItemMeta pagePaperMeta = pageInfoPaper.getItemMeta();
			pagePaperMeta.setDisplayName(ChatColor.GREEN+"Deri zýrh ve Tahta Kýlýç Modelleri");
			pageInfoPaper.setItemMeta(pagePaperMeta);
			emptyMeta.setDisplayName("");
			emptySlotItem.setItemMeta(emptyMeta);
			ItemStack leftPageArrow = new ItemStack(Material.ARROW);
			ItemStack rightPageArrow = new ItemStack(Material.ARROW);
			ItemMeta rightArrowMeta = rightPageArrow.getItemMeta();
			ItemMeta leftArrowMeta = leftPageArrow.getItemMeta();
			leftArrowMeta.setDisplayName("<- Önceki Sayfa");
			rightArrowMeta.setDisplayName("Sonraki sayfa ->");
			rightPageArrow.setItemMeta(rightArrowMeta);
			leftPageArrow.setItemMeta(leftArrowMeta);
			for(int i = 0;i<9;i++) {this.inv.setItem(i, main.Main.armors.get(helmets.get(i)).getItem().clone());}
			for(int i = 9;i<18;i++) {this.inv.setItem(i, main.Main.armors.get(chestPlates.get(i-9)).getItem().clone());}
			for(int i = 18;i<27;i++) {this.inv.setItem(i, main.Main.armors.get(leggings.get(i-18)).getItem().clone());}
			for(int i = 27;i<36;i++) {this.inv.setItem(i, main.Main.armors.get(boots.get(i-27)).getItem().clone());}
			for(int i = 36;i<45;i++) {this.inv.setItem(i, main.Main.swords.get(swords.get(i-36)).clone());}
			for(int i = 45;i<this.size;i++) {this.inv.setItem(i,emptySlotItem.clone());}
			this.inv.setItem(this.size-1, rightPageArrow);
			this.inv.setItem(this.size-9, leftPageArrow);
			this.inv.setItem(this.size-5, pageInfoPaper);
		} catch (ValueErrorException e) {
			System.out.println(e.getMessage());
		}catch(NullPointerException e) {
			System.out.println("Eþya bulunamadý. AdminInventoryPage1'i kontrol ediniz!" );
			e.printStackTrace();
		}
		
	}
	public int getPageNumber() {
		return PageNumber;
	}
	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}

}
