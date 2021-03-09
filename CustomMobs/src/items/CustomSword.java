package items;


import org.bukkit.Material;


public class CustomSword extends ItemsBase{
	int customDamage = 4;
	public int getCustomDamage() {
		return customDamage;
	}
	public void setCustomDamage(int customDamage) {
		this.customDamage = customDamage;
	}
	Material material = Material.WOODEN_SWORD;
	int swordPlus = 0;//Ýtemin + derecesini gösterir. + derecesi attrýkça damageall enchant seviyesi artar
	String swordName = "Custom Sword";//Eþyanýn temel adý


	int id = 1;// eþyanýn idsi varsayýlan 1 yani 1. seviye kýlýç
	String swordStageName ="Sýradan"; // Ýtem düzeyi item idsi ile deðiþecek þekilde ayarlanacak
	String swordDesc = "Gercek savascýnýn ilk kýlýcý"; // Hawalý bir açýklama :D
	int swordStageLevel = 1; // Stage level plus ile toplanýr ve enchant seviyesini attýrýr
	public CustomSword() {

		this.setId(1);
		this.setAmount(1);
		this.setItemMaterial(this.material);
		this.setItemName(swordName);
		this.setItemPlus(swordPlus);
		this.setId(id);
		this.setItemDesc(swordDesc);
		this.setItemStageName(swordStageName);
		this.setItemStageLevel(swordStageLevel);
		this.update();
		
		
		
		
	}


}
