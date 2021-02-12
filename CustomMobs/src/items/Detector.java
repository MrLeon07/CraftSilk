package items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class Detector extends ItemsBase{
	private List<String> lorea;
	private boolean isCustomItem = false;
	public Detector(ItemStack item) {
		try {
	
		Material material = item.getType();
		this.setItemMaterial(material);
		ItemMeta meta = item.getItemMeta();
		
		this.setLorea(meta.getLore());}
		catch(Exception e) {
			System.out.println("ASDasfdþjoasdklfölasdþlmkasödvlmasdöfaskdf");
		}
		this.update();
		
		
	}
	
	public boolean Detect() {
		System.out.println("Loreaa = "+this.lorea);
	try {
		boolean dog = this.getLorea().get(0).startsWith("Custom");

		
		
		if(dog) {
			for(int i = 0;i < this.lorea.size();i++) {
				if(this.lorea.get(i).startsWith("Güçlendirme seviyesi:")) {
					this.setPlusIndex(i);
					String plustext = this.lorea.get(i);
					String newtext = plustext.substring(plustext.length()-2);
					int plus = Integer.parseInt(newtext.trim());
					this.setItemPlus(plus);
					this.setType(this.getItemMaterial());
				}}
		
		return true;
			}
			
		
		
		else {
			return false;
		}}catch(Exception ex) {
			System.out.println("Buldum");
			System.out.println(this.getLorea());return false;}
	}
	public List<String> getLorea() {
		return lorea;
	}
	public void setLorea(List<String> lorea) {
		this.lorea = lorea;
	}

	public boolean isCustomItem() {
		return isCustomItem;
	}

	public void setCustomItem(boolean isCustomItem) {
		this.isCustomItem = isCustomItem;
	}

}
