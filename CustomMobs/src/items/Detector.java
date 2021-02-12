package items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class Detector {
	private final ItemsBase item = new ItemsBase();
	private ItemStack stacked;
	private boolean hasId = false;
	private boolean hasPlus = false;
	private boolean hasStageName = false;
	//Varsa true yoksa false döndürecek þekilde ayarlayýn. Her birisini kntrol edip hepsi true ise eþya custom eþyadýr. 
	//her bir iþlemde ilgili deðeri deðiþtirmeyi unutma
	
	public Detector(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		for(int i = 0; i<meta.getLore().size();i++) {
			if(meta.getLore().get(i).startsWith(this.item.guclendirme)) {
				this.item.setItemPlus(Integer.parseInt(meta.getLore().get(i).substring(this.item.guclendirme.length()-1).trim()));
				//parse int inte cevirir. substring içindeki harfleri/kelimeleri atýyor. trim boþluklarý siliyor
				this.hasPlus = true;
				
			}
			else if(meta.getLore().get(i).startsWith(this.item.sýralama)) {
				this.item.setItemStageName(meta.getLore().get(i).substring(this.item.sýralama.length()-1));
				this.hasStageName = true;
			}
			else if(meta.getLore().get(i).startsWith(this.item.kod)) {
				this.item.setId(Integer.parseInt(meta.getLore().get(i).substring(this.item.kod.length()-1).trim()));
				this.hasId = true;
			}
		}
		if(this.hasId && this.hasPlus && this.hasStageName) {
		ItemMeta meta1 = item.getItemMeta();
		this.item.setItemMeta(meta1);
		this.item.setItemMaterial(item.getType());
		
		}
		

	}
	public boolean isCustomItem() {
		if(this.hasId && this.hasPlus && this.hasStageName) {
			return true;
		}
		else {
			return false;
		}
	}
	public ItemsBase getItem() {
		return this.item;
	}
	















}