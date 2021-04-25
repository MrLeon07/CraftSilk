package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import items.CustomArmor;
import items.CustomStone;
import items.CustomSword;
import settings.Stages;

public class DBconnector {

	private String url;
	private String password;	
	private String username;
	
	public DBconnector(String url,String username,String password) {
		this.url = url;
		this.username = username;
		this.password = password;
		
	}
	private Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(this.url, this.username, this.password);
			return conn;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
			
		}
		
	}
	@SuppressWarnings("unused")
	public boolean tryConnect() {
		Connection conn = this.getConnection();
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(conn == null) {
			return false;}
		else {
			return true;
		}
		
		
	}
	public HashMap<Integer,CustomArmor> getArmors() {
		HashMap<Integer,CustomArmor> armors = new HashMap<Integer,CustomArmor>();

		Connection conn = this.getConnection();
		ResultSet result = null;
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("select * from customitems where ItemType = 'arm'");
			try {
				while(result.next()) {
					int id = result.getInt("id");
					String serverName = result.getString("item_code");
					String name = result.getString("custom_name");
					int baseValue = result.getInt("baseValue");
					int plusLimit = result.getInt("maxPlus");
					double perPlus = result.getDouble("perPlusIncrement");
					int maxHp = result.getInt("maxHp");
					String slotName = result.getString("slotName");
					int CustomModel = result.getInt("CustomModel");
					String desc = result.getString("description");
					int stage = result.getInt("stage");
					String type = result.getString("type");
					try {
						armors.put(id, new CustomArmor(id,Material.valueOf(serverName.toUpperCase()),name,baseValue,plusLimit,perPlus,maxHp,slotName,CustomModel,desc,stage,type));
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Zýrh listeye eklendi. id: "+id);
					}
					catch(Exception e) {
						System.out.println("<Generator> Zýrh yüklenemedi. id: "+id+" server name: "+serverName);					
					}
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"<Database> "+ChatColor.DARK_PURPLE+"Zýrh verileri alýnamadý. Error message: "+e.getMessage());		}
		try {
			conn.close();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+"<Database> GetArmors conn.close: "+e.getMessage());
		}
		return armors;
		}
	public HashMap<Integer,CustomSword> getSwords() {
		HashMap<Integer,CustomSword> weapons = new HashMap<Integer,CustomSword>();

		ResultSet result = null;
		Connection conn = this.getConnection();
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("select * from customitems where ItemType = 'wep'");
			try {
				while(result.next()) {
					int id = result.getInt("id");
					String serverName = result.getString("item_code");
					String name = result.getString("custom_name");
					int baseValue = result.getInt("baseValue");
					int plusLimit = result.getInt("maxPlus");
					double perPlus = result.getDouble("perPlusIncrement");
					String slotName = result.getString("slotName");
					int CustomModel = result.getInt("CustomModel");
					String desc = result.getString("description");
					int stage = result.getInt("stage");
					String type = result.getString("type");
					
					try {
						weapons.put(id, new CustomSword(id,Material.valueOf(serverName.toUpperCase()),name,baseValue,plusLimit,perPlus,slotName,CustomModel,desc,stage,type));
						
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Kýlýc listeye eklendi. id: "+id);
					}
					catch(Exception e) {
						
						System.out.println("<Generator> Kýlýc yüklenemedi. id: "+id+" server name: "+serverName+" Hata: "+ e.getMessage());					
					}
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"<Database> "+ChatColor.DARK_PURPLE+"Kýlýc verileri alýnamadý. Error message: "+e.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+"<Database> GetArmors conn.close: "+e.getMessage());
		}
		
		
		return weapons;
	}
	public HashMap<Integer,Stages> getStages(){
		HashMap<Integer,Stages> stages = new HashMap<Integer,Stages>();

		ResultSet result = null;
		Connection conn = this.getConnection();
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("select * from itemstages");
			try {
				while(result.next()) {
					int StageLevel = result.getInt("StageLevel");
					String StageName = result.getString("StageName");
					int CustomModel = result.getInt("CustomModelCode");
					
					try {
						stages.put(StageLevel, new Stages(StageName, CustomModel));
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Stage yüklendi. Name: "+StageName);
					}
					catch(Exception e) {
						System.out.println("<Generator> Stage yüklenemedi. Name: "+StageName+" Stage level: "+StageLevel);					
					}
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"<Database> "+ChatColor.DARK_PURPLE+"Stage verileri alýnamadý. Error message: "+e.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+"<Database> GetStages conn.close: "+e.getMessage());
		}
		
		
		return stages;
	}
	public HashMap<Integer,CustomStone> getStones(){
		HashMap<Integer,CustomStone> Stones = new HashMap<Integer,CustomStone>();

		ResultSet result = null;
		Connection conn = this.getConnection();
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("select * from customstone");
			try {
				while(result.next()) {
					int id = result.getInt("id");
					String CustomName = result.getString("customName");
					String serverName = result.getString("serverName");
					int CustomModel = result.getInt("customModel");
					String generic = result.getString("genericData");
					String Enchantment = result.getString("enchantment");
					String effective = result.getString("effectiveType");
					String desc = result.getString("description");
					String Type = result.getString("type");
					try {
						Stones.put(id, new CustomStone(id, Material.valueOf(serverName.toUpperCase()), CustomName, CustomModel, generic, Enchantment, effective, desc, Type));
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Stone yüklendi. Name: "+CustomName);
						
					}
					catch(Exception e) {
						System.out.println("<Generator> Stone yüklenemedi. Name: "+CustomName+" Stone id: "+id);
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"<Database> "+ChatColor.DARK_PURPLE+"Stone verileri alýnamadý. Error message: "+e.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+"<Database> GetStones conn.close: "+e.getMessage());
		}
		
		
		return Stones;
	}
}
