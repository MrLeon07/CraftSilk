package items;

import java.util.Arrays;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemsBase extends ItemStack{
	
	private int itemPlus = 0;//�temin + derecesini g�sterir. + derecesi attr�k�a damageall enchant seviyesi artar
	private String ItemName = "Customsword";//E�yan�n temel ad�
	private Material ItemMaterial = Material.WOODEN_SWORD;// itemin materiali. Varsay�lan olarak wood
	private Map<Enchantment,Integer> Enchant = this.getEnchantments();// Varsay�lan� zaten var olan enchler
	private int id = 1;// e�yan�n idsi varsay�lan 1 yani 1. seviye k�l��
	private String ItemStageName = "S�radan"; // �tem d�zeyi item idsi ile de�i�ecek �ekilde ayarlanacak
	private String ItemDesc = "Ger�ek sava���n�n ilk k�l�c�"; // Hawal� bir a��klama :D
	private int itemStageLevel = 1; // Stage level plus ile toplan�r ve enchant seviyesini att�r�r
	//-------------------------------------- �RNEK MET�NLER ----------------
		//Bunlar detectorde kullan�l�yor kolayl�k olsun diye buraya ekledim. Uzunluk vs. al�yorum. ayr�ca update methodunda da yer al�yorlar.
	public final String guclendirme = "G��lendirme seviyesi: ";
	public final String s�ralama = "Item s�ralamas�: ";
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
			this.setType(this.getItemMaterial());//�ncelikle material tipi belirle ard�ndan metadata al yoksa hata verir
			ItemMeta meta =this.getItemMeta();
			meta.setLore(Arrays.asList(
					this.guclendirme+this.getItemPlus(),"",
					this.s�ralama+this.getItemStageName(),""
					,"","",this.getItemDesc(),this.kod+this.getId()));
			meta.setDisplayName(getItemName());
			
			this.setItemMeta(meta); //Metay� iteme aktar�yor
			
			
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
	//�mmutable maps ile ilgili sorun var enchantlar� d�zelt sonras�nda + basma sistemi tamamd�r. 
	// ard�ndan item y�kseltme sistemine ge� ya da + basma itemi i�ine gir
	
	//Her i�lemden sonra update at ki i�lemler e�yaya ge�sin.

}
