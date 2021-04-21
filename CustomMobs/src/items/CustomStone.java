package items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomStone extends ItemsBase{
	private String effectives;
	private Enchantment enchantment;
	private String genericData;
	@SuppressWarnings("deprecation")
	public CustomStone(int id,Material material,String CustomName,int CustomModel,String genericData,String EnchName,String effectiveTypes,String desc,String type) {
		this.setMaterialType(type);
		this.setEffectives(effectiveTypes);
		this.setGenericData(genericData);
		if(genericData.equalsIgnoreCase("enchantment")) {
			this.setEnchantment(Enchantment.getByName(EnchName));
		}
		else {
			this.enchantment = null;
		}
		this.setId(id);
		this.setAmount(1);	
		this.setType(material);
		this.setCustomName(CustomName);	
		ItemMeta meta = this.getItemMeta();meta.setCustomModelData(CustomModel);this.setItemMeta(meta);
		this.setItemPlus(0);
		this.setItemDesc(desc);
		this.update();
		}

	public String getEffectives() {
		String effective="None";
		if(this.effectives.equalsIgnoreCase("all")) {
			effective = "Bütün eþyalar";			
		}
		else if(this.effectives.equalsIgnoreCase("arm")) {
			effective="Zýrhlar";
		}
		else if(this.effectives.equalsIgnoreCase("wep")) {
			effective ="Silahlar";
		}
		return effective;
	}
	private void setEffectives(String effectives) {
		this.effectives = effectives;
	}
	public Enchantment getEnchantment() {
		return enchantment;
	}
	private void setEnchantment(Enchantment enchantment) {
		this.enchantment = enchantment;
	}
	public String getGenericData() {
		return genericData;
	}
	private void setGenericData(String genericData) {
		this.genericData = genericData;
	}

	@Override
	public void update() {
		try {
			if(this.getType()!=null) {
				this.setAmount(1);
				ItemMeta meta =this.getItemMeta();				
				meta.setLore(Arrays.asList(
						this.type+this.getMaterialType(),"","Etki eder: "+this.getEffectives(),this.getItemDesc(),this.kod+this.getId()));
				meta.setDisplayName(getCustomName());				
				this.setItemMeta(meta); //Metayý iteme aktarýyor	
			}}
			catch(Exception e){
				
				System.out.println("Update Meta: "+this.getItemMeta());
				System.out.println("Couldnt update lore item id:"+this.getId()+" message: "+e.getMessage());
			}
		
	}


}
