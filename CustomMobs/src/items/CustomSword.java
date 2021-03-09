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
	int swordPlus = 0;//�temin + derecesini g�sterir. + derecesi attr�k�a damageall enchant seviyesi artar
	String swordName = "Custom Sword";//E�yan�n temel ad�


	int id = 1;// e�yan�n idsi varsay�lan 1 yani 1. seviye k�l��
	String swordStageName ="S�radan"; // �tem d�zeyi item idsi ile de�i�ecek �ekilde ayarlanacak
	String swordDesc = "Gercek savasc�n�n ilk k�l�c�"; // Hawal� bir a��klama :D
	int swordStageLevel = 1; // Stage level plus ile toplan�r ve enchant seviyesini att�r�r
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
