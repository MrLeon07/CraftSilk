package GameSystem;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import items.Detector;
import items.ItemsBase;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.NBTTagList;

public class AlchemyBase {

	public ItemsBase resetPlus(ItemsBase item) {
		item.setItemPlus(0);
		
		int itemStageLevel = item.getItemStageLevel();
		net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = nmsStack.getOrCreateTag();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		NBTTagCompound attackSpeed = new NBTTagCompound();
		damage.setString("AttributeName", "generic.attack_damage");
		damage.setString("Name", "generic.attack_damage");
		damage.setString("Slot", "mainhand");
		damage.setInt("Operation", 0);
		damage.setDouble("Amount", (10+(itemStageLevel*5)));
		int[] intArray = {42853, 1689024593, -201178, -1559272105};
		damage.setIntArray("UUID",intArray );
		modifiers.add(damage);
		modifiers.add(attackSpeed);
		tag.set("AttributeModifiers", modifiers);
		nmsStack.setTag(tag);
		ItemStack new_item = CraftItemStack.asBukkitCopy(nmsStack);
		Detector det = new Detector(new_item);
		item = det.getItem();
		item.update();
		return item;
		
	}
	public ItemsBase incrasePlus(ItemsBase item) {
		item.setItemPlus(item.getItemPlus()+1);
		int itemPlus = item.getItemPlus();
		int itemStageLevel = item.getItemStageLevel();
		net.minecraft.server.v1_16_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = nmsStack.getOrCreateTag();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		NBTTagCompound attackSpeed = new NBTTagCompound();
		damage.setString("AttributeName", "generic.attack_damage");
		damage.setString("Name", "generic.attack_damage");
		damage.setString("Slot", "mainhand");
		damage.setInt("Operation", 0);
		damage.setDouble("Amount", (10+(itemStageLevel*5))+(itemPlus*1.3));
		int[] intArray = {42853, 1689024593, -201178, -1559272105};
		damage.setIntArray("UUID",intArray );
		modifiers.add(damage);
		modifiers.add(attackSpeed);
		tag.set("AttributeModifiers", modifiers);
		nmsStack.setTag(tag);
		ItemStack new_item = CraftItemStack.asBukkitCopy(nmsStack);
		Detector det = new Detector(new_item);
		item = det.getItem();
		item.update();
		return item;
	}
		
	
	public ItemsBase addBlue(ItemStack Stone,ItemsBase item) {
		///////BURAYI DÜZELT BOZUK BURASI ////////////////////////
		if(Stone.getType() == Material.GUNPOWDER) {
			try {
				if(item.getEnch().containsKey(Enchantment.KNOCKBACK)) {
					int enchLevel = item.getEnchantmentLevel(Enchantment.KNOCKBACK);
					enchLevel++;
					
					item.addEnchantment(Enchantment.KNOCKBACK, enchLevel);}
				else {item.addEnchantment(Enchantment.KNOCKBACK, 1);}
				
			} catch (Exception e) {System.out.println("savurma eklenemedi");}
			
		}
		if(Stone.getType() == Material.SUGAR) {
			try {
				if(item.getEnch().containsKey(Enchantment.SWEEPING_EDGE)) {
					int enchLevel = item.getEnchantmentLevel(Enchantment.SWEEPING_EDGE);
					enchLevel++;
					
					item.addEnchantment(Enchantment.SWEEPING_EDGE, enchLevel);}
				else {item.addEnchantment(Enchantment.SWEEPING_EDGE, 1);}
				
			} catch (Exception e) {System.out.println("süpürücü kenar eklenemedi");}
		}
		if(Stone.getType() == Material.REDSTONE) {
			try {
				if(item.getEnch().containsKey(Enchantment.FIRE_ASPECT)) {
					int enchLevel = item.getEnchantmentLevel(Enchantment.FIRE_ASPECT);
					enchLevel++;
					
					item.addEnchantment(Enchantment.FIRE_ASPECT, enchLevel);}
				else {item.addEnchantment(Enchantment.FIRE_ASPECT, 1);}
				
			} catch (Exception e) {System.out.println("Fire aspect eklenemedi");}
		}
				
		item.update();
		
		
		return item;
		
	}

}
