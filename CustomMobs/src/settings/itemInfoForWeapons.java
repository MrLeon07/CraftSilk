package settings;

import org.bukkit.Material;

public class itemInfoForWeapons extends itemInfoBase{
	private int baseDamage = 0;
	private double baseAttackSpeed = 1.5;
	private double attack_power_per_plus = 1;
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	public double getBaseAttackSpeed() {
		return baseAttackSpeed;
	}
	public void setBaseAttackSpeed(double baseAttackSpeed) {
		this.baseAttackSpeed = baseAttackSpeed;
	}
	public double getAttack_power_per_plus() {
		return attack_power_per_plus;
	}
	public void setAttack_power_per_plus(double attackPowerPerPlus) {
		this.attack_power_per_plus = attackPowerPerPlus;
	}
/////////////////////////////////Constructor Method//////////////////////////////////////////////////////
	public itemInfoForWeapons(Material material,int id,int baseDamage,int plus_limit,double attackPowerPerPlus) {
		this.setSlotName("mainhand");
		this.setPlusLimit(plus_limit);
		this.setBaseDamage(baseDamage);
		this.setMaterial(material);
		this.setId(id);
		this.setAttack_power_per_plus(attackPowerPerPlus);
		
		
	}
	public int[] getDamageUUID() {
		int[] intArray  = {(this.getId()*1000)+2,(this.getId()*1000)+2,(this.getId()*1000)+2,(this.getId()*1000)+2};
		return intArray;
	}
	

}
