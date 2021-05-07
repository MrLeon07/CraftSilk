package items;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.NBTTagList;

public class CustomArmor extends ItemsBase{
	
	private int maxHp;
	private int[] HpUUID;
	private int[] DeffenceUUID;
	public CustomArmor(int id,Material material,String CustomName,int baseValue,int maxPlus,double perPlus,int maxHp,String Slot,int CustomModel,String desc,int StageLevel,String type) {
		this.setMaterialType(type);
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
	}
	public ItemStack getItem() {
		net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(this);
		NBTTagCompound tag = nmsStack.getOrCreateTag();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound deffence = new NBTTagCompound();
		deffence.setString("AttributeName", "generic.armor");
		deffence.setString("Name", "generic.armor");
		deffence.setString("Slot", this.getSlot());
		deffence.setInt("Operation", 0);
		deffence.setDouble("Amount",this.getBaseValue()+this.getPerPlus()*this.getItemPlus());	
		deffence.setIntArray("UUID",this.getDeffenceUUID());
		modifiers.add(deffence);
		tag.set("AttributeModifiers", modifiers);
		nmsStack.setTag(tag);
		ItemStack new_item = CraftItemStack.asBukkitCopy(nmsStack);
		return new_item;
	}}