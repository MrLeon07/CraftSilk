package items;

import org.bukkit.Material;

public class CustomArmor extends ItemsBase{
	private int customDeffence = 1;

	public int getCustomDeffence() {
		return customDeffence;
	}
	public void setCustomDeffence(int customDeffence) {
		this.customDeffence = customDeffence;
	}
	Material material = Material.LEATHER_HELMET;
	int armorPlus = 0;//Ýtemin + derecesini gösterir. + derecesi attrýkça damageall enchant seviyesi artar
	String armorName = "Custom Armor";//Eþyanýn temel adý


	int id = 2;// eþyanýn idsi varsayýlan 1 yani 
	String armorStageName ="Sýradan"; // Ýtem düzeyi item idsi ile deðiþecek þekilde ayarlanacak
	String armorDesc = "Baslangýc icin güzel bir zýrh parcasý"; // Hawalý bir açýklama :D
	int armorStageLevel = 1; // Stage level plus ile toplanýr ve enchant seviyesini attýrýr
	public CustomArmor() {

		this.setId(1);
		this.setAmount(1);
		this.setItemMaterial(this.material);
		this.setItemName(armorName);
		this.setItemPlus(armorPlus);
		this.setId(id);
		this.setItemDesc(armorDesc);
		this.setItemStageName(armorStageName);
		this.setItemStageLevel(armorStageLevel);
		this.update();
		
}}
