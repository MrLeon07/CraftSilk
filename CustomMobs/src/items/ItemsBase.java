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
	//-------------------------------------- ÖRNEK METÝNLER ----------------
		//Bunlar detectorde kullanýlýyor kolaylýk olsun diye buraya ekledim. Uzunluk vs. alýyorum. ayrýca update methodunda da yer alýyorlar.
	public final String guclendirme = "Güçlendirme seviyesi: ";
	public final String sýralama = "Item sýralamasý: ";
	public final String kod ="Item id: ";
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
			this.setType(this.getItemMaterial());//Öncelikle material tipi belirle ardýndan metadata al yoksa hata verir
			ItemMeta meta =this.getItemMeta();
			meta.setLore(Arrays.asList(
					this.guclendirme+this.getItemPlus(),"",
					this.sýralama+this.getItemStageName(),""
					,"","",this.getItemDesc(),this.kod+this.getId()));
			meta.setDisplayName(getItemName());
			
			this.setItemMeta(meta); //Metayý iteme aktarýyor
			
			
			//meta.setLore(this.getLore());
			//this.setItemMeta(meta);
			this.removeEnchantment(Enchantment.DAMAGE_ALL);
			this.addEnchantments(this.Enchant);
			
		}}
		catch(Exception e){
			System.out.println("Update Meta: "+this.getItemMeta());
			System.out.println("Update material: "+this.getItemMaterial());
			System.out.println("Hata update de");
		}
		
	}
	//--------------------------------Plus--------------------------
	//Ýmmutable maps ile ilgili sorun var enchantlarý düzelt sonrasýnda + basma sistemi tamamdýr. 
	// ardýndan item yükseltme sistemine geç ya da + basma itemi iþine gir
	
	//Her iþlemden sonra update at ki iþlemler eþyaya geçsin.

}
