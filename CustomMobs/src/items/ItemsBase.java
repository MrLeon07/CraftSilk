package items;

import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ItemsBase extends ItemStack{
	private int itemPlus;
	private int ItemLevelCode = 1;
	private String ItemName = "CustomSword";
	private List<String> lore;
	private Material ItemMaterial;
	private int plusIndex = 1;
	private int customName = 0;
	private int descIndex = 3;
	private Map<Enchantment,Integer> Enchant;
	
	public int getItemPlus() {
		return itemPlus;
	}
	public void setItemPlus(int itemPlus) {
		this.itemPlus = itemPlus;
	}
	public void incrasePlus() {
		this.itemPlus++;
		if(itemPlus == 1) {
			Enchant.put(Enchantment.DAMAGE_ALL, 1);
		}
		else {
			if(this.itemPlus>1) {
				this.Enchant.replace(Enchantment.DAMAGE_ALL, this.itemPlus);
			}
		}
		this.getLore().remove(plusIndex);
		List<String> newlore = getLore();
		newlore.add(plusIndex, "Güçlendirme seviyesi: "+this.getItemPlus());
		this.setLore(newlore);
		this.update();
	}
	public void resetPlus() {
		this.setItemPlus(0);
		this.Enchant.clear();
		this.getLore().remove(plusIndex);
		List<String> newlore = getLore();
		newlore.add(plusIndex, "Güçlendirme seviyesi: "+this.getItemPlus());
		this.setLore(newlore);
		this.update();
	}
	public void update() {
		try {		
		
		if(this.getItemMaterial()!= null) {
			//ItemMeta meta = this.getItemMeta();
			this.setType(getItemMaterial());
			//meta.setLore(this.getLore());
			//this.setItemMeta(meta);
			this.getEnchantments().clear();
			this.addEnchantments(this.Enchant);
		}}
		catch(Exception e){
			System.out.println("Update Meta: "+this.getItemMeta());
			System.out.println("Update material: "+this.getItemMaterial());
			System.out.println("Hata update de");
		}
		
	}
	public int getItemLevelCode() {
		return ItemLevelCode;
	}
	public void setItemLevelCode(int itemLevelCode) {
		ItemLevelCode = itemLevelCode;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public List<String> getLore() {
		return lore;
	}
	public void setLore(List<String> lore) {
		this.lore = lore;
	}
	public Material getItemMaterial() {
		return ItemMaterial;
	}
	public void setItemMaterial(Material itemMaterial) {
		ItemMaterial = itemMaterial;
	}
	public Map<Enchantment,Integer> getEnch(){
		return this.Enchant;
	}
	public void setEnchantments(Map<Enchantment,Integer> enchantments) {
		this.Enchant = enchantments;
	}
	public int getPlusIndex() {
		return plusIndex;
	}
	public void setPlusIndex(int plusIndex) {
		this.plusIndex = plusIndex;
	}
	public int getDescIndex() {
		return descIndex;
	}
	public void setDescIndex(int descIndex) {
		this.descIndex = descIndex;
	}
	public int getCustomName() {
		return customName;
	}
	public void setCustomName(int customName) {
		this.customName = customName;
	}
	

}
