package items;

import java.util.Random;

import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.NBTTagList;

public class Attributes {

	public ItemStack gen(ItemStack item) {
	
	ItemMeta itemMeta = item.getItemMeta();
	itemMeta.setDisplayName("Tagged Sword");
	itemMeta.setUnbreakable(true);
	item.setItemMeta(itemMeta);
	Random rand = new Random();
	net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
	NBTTagCompound tag = nmsStack.getOrCreateTag();
	NBTTagList modifiers = new NBTTagList();
	NBTTagCompound damage = new NBTTagCompound();
	NBTTagCompound attackSpeed = new NBTTagCompound();
	damage.setString("AttributeName", "generic.attack_damage");
	damage.setString("Name", "generic.attack_damage");
	damage.setString("Slot", "mainhand");
	damage.setInt("Operation", 0);
	damage.setDouble("Amount", rand.nextDouble()*100);
	damage.setInt("UUIDMost", rand.nextInt(32000)+1);
	damage.setInt("UUIDLeast", rand.nextInt(64000)+32001);
	
	attackSpeed.setString("AttributeName", "generic.attack_speed");
	attackSpeed.setString("Name", "generic.attack_speed");
	attackSpeed.setString("Slot", "mainhand");
	attackSpeed.setInt("Operation", 0);
	attackSpeed.setDouble("Amount", -3.50);
	attackSpeed.setInt("UUIDMost", rand.nextInt(96000)+64001);
	attackSpeed.setInt("UUIDLeast", rand.nextInt(128000)+96001);
	modifiers.add(damage);
	modifiers.add(attackSpeed);
	tag.set("AttributeModifiers", modifiers);
	nmsStack.setTag(tag);
	return CraftItemStack.asBukkitCopy(nmsStack);
	
}}
