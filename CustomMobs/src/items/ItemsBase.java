package items;

import java.util.Arrays;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemsBase extends ItemStack{
	
	private int itemPlus = 0;//Ýtemin + derecesini gösterir. + derecesi attrýkça damageall enchant seviyesi artar
	
	private String ItemName = "Customsword";//Eþyanýn temel adý
	
	private Material ItemMaterial = Material.WOODEN_SWORD;// itemin materiali. Varsayýlan olarak wood

	private Map<Enchantment,Integer> Enchant = this.getEnchantments();// Varsayýlaný zaten var olan enchler
	private int id = 1;// eþyanýn idsi varsayýlan 1 yani 1. seviye kýlýç
	private String ItemStageName = "Sýradan"; // Ýtem düzeyi item idsi ile deðiþecek þekilde ayarlanacak
	private String ItemDesc = "Gerçek savaþçýnýn ilk kýlýcý"; // Hawalý bir açýklama :D
	private int itemStageLevel = 1; // Stage level plus ile toplanýr ve enchant seviyesini attýrýr
	//----------------------------Getter,Setter--------------------------------
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	public int getItemPlus() {
		return itemPlus;
	}
	public void setItemPlus(int itemPlus) {
		this.itemPlus = itemPlus;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
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
	public int getItemStageLevel() {
		return itemStageLevel;
	}
	public void setItemStageLevel(int itemStageLevel) {
		this.itemStageLevel = itemStageLevel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemStageName() {
		return ItemStageName;
	}
	public void setItemStageName(String itemStageName) {
		ItemStageName = itemStageName;
	}
	//----------------------------Update----------------------------------
	public final void update() {
		try {		
		
		if(this.getItemMaterial()!= null) {
			this.setAmount(1);
			ItemStack stackedItem = new ItemStack(this.getItemMaterial(),1);//Kopyalamak için örnek eþya oluþturdum
			
			ItemMeta meta =stackedItem.getItemMeta();
			meta.setLore(Arrays.asList(
					"Güçlendirme seviyesi: "+this.getItemPlus(),"",
					"Item sýralamasý: "+this.getItemStageName(),""
					,"","",this.getItemDesc(),"Item id: "+this.getId()));
			meta.setDisplayName(getItemName());
			
			this.setItemMeta(meta);
			this.setType(this.getItemMaterial());
			
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
	//--------------------------------Plus--------------------------
	
	public void resetPlus() {
		this.setItemPlus(0);
		this.Enchant.clear();
		this.update();
	}
	public void incrasePlus() {
		this.setItemPlus(this.getItemPlus()+1);
		this.Enchant.clear();
		int enchantlevel = this.getItemPlus()+this.getItemStageLevel();
		this.Enchant.put(Enchantment.DAMAGE_ALL, enchantlevel);// stagelevel+enchant level kadar damageall verir
		this.update();
	}
	//Her iþlemden sonra update at ki iþlemler eþyaya geçsin.

}
