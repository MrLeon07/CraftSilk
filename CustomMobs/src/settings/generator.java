package settings;

import java.util.HashMap;

import org.bukkit.Material;

public class generator {
	//(String slotName,double armor_deffence_per_plus,double max_health,int max_plus,int id,Material material,int baseDeffece)
	/*armors.putAll(Map.of(Material.LEATHER_HELMET, 1,Material.LEATHER_CHESTPLATE, 3, Material.LEATHER_LEGGINGS, 2, Material.LEATHER_BOOTS, 1,
				Material.CHAINMAIL_HELMET, 1,Material.CHAINMAIL_CHESTPLATE, 3, Material.CHAINMAIL_LEGGINGS, 2, Material.CHAINMAIL_BOOTS, 1));
		armors.putAll(Map.of(Material.IRON_HELMET, 1,Material.IRON_CHESTPLATE, 3, Material.IRON_LEGGINGS, 2, Material.IRON_BOOTS, 1,
				Material.GOLDEN_HELMET, 1,Material.GOLDEN_CHESTPLATE, 3, Material.GOLDEN_LEGGINGS, 2, Material.GOLDEN_BOOTS, 1));
		armors.putAll(Map.of(Material.DIAMOND_HELMET, 1,Material.DIAMOND_CHESTPLATE, 3, Material.DIAMOND_LEGGINGS, 2, Material.DIAMOND_BOOTS, 1,
				Material.NETHERITE_HELMET, 1,Material.NETHERITE_CHESTPLATE, 3, Material.NETHERITE_LEGGINGS, 2, Material.NETHERITE_BOOTS, 1));
				
		*/
	public HashMap<Material,itemInfoForArmors> generateDefaultArmor(){
		HashMap<Material,itemInfoForArmors> armors = new HashMap<Material,itemInfoForArmors>();
		armors.put(Material.LEATHER_HELMET, new itemInfoForArmors("head",1 , 5, 10, 250, Material.LEATHER_HELMET,1));
		armors.put(Material.LEATHER_CHESTPLATE, new itemInfoForArmors("chest",1 , 5, 20, 10, Material.LEATHER_CHESTPLATE,3));
		armors.put(Material.LEATHER_LEGGINGS, new itemInfoForArmors("legs",1 , 5, 10, 30, Material.LEATHER_LEGGINGS,2));
		armors.put(Material.LEATHER_BOOTS, new itemInfoForArmors("feet",1 , 5, 10, 40, Material.LEATHER_BOOTS,1));
		

		armors.put(Material.CHAINMAIL_HELMET, new itemInfoForArmors("head",1 , 5, 10, 50, Material.CHAINMAIL_HELMET,1));
		armors.put(Material.CHAINMAIL_CHESTPLATE, new itemInfoForArmors("chest",1 , 5, 10, 60, Material.CHAINMAIL_CHESTPLATE,3));
		armors.put(Material.CHAINMAIL_LEGGINGS, new itemInfoForArmors("legs",1 , 5, 10, 70, Material.CHAINMAIL_LEGGINGS,2));
		armors.put(Material.CHAINMAIL_BOOTS, new itemInfoForArmors("feet",1 , 5, 10, 80, Material.CHAINMAIL_BOOTS,1));
		
		armors.put(Material.IRON_HELMET, new itemInfoForArmors("head",1 , 5, 10, 90, Material.IRON_HELMET,1));
		armors.put(Material.IRON_CHESTPLATE, new itemInfoForArmors("chest",1 , 5, 10, 100, Material.IRON_CHESTPLATE,3));
		armors.put(Material.IRON_LEGGINGS, new itemInfoForArmors("legs",1 , 5, 10, 110, Material.IRON_LEGGINGS,2));
		armors.put(Material.IRON_BOOTS, new itemInfoForArmors("feet",1 , 5, 10, 120, Material.IRON_BOOTS,1));
		
		armors.put(Material.GOLDEN_HELMET, new itemInfoForArmors("head",1 , 5, 10, 130, Material.GOLDEN_HELMET,1));
		armors.put(Material.GOLDEN_CHESTPLATE, new itemInfoForArmors("chest",1 , 5, 10, 140, Material.GOLDEN_CHESTPLATE,3));
		armors.put(Material.GOLDEN_LEGGINGS, new itemInfoForArmors("legs",1 , 5, 10, 150, Material.GOLDEN_LEGGINGS,2));
		armors.put(Material.GOLDEN_BOOTS, new itemInfoForArmors("feet",1 , 5, 10, 160, Material.GOLDEN_BOOTS,1));
		
		armors.put(Material.DIAMOND_HELMET, new itemInfoForArmors("head",1 , 5, 10, 170, Material.DIAMOND_HELMET,1));
		armors.put(Material.DIAMOND_CHESTPLATE, new itemInfoForArmors("chest",1 , 5, 10, 180, Material.DIAMOND_CHESTPLATE,3));
		armors.put(Material.DIAMOND_LEGGINGS, new itemInfoForArmors("legs",1 , 5, 10, 190, Material.DIAMOND_LEGGINGS,2));
		armors.put(Material.DIAMOND_BOOTS, new itemInfoForArmors("feet",1 , 5, 10, 200, Material.DIAMOND_BOOTS,1));
		
		armors.put(Material.NETHERITE_HELMET, new itemInfoForArmors("head",1 , 5, 10, 210, Material.NETHERITE_HELMET,1));
		armors.put(Material.NETHERITE_CHESTPLATE, new itemInfoForArmors("chest",1 , 5, 10, 220, Material.NETHERITE_CHESTPLATE,3));
		armors.put(Material.NETHERITE_LEGGINGS, new itemInfoForArmors("legs",1 , 5, 10, 230, Material.NETHERITE_LEGGINGS,2));
		armors.put(Material.NETHERITE_BOOTS, new itemInfoForArmors("feet",1 , 5, 10, 240, Material.NETHERITE_BOOTS,1));
		return armors;
	}
	
}
