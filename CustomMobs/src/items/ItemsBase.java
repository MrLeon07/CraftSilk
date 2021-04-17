package items;

import java.util.Arrays;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemsBase extends ItemStack{
	
	private int itemPlus = 0;//Ýtemin + derecesini gösterir. + derecesi attrýkça damageall enchant seviyesi artar
	private String CustomName;;//Eþyanýn temel adý
	
	private int id ;// eþyanýn idsi varsayýlan 1 yani 1. seviye kýlýç
	private String ItemStageName; // Ýtem düzeyi item idsi ile deðiþecek þekilde ayarlanacak
	private String ItemDesc; // Hawalý bir açýklama :D
	private int itemStageLevel;; // Stage level plus ile toplanýr ve enchant seviyesini attýrýr
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
	public String getSýralama() {
		return sýralama;
	}
	public String getKod() {
		return kod;
	}
	private int maxPlus;
	private double perPlus;
	private String slot;
	
	//-------------------------------------- ÖRNEK METÝNLER ----------------
		//Bunlar detectorde kullanýlýyor kolaylýk olsun diye buraya ekledim. Uzunluk vs. alýyorum. ayrýca update methodunda da yer alýyorlar.
	public final String guclendirme = "Güçlendirme seviyesi: ";
	public final String sýralama = "Item sýralamasý: ";
	public final String kod ="Item id: ";
	//----------------------------Getter,Setter--------------------------------
	//----------------------------Update----------------------------------
	public final void update() {
		try {		
			
			
		
		if(this.getType()!=null) {
			this.setAmount(1);
			ItemMeta meta =this.getItemMeta();
			
			meta.setLore(Arrays.asList(
					this.guclendirme+this.getItemPlus(),"",
					this.sýralama+this.getItemStageName().trim(),""
					,"","",this.getItemDesc(),this.kod+this.getId()));
			meta.setDisplayName(getCustomName());
			
			this.setItemMeta(meta); //Metayý iteme aktarýyor
			
			
		
			
		}}
		catch(Exception e){
			
			System.out.println("Update Meta: "+this.getItemMeta());
			System.out.println("Couldnt update lore item id:"+this.getId()+" message: "+e.getMessage());
		}
		
	}
	//--------------------------------Plus--------------------------
	//Ýmmutable maps ile ilgili sorun var enchantlarý düzelt sonrasýnda + basma sistemi tamamdýr. 
	// ardýndan item yükseltme sistemine geç ya da + basma itemi iþine gir

	
	//Her iþlemden sonra update at ki iþlemler eþyaya geçsin.

}
