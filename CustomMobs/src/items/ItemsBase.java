package items;

import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemsBase extends ItemStack{
	
	private int itemPlus = 0;//�temin + derecesini g�sterir. + derecesi attr�k�a damageall enchant seviyesi artar
	private String CustomName;;//E�yan�n temel ad�
	private String materialType;
	private int id ;// e�yan�n idsi varsay�lan 1 yani 1. seviye k�l��
	private String ItemStageName; // �tem d�zeyi item idsi ile de�i�ecek �ekilde ayarlanacak
	private String ItemDesc; // Hawal� bir a��klama :D
	private int itemStageLevel;; // Stage level plus ile toplan�r ve enchant seviyesini att�r�r
	private int baseValue;
	public int getItemPlus() {
		return itemPlus;
	}
	public void setItemPlus(int itemPlus) {
		this.itemPlus = itemPlus;
	}
	public String getCustomName() {
		return CustomName;
	}
	public void setCustomName(String customName) {
		CustomName = customName;
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
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	public int getItemStageLevel() {
		return itemStageLevel;
	}
	public void setItemStageLevel(int itemStageLevel) {
		this.itemStageLevel = itemStageLevel;
	}
	public int getBaseValue() {
		return baseValue;
	}
	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}
	public int getMaxPlus() {
		return maxPlus;
	}
	public void setMaxPlus(int maxPlus) {
		this.maxPlus = maxPlus;
	}
	public double getPerPlus() {
		return perPlus;
	}
	public void setPerPlus(double perPlus) {
		this.perPlus = perPlus;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getGuclendirme() {
		return guclendirme;
	}
	public String getS�ralama() {
		return s�ralama;
	}
	public String getKod() {
		return kod;
	}
	private int maxPlus;
	private double perPlus;
	private String slot;
	
	//-------------------------------------- �RNEK MET�NLER ----------------
		//Bunlar detectorde kullan�l�yor kolayl�k olsun diye buraya ekledim. Uzunluk vs. al�yorum. ayr�ca update methodunda da yer al�yorlar.
	public final String guclendirme = "G��lendirme seviyesi: ";
	public final String s�ralama = "Item s�ralamas�: ";
	public final String kod ="Item id: ";
	public final String type = "Item Type: ";
	//----------------------------Getter,Setter--------------------------------
	//----------------------------Update----------------------------------
	public void update() {
		try {		
			
			
		
		if(this.getType()!=null) {
			this.setAmount(1);
			ItemMeta meta =this.getItemMeta();
			ArrayList<String[]> lores = new ArrayList<String[]>();
			String[] lore1 = {this.guclendirme+this.getItemPlus(),"",this.s�ralama+this.getItemStageName().trim(),""
					,"",this.type+this.materialType};
			String[] lore2 = this.getLimitedArray(10, this.getItemDesc());
			String[] lore3 = {this.kod+this.getId()};
			lores.add(lore1);lores.add(lore2);lores.add(lore3);
			meta.setLore(Arrays.asList(this.getComplatedList(lores)));
			lores=null;lore1=null;lore2=null;lore3=null;
			meta.setDisplayName(getCustomName());
			
			this.setItemMeta(meta); //Metay� iteme aktar�yor
			
			
		
			
		}}
		catch(Exception e){
			
			System.out.println("Update Meta: "+this.getItemMeta());
			System.out.println("Couldnt update lore item id:"+this.getId()+" message: "+e.getMessage());
		}
		
	}
	//--------------------------------Plus--------------------------
	//�mmutable maps ile ilgili sorun var enchantlar� d�zelt sonras�nda + basma sistemi tamamd�r. 
	// ard�ndan item y�kseltme sistemine ge� ya da + basma itemi i�ine gir
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String[] getLimitedArray(int Limit,String string) {
		String[] list = string.split(" ");
		ArrayList<String> lore = new ArrayList<String>();
		String str ="";
		for(int i = 0;i<list.length;i++) {
			str+=list[i]+" ";
			if(str.length()>Limit) {
				lore.add(str.trim());
				str = "";}}
		lore.add(str);
		String loreas = "";
		for(String a: lore) {loreas+=a+"%%%";}
		return loreas.split("%%%");
	}
	public String[] getComplatedList(ArrayList<String[]> StringList) {
		int size = 0;
		for(String[] array:StringList) {size+=array.length;}
		String[] lastList = new String[size];
		int index = 0;
		for(String[] array:StringList) {
			for(int i =0;i<array.length;i++) {
				lastList[index] = array[i];
				index++;
			}
		}
		return lastList;
	}
	
	//Her i�lemden sonra update at ki i�lemler e�yaya ge�sin.

}
