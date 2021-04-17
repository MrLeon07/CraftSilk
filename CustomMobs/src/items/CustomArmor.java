package items;

import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomArmor extends ItemsBase{
	
	private int maxHp;
	private int[] HpUUID;
	private int[] DeffenceUUID;
	public CustomArmor(int id,Material material,String CustomName,int baseValue,int maxPlus,double perPlus,int maxHp,String Slot,int CustomModel,String desc,int StageLevel) {

		this.setId(id);
		this.setAmount(1);		
		this.setType(material);
		this.setCustomName(CustomName);	
		this.setBaseValue(baseValue);
		this.setMaxPlus(maxPlus);
		this.setPerPlus(perPlus);
		this.setMaxHp(maxHp);
		this.setSlot(Slot);
		ItemMeta meta = this.getItemMeta();meta.setCustomModelData(CustomModel);this.setItemMeta(meta);
		this.setItemPlus(0);
		this.setItemDesc(desc);
		this.setItemStageName(main.Main.stages.get(StageLevel).getStageName());		
		this.setItemStageLevel(StageLevel);	
		this.update();
		this.generateUUID(id);
		
}
	private void generateUUID(int id) {
		int[] def = {id*1000,id*1000,id*1000,id*1000};
		int[] hp = {id*1500,id*1500,id*1500,id*1500};
		this.setDeffenceUUID(def);
		this.setHpUUID(hp);
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}


	public int[] getDeffenceUUID() {
		return DeffenceUUID;
	}

	private void setDeffenceUUID(int[] deffenceUUID) {
		DeffenceUUID = deffenceUUID;
	}
	public int[] getHpUUID() {
		return HpUUID;
	}

	private void setHpUUID(int[] hpUUID) {
		HpUUID = hpUUID;
	}}
