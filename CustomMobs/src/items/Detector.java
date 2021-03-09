package items;

import java.util.HashMap;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import main.Main;




public class Detector {
	private CustomSword sword;
	private CustomArmor armor;
	private String type = "unKnown";
	private ItemStack stackitem;
	private HashMap<Material,Integer> armors = Main.armors;
	private HashMap<Material,Integer> swords = Main.swords;
	private boolean hasId = false;
	private boolean hasPlus = false;
	private boolean hasStageName = false;
	//Varsa true yoksa false döndürecek þekilde ayarlayýn. Her birisini kntrol edip hepsi true ise eþya custom eþyadýr. 
	//her bir iþlemde ilgili deðeri deðiþtirmeyi unutma
	
	public Detector(ItemStack item) {
		this.stackitem = item;		
		
		
		if(swords.containsKey(item.getType())) {
			this.setType("weapon");
			this.sword = new CustomSword();
			this.sword.setCustomDamage(swords.get(item.getType()).intValue());
			this.sword.setItemMaterial(item.getType());		
			this.DetectSword(this.sword);}
		else if(armors.containsKey(item.getType())) {
			this.setType("armor");
			this.armor = new CustomArmor();
			this.armor.setCustomDeffence(armors.get(item.getType()).intValue());
			this.armor.setItemMaterial(item.getType());
			this.DetectArmor(this.armor);
		}
		else {this.setType("unknown");}
		

	}
	private void DetectSword(CustomSword sword) {/////Burada kaldýk
		ItemStack item = this.stackitem;
		ItemMeta meta = item.getItemMeta();
		for(int i = 0; i<meta.getLore().size();i++) {
			if(meta.getLore().get(i).startsWith(this.sword.guclendirme)) {
				this.sword.setItemPlus(Integer.parseInt(meta.getLore().get(i).substring(this.sword.guclendirme.length()-1).trim()));
				//parse int inte cevirir. substring içindeki harfleri/kelimeleri atýyor. trim boþluklarý siliyor
				this.hasPlus = true;
				
			}
			else if(meta.getLore().get(i).startsWith(this.sword.sýralama)) {
				this.sword.setItemStageName(meta.getLore().get(i).substring(this.sword.sýralama.length()-1));
				this.hasStageName = true;
			}
			else if(meta.getLore().get(i).startsWith(this.sword.kod)) {
				this.sword.setId(Integer.parseInt(meta.getLore().get(i).substring(this.sword.kod.length()-1).trim()));
				this.hasId = true;
			}
		}
		if(this.hasId && this.hasPlus && this.hasStageName) {
		ItemMeta meta1 = item.getItemMeta();
		this.sword.setItemMeta(meta1);
		this.sword.setItemMaterial(item.getType());
		this.sword.update();
		
		}
		this.sword.addEnchantments(item.getEnchantments());
		
	}
	private void DetectArmor(CustomArmor Armor) {/////Burada kaldýk
		ItemStack item = this.stackitem;
		ItemMeta meta = item.getItemMeta();
		for(int i = 0; i<meta.getLore().size();i++) {
			if(meta.getLore().get(i).startsWith(this.armor.guclendirme)) {
				this.armor.setItemPlus(Integer.parseInt(meta.getLore().get(i).substring(this.armor.guclendirme.length()-1).trim()));
				//parse int inte cevirir. substring içindeki harfleri/kelimeleri atýyor. trim boþluklarý siliyor
				this.hasPlus = true;
				
			}
			else if(meta.getLore().get(i).startsWith(this.armor.sýralama)) {
				this.armor.setItemStageName(meta.getLore().get(i).substring(this.armor.sýralama.length()-1));
				this.hasStageName = true;
			}
			else if(meta.getLore().get(i).startsWith(this.armor.kod)) {
				this.armor.setId(Integer.parseInt(meta.getLore().get(i).substring(this.armor.kod.length()-1).trim()));
				this.hasId = true;
			}
		}
		if(this.hasId && this.hasPlus && this.hasStageName) {
		ItemMeta meta1 = item.getItemMeta();
		this.armor.setItemMeta(meta1);
		this.armor.setItemMaterial(item.getType());
		this.armor.update();
		
		}
		this.armor.addEnchantments(item.getEnchantments());
		
	}
	
	public boolean isCustomItem() {
		if(this.hasId && this.hasPlus && this.hasStageName) {
			return true;
		}
		else {
			return false;
		}
	}
	public CustomSword getSword() { 
		return this.sword;
	}
	public CustomArmor getArmor() { 
		return this.armor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
















}