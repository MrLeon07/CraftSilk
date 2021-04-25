package items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;




public class Detector {
	boolean isCustom = false;
	public String type = "None";
	public String materialType;
	private int plus = 0;
	int id = 0;
	private ItemStack item = null;
	public Detector(ItemStack item) {
		this.item = item;
		id = this.findId(item);
		if(id>0) {
			System.out.println(this.materialType);
			if(this.materialType.equalsIgnoreCase("Item")) {
				if(main.Main.armors.containsKey(id)) {this.type = "armor";this.isCustom=true;}
				else if(main.Main.swords.containsKey(id)) {this.type = "weapon";this.isCustom=true;}
				else {this.isCustom = false;}
			}
			else if(this.materialType.equalsIgnoreCase( "Stone")) {
				if(main.Main.stones.containsKey(id)) {this.type = "stone";this.isCustom=true;}
				else {this.isCustom = false;}
			}
			else if(this.materialType.equalsIgnoreCase("Scroll")) {
				this.isCustom=true;
			}
			
			else {this.isCustom = false;}}
		else {this.isCustom=false;}
	}
	private CustomSword getCustomSword(int id) {return main.Main.swords.get(id);}
	private CustomArmor getCustomArmor(int id) {return main.Main.armors.get(id);}
	private Integer findId(ItemStack item) {
		int ids = 0;
		ItemMeta meta = item.getItemMeta();
		for(String str:meta.getLore()) {
			if(str.contains("Item id:")) {
				String target = String.copyValueOf("Item id:".toCharArray());
				str = str.replace(target, "");
				ids = Integer.parseInt(str.trim());}
			else if(str.contains("Güçlendirme seviyesi:")) {
				String target = String.copyValueOf("Güçlendirme seviyesi:".toCharArray());
				str = str.replace(target, "");
				this.plus = Integer.parseInt(str.trim());}
			else if(str.contains("Item Type:")) {
				
				String target = String.copyValueOf("Item Type:".toCharArray());
				str = str.replace(target, "");
				this.materialType = str.trim();
				}
			}
		return ids;}
	private CustomSword SyncItem(CustomSword first,ItemStack item) {
		first = (CustomSword) first.clone();
		first.addEnchantments(item.getEnchantments());
		first.setItemPlus(plus);
		return first;
		
	}
	private CustomArmor SyncItem(CustomArmor first,ItemStack item) {
		first = (CustomArmor) first.clone();
		first.addEnchantments(item.getEnchantments());
		first.setItemPlus(plus);
		return first;}
	public CustomStone getStone() {
		CustomStone stone = (CustomStone) main.Main.stones.get(this.id).clone();
		stone.setAmount(this.item.getAmount());
		return stone;
	}
	public CustomSword getSword() {
		CustomSword sword = this.getCustomSword(this.id);
		sword = this.SyncItem(sword, this.item);
		return sword;		
	}
	public CustomArmor getArmor() {
		CustomArmor armor = this.getCustomArmor(this.id);
		armor = this.SyncItem(armor, this.item);
		return armor;
	}
	public boolean isCustomItem() {
		return this.isCustom;
	}
	public String getType() {
		return type;
	}
	
}