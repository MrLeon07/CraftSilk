package settings;

import org.bukkit.Material;

public class itemInfoForArmors extends itemInfoBase{
	public double getMax_health() {
		return max_health;
	}
	public void setMax_health(double max_health) {
		this.max_health = max_health;
	}
	public double getMax_speed() {
		return max_speed;
	}
	public void setMax_speed(double max_speed) {
		this.max_speed = max_speed;
	}
	private double health_blue_chance;
	public double getHealth_blue_chance() {
		return health_blue_chance;
	}
	public void setHealth_blue_chance(double health_blue_chance) {
		this.health_blue_chance = health_blue_chance;
	}
	private double max_health;
	private double armor_deffence_power_per_plus = 1.0;
	private int baseDeffence = 1;
	private double max_speed;
	public itemInfoForArmors(String slotName,int armor_deffence_per_plus,int max_health,int max_plus,int id,Material material,int baseDeffence) {
		this.setId(id);
		this.setBaseDeffence(baseDeffence);
		this.setMaterial(material);
		this.setMax_health(max_health+1);
		this.setPlusLimit(max_plus);		
		this.setSlotName(slotName);
		this.setArmor_deffence_power_per_plus(armor_deffence_per_plus);
	}
	public double getArmor_deffence_power_per_plus() {
		return armor_deffence_power_per_plus;
	}
	public void setArmor_deffence_power_per_plus(double armor_deffence_power_per_plus) {
		this.armor_deffence_power_per_plus = armor_deffence_power_per_plus;
	}
	public int[] getDeffenceUUID() {
		int[] intArray = {(this.getId()*10)+1, (this.getId()*10)+1, (this.getId()*10)+1, (this.getId()*10)+1};
		return intArray;
	}
	public int[] getHealthUUID() {
		int[] intArray = {(this.getId()+2),(this.getId()+2),(this.getId()+2),(this.getId()+2)};
		return intArray;
	}
	public int getBaseDeffence() {
		return baseDeffence;
	}
	public void setBaseDeffence(int baseDeffence) {
		this.baseDeffence = baseDeffence;
	}
}
