package settings;

import java.util.HashMap;

import org.bukkit.Material;

public class generator {

	public HashMap<Material,itemInfoForArmors> generateDefaultArmor(){
		HashMap<Material,itemInfoForArmors> armors = new HashMap<Material,itemInfoForArmors>();
		//(Material material,int id,int baseDeffence,int max_plus,int armor_deffence_per_plus,String slotName,int max_health)
		/*ResultSet results = main.Main.DbConnection.getArmors();
		try {
			while(results.next()) {
				int id = results.getInt("id");
				String serverName = results.getString("item_code");
				int base = results.getInt("baseValue");
				int plusLimit = results.getInt("maxPlus");
				double perPlus = results.getDouble("perPlusIncrement");
				int maxHp = results.getInt("maxHp");
				String slotName = results.getString("slotName");
				try {
					armors.put(Material.valueOf(serverName), new itemInfoForArmors(Material.valueOf(serverName),id,base,plusLimit,perPlus,slotName,maxHp));
					Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Zýrh listeye eklendi. id: "+id);
				}
				catch(Exception e) {
					System.out.println("<Generator> Zýrh yüklenemedi. id: "+id+" server name: "+serverName);					
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		armors.put(Material.LEATHER_HELMET, new itemInfoForArmors(Material.LEATHER_HELMET,51, 1, 10, 1, "head",2));
		armors.put(Material.LEATHER_CHESTPLATE, new itemInfoForArmors(Material.LEATHER_CHESTPLATE,52, 3, 10, 1, "chest",2));
		armors.put(Material.LEATHER_LEGGINGS, new itemInfoForArmors(Material.LEATHER_HELMET,53, 2, 10, 1, "legs",2));
		armors.put(Material.LEATHER_BOOTS, new itemInfoForArmors(Material.LEATHER_HELMET,54, 1, 10, 1, "feet",2));
		
		armors.put(Material.CHAINMAIL_HELMET, new itemInfoForArmors(Material.CHAINMAIL_HELMET,55, 1, 10, 1, "head",3));
		armors.put(Material.CHAINMAIL_CHESTPLATE, new itemInfoForArmors(Material.CHAINMAIL_CHESTPLATE,56, 3, 10, 1, "chest",3));
		armors.put(Material.CHAINMAIL_LEGGINGS, new itemInfoForArmors(Material.CHAINMAIL_LEGGINGS,57, 2, 10, 1, "legs",3));
		armors.put(Material.CHAINMAIL_BOOTS, new itemInfoForArmors(Material.CHAINMAIL_BOOTS,58, 1, 10, 1, "feet",3));
		
		armors.put(Material.GOLDEN_HELMET, new itemInfoForArmors(Material.GOLDEN_HELMET,59, 1, 10, 2, "head",4));
		armors.put(Material.GOLDEN_CHESTPLATE, new itemInfoForArmors(Material.GOLDEN_CHESTPLATE,60, 3, 10, 2, "chest",4));
		armors.put(Material.GOLDEN_LEGGINGS, new itemInfoForArmors(Material.GOLDEN_LEGGINGS,61, 2, 10, 2, "legs",4));
		armors.put(Material.GOLDEN_BOOTS, new itemInfoForArmors(Material.GOLDEN_BOOTS,62, 1, 10, 2, "feet",4));
		
		armors.put(Material.IRON_HELMET, new itemInfoForArmors(Material.IRON_HELMET,63, 1, 10, 3, "head",6));
		armors.put(Material.IRON_CHESTPLATE, new itemInfoForArmors(Material.IRON_CHESTPLATE,64, 3, 10, 3, "chest",6));
		armors.put(Material.IRON_LEGGINGS, new itemInfoForArmors(Material.IRON_LEGGINGS,65, 2, 10, 3, "legs",6));
		armors.put(Material.IRON_BOOTS, new itemInfoForArmors(Material.IRON_BOOTS,66, 1, 10, 3, "feet",6));
		
		armors.put(Material.DIAMOND_HELMET, new itemInfoForArmors(Material.DIAMOND_HELMET,67, 1, 10, 4, "head",8));
		armors.put(Material.DIAMOND_CHESTPLATE, new itemInfoForArmors(Material.DIAMOND_CHESTPLATE,68, 3, 10, 4, "chest",8));
		armors.put(Material.DIAMOND_LEGGINGS, new itemInfoForArmors(Material.DIAMOND_LEGGINGS,69, 2, 10, 4, "legs",8));
		armors.put(Material.DIAMOND_BOOTS, new itemInfoForArmors(Material.DIAMOND_BOOTS,70, 1, 10, 4, "feet",8));
		
		armors.put(Material.NETHERITE_HELMET, new itemInfoForArmors(Material.NETHERITE_HELMET,71, 1, 10, 5, "head",10));
		armors.put(Material.NETHERITE_CHESTPLATE, new itemInfoForArmors(Material.NETHERITE_CHESTPLATE,72, 3, 10, 5, "chest",10));
		armors.put(Material.NETHERITE_LEGGINGS, new itemInfoForArmors(Material.NETHERITE_LEGGINGS,73, 2, 10, 5, "legs",10));
		armors.put(Material.NETHERITE_BOOTS, new itemInfoForArmors(Material.NETHERITE_BOOTS,74, 1, 10, 5, "feet",10));*/
		
		
		return armors;
	}
	public HashMap<Material,itemInfoForWeapons> generateDefaultWeapons(){
		HashMap<Material,itemInfoForWeapons> weapons = new HashMap<Material,itemInfoForWeapons>();
		/*weapons.put(Material.WOODEN_SWORD, new itemInfoForWeapons(Material.WOODEN_SWORD,1 ,4, 10,2.2 ));
		weapons.put(Material.STONE_SWORD, new itemInfoForWeapons(Material.STONE_SWORD, 2, 5,10, 2.5));
		weapons.put(Material.GOLDEN_SWORD, new itemInfoForWeapons(Material.GOLDEN_SWORD, 4, 5,10, 2.0));
		weapons.put(Material.IRON_SWORD, new itemInfoForWeapons(Material.IRON_SWORD, 4, 6,10, 2.9));
		weapons.put(Material.DIAMOND_SWORD, new itemInfoForWeapons(Material.DIAMOND_SWORD, 5, 7,10, 4.0));
		weapons.put(Material.NETHERITE_SWORD, new itemInfoForWeapons(Material.NETHERITE_SWORD, 6, 8,10, 5.0));
		ResultSet results = main.Main.DbConnection.getArmors();
		try {
			while(results.next()) {
				int id = results.getInt("id");
				String serverName = results.getString("item_code");
				int base = results.getInt("baseValue");
				int plusLimit = results.getInt("maxPlus");
				double perPlus = results.getDouble("perPlusIncrement");
				
				try {
					weapons.put(Material.valueOf(serverName), new itemInfoForWeapons(Material.valueOf(serverName),id,base,plusLimit,perPlus));
					Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Kýlýc listeye eklendi. id: "+id);
				}
				catch(Exception e) {
					System.out.println("<Generator> Kýlýc yüklenemedi. id: "+id+" server name: "+serverName);					
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		/*/
		return weapons;
	}
}
