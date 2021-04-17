package items;


import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;


public class CustomSword extends ItemsBase{
	private int[] damageUUID;
	private int[] attackSpeedUUID;
	
	public CustomSword(int id,Material material,String CustomName,int baseValue,int maxPlus,double perPlus,String Slot,int CustomModel,String desc,int StageLevel) {
	
		this.setId(id);
		this.setAmount(1);		
		this.setType(material);
		this.setCustomName(CustomName);	
		this.setBaseValue(baseValue);
		this.setMaxPlus(maxPlus);
		this.setPerPlus(perPlus);
		this.setSlot(Slot);
		ItemMeta meta = this.getItemMeta();meta.setCustomModelData(CustomModel);this.setItemMeta(meta);
		this.setItemPlus(0);
		this.setItemDesc(desc);
		this.setItemStageName(main.Main.stages.get(StageLevel).getStageName());		
		this.setItemStageLevel(StageLevel);	
		this.update();
		this.generateUUIDs(id);}
	private void generateUUIDs(int id) {
		int[] da = {id*1000,id*1000,id*1000,id*1000};
		this.setDamageUUID(da);
		int[] sp = {id*1500,id*1500,id*1500,id*1500};
		this.setAttackSpeedUUID(sp);
		
	}
	public int[] getDamageUUID() {
		return damageUUID;
	}
	private void setDamageUUID(int[] damageUUID) {
		this.damageUUID = damageUUID;
	}
	public int[] getAttackSpeedUUID() {
		return attackSpeedUUID;
	}
	private void setAttackSpeedUUID(int[] attackSpeedUUID) {
		this.attackSpeedUUID = attackSpeedUUID;
	}


}
