package GameSystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import items.CustomArmor;
import items.CustomSword;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.NBTTagList;

public class AlchemyBase {

	public ItemStack resetPlus(CustomSword item) {
		item.setItemPlus(0);
		
		System.out.println(item.getEnchantments());
		item.setItemPlus(0);
		item.update();
		net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = nmsStack.getOrCreateTag();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		damage.setString("AttributeName", "generic.attack_damage");
		damage.setString("Name", "generic.attack_damage");
		damage.setString("Slot",item.getSlot());
		damage.setInt("Operation", 0);
		damage.setDouble("Amount", item.getBaseValue());
		
		
		damage.setIntArray("UUID",item.getDamageUUID() );
		modifiers.add(damage);
		tag.set("AttributeModifiers", modifiers);
		nmsStack.setTag(tag);
		ItemStack new_item = CraftItemStack.asBukkitCopy(nmsStack);
		System.out.println(item.getEnchantments());
		new_item.addEnchantments(item.getEnchantments());
		return new_item;
		
		
	}
	public ItemStack resetPlus(CustomArmor item) {
		System.out.println(item.getEnchantments());
		item.setItemPlus(0);
		item.update();
		net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = nmsStack.getOrCreateTag();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound deffence = new NBTTagCompound();
		deffence.setString("AttributeName", "generic.armor");
		deffence.setString("Name", "generic.armor");
		deffence.setString("Slot",item.getSlot());
		deffence.setInt("Operation", 0);
		deffence.setDouble("Amount", item.getBaseValue());
		
		
		deffence.setIntArray("UUID",item.getDeffenceUUID());
		modifiers.add(deffence);
		tag.set("AttributeModifiers", modifiers);
		nmsStack.setTag(tag);
		ItemStack new_item = CraftItemStack.asBukkitCopy(nmsStack);
		System.out.println(item.getEnchantments());
		new_item.addEnchantments(item.getEnchantments());
		Bukkit.broadcastMessage(item.getEnchantments().toString());
		return new_item;
	}
	public ItemStack incrasePlus(CustomSword item) {
		if(item.getItemPlus()<item.getMaxPlus()) {
		item.setItemPlus(item.getItemPlus()+1);}
		else {
			System.out.println("Güçlendirme yapýlamadý");
		}
	
		
		item.update();
		net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = nmsStack.getOrCreateTag();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		damage.setString("AttributeName", "generic.attack_damage");
		damage.setString("Name", "generic.attack_damage");
		damage.setString("Slot", item.getSlot());
		damage.setInt("Operation", 0);
		damage.setDouble("Amount", item.getBaseValue()+(item.getPerPlus()*item.getItemPlus()));
	
		damage.setIntArray("UUID",item.getDamageUUID());
		modifiers.add(damage);
		tag.set("AttributeModifiers", modifiers);
		nmsStack.setTag(tag);
		ItemStack new_item = CraftItemStack.asBukkitCopy(nmsStack);
		System.out.println(item.getEnchantments());
		new_item.addEnchantments(item.getEnchantments());
		return new_item;
	}
	public ItemStack incrasePlus(CustomArmor item) {
		if(item.getItemPlus()<item.getMaxPlus()) {
		item.setItemPlus(item.getItemPlus()+1);}
		item.update();
		net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = nmsStack.getOrCreateTag();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound deffence = new NBTTagCompound();
		deffence.setString("AttributeName", "generic.armor");
		deffence.setString("Name", "generic.armor");
		deffence.setString("Slot", item.getSlot());
		deffence.setInt("Operation", 0);
		deffence.setDouble("Amount",item.getBaseValue()+item.getPerPlus()*item.getItemPlus());
		
		
		deffence.setIntArray("UUID",item.getDeffenceUUID());
		modifiers.add(deffence);
		tag.set("AttributeModifiers", modifiers);
		nmsStack.setTag(tag);
		ItemStack new_item = CraftItemStack.asBukkitCopy(nmsStack);
		System.out.println(item.getEnchantments());
		new_item.addEnchantments(item.getEnchantments());
		Bukkit.broadcastMessage(item.getEnchantments().toString());
		return new_item;
	}
	public ItemStack AddMaxHealthBlue(CustomArmor item) {
		net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = nmsStack.getOrCreateTag();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound deffence = new NBTTagCompound();
		deffence.setString("AttributeName", "generic.max_health");
		deffence.setString("Name", "generic.max_health");
		deffence.setString("Slot", item.getSlot());
		deffence.setInt("Operation", 0);
		deffence.setDouble("Amount", (int) Math.random()*item.getMaxHp());
		
		
		deffence.setIntArray("UUID",item.getHpUUID());
		modifiers.add(deffence);
		tag.set("AttributeModifiers", modifiers);
		nmsStack.setTag(tag);
		ItemStack new_item = CraftItemStack.asBukkitCopy(nmsStack);
		System.out.println(item.getEnchantments());
		new_item.addEnchantments(item.getEnchantments());
		Bukkit.broadcastMessage(item.getEnchantments().toString());
		return new_item;
		
		
	}
	
	public ItemStack addBlue(ItemStack Stone,ItemStack item) {
		
		net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);//nbt taglarý kopyala 
		NBTTagCompound tag = nmsStack.getTag();
		if(Stone.getType() == Material.GUNPOWDER) {//buradan aþaðýda enchler eklenir
			try {
				item.addEnchantment(Enchantment.KNOCKBACK,item.getEnchantmentLevel(Enchantment.KNOCKBACK)+1);
				
				
			} catch (Exception e) {System.out.println("savurma eklenemedi");}
			
		}
		if(Stone.getType() == Material.SUGAR) {
			try {
				item.addEnchantment(Enchantment.SWEEPING_EDGE,item.getEnchantmentLevel(Enchantment.SWEEPING_EDGE)+1);
				
			} catch (Exception e) {System.out.println("süpürücü kenar eklenemedi");}
		}
		if(Stone.getType() == Material.REDSTONE) {
			try {
				item.addEnchantment(Enchantment.FIRE_ASPECT,item.getEnchantmentLevel(Enchantment.FIRE_ASPECT)+1);
				
			} catch (Exception e) {System.out.println("Fire aspect eklenemedi");}
		}
		
		nmsStack.setTag(tag);
		ItemStack newStackedItem = CraftItemStack.asBukkitCopy(nmsStack);
		newStackedItem.addEnchantments(item.getEnchantments());//önceki enchleri yenilerine ekle
		
		
		return newStackedItem;
		
	}

}
