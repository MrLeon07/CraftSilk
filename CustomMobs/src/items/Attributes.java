package items;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.NBTTagList;

public class Attributes {
	public Attributes(){
		
	}
	public ItemStack gen() {
	ItemStack item = new ItemStack(Material.DIAMOND_SWORD,1);
	ItemMeta itemMeta = item.getItemMeta();
	itemMeta.setDisplayName("Tagged Sword");
	itemMeta.setUnbreakable(true);
	item.setItemMeta(itemMeta);
	net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
	NBTTagCompound comp = nmsStack.getOrCreateTag();
	NBTTagList modifiers = new NBTTagList();
	NBTTagCompound damage = new NBTTagCompound();
	NBTTagCompound attackSpeed = new NBTTagCompound();
	damage.setString("AttributeName", "generic.attackDamage");
	damage.setString("Name", "generic.attackDamage");
	damage.setString("Slot", "mainhand");
	damage.setInt("Operation", 0);
	damage.setDouble("Amount", 500);
	damage.setInt("UUIDMost", 14526);
	damage.setInt("UUIDLeast", 45145);
	
	attackSpeed.setString("AttributeName", "generic.attackSpeed");
	attackSpeed.setString("Name", "generic.attackSpeed");
	attackSpeed.setString("Slot", "mainhand");
	attackSpeed.setInt("Operation", 0);
	attackSpeed.setDouble("Amount", -3.50);
	attackSpeed.setInt("UUIDMost", 86259);
	attackSpeed.setInt("UUIDLeast", 62561);
	modifiers.add(damage);
	modifiers.add(attackSpeed);
	comp.set("AttributeModifiers", modifiers);
	nmsStack.setTag(comp);
	return CraftItemStack.asBukkitCopy(nmsStack);
	
}}
