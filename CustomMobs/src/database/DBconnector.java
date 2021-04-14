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

import settings.Stages;
import settings.itemInfoForArmors;
import settings.itemInfoForWeapons;

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
	public HashMap<Material,itemInfoForArmors> getArmors() {
		HashMap<Material,itemInfoForArmors> armors = new HashMap<Material,itemInfoForArmors>();

		Connection conn = this.getConnection();
		ResultSet result = null;
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("select * from customitems where ItemType = 'arm'");
			try {
				while(result.next()) {
					int id = result.getInt("id");
					String serverName = result.getString("item_code");
					int base = result.getInt("baseValue");
					int plusLimit = result.getInt("maxPlus");
					double perPlus = result.getDouble("perPlusIncrement");
					int maxHp = result.getInt("maxHp");
					String slotName = result.getString("slotName");
					String name = result.getString("custom_name");
					try {
						armors.put(Material.valueOf(serverName), new itemInfoForArmors(Material.valueOf(serverName),id,base,plusLimit,perPlus,slotName,maxHp,name));
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
	public HashMap<Material,itemInfoForWeapons> getSwords() {
		HashMap<Material,itemInfoForWeapons> weapons = new HashMap<Material,itemInfoForWeapons>();

		ResultSet result = null;
		Connection conn = this.getConnection();
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("select * from customitems where ItemType = 'wep'");
			try {
				while(result.next()) {
					int id = result.getInt("id");
					String serverName = result.getString("item_code");
					int base = result.getInt("baseValue");
					int plusLimit = result.getInt("maxPlus");
					double perPlus = result.getDouble("perPlusIncrement");
					String name = result.getString("custom_name");
					
					try {
						weapons.put(Material.valueOf(serverName), new itemInfoForWeapons(Material.valueOf(serverName),id,base,plusLimit,perPlus,name));
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Kýlýc listeye eklendi. id: "+id);
					}
					catch(Exception e) {
						System.out.println("<Generator> Kýlýc yüklenemedi. id: "+id+" server name: "+serverName);					
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
		HashMap<Integer,Stages> weapons = new HashMap<Integer,Stages>();

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
						weapons.put(StageLevel, new Stages(StageName, CustomModel));
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
		
		
		return weapons;
	}

}
