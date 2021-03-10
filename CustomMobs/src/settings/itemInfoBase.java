package settings;

import java.util.HashMap;

import org.bukkit.Material;

public class itemInfoBase {
	private int id;
	private int PlusLimit;
	private HashMap<Integer,Double> plusRatio;
	private String slotName;
	private Material material;
	public int getPlusLimit() {
		return PlusLimit;
	}
	public void setPlusLimit(int plusLimit) {
		PlusLimit = plusLimit;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public HashMap<Integer,Double> getPlusRatio() {
		return plusRatio;
	}
	public void setPlusRatio(HashMap<Integer,Double> plusRatio) {
		this.plusRatio = plusRatio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSlotName() {
		return slotName;
	}
	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}
	

}
