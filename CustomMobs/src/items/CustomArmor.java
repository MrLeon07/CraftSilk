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
	int armorPlus = 0;//�temin + derecesini g�sterir. + derecesi attr�k�a damageall enchant seviyesi artar
	String armorName = "Custom Armor";//E�yan�n temel ad�


	int id = 2;// e�yan�n idsi varsay�lan 1 yani 
	String armorStageName ="S�radan"; // �tem d�zeyi item idsi ile de�i�ecek �ekilde ayarlanacak
	String armorDesc = "Baslang�c icin g�zel bir z�rh parcas�"; // Hawal� bir a��klama :D
	int armorStageLevel = 1; // Stage level plus ile toplan�r ve enchant seviyesini att�r�r
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
