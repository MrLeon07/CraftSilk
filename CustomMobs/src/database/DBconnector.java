package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class DBconnector {

	private String url;
	private String password;	
	private String username;
	
	public DBconnector(String url,String password,String username) {
		this.url = url;
		this.username = username;
		this.password = password;
		
	}
	private Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(this.url, this.username, this.password);
			Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Database sunucusuna baðlanýldý.");
			return conn;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED+" Sunucuyla baðlantý kurulamadý.");
			return null;
			
		}
		
	}
	public void tryConnect() {
		Connection conn = this.getConnection();
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public ResultSet getArmors() {
		Connection conn = this.getConnection();
		ResultSet result = null;
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("select * from customitems where ItemType = 'arm'");
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"<Database> "+ChatColor.DARK_PURPLE+"Zýrh verileri alýnamadý. Error message: "+e.getMessage());		}
		try {
			conn.close();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+"<Database> GetArmors conn.close: "+e.getMessage());
		}
		return result;
		}
	public ResultSet getSwords() {
		ResultSet result = null;
		Connection conn = this.getConnection();
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("select * from customitems where ItemType = 'wep'");
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"<Database> "+ChatColor.DARK_PURPLE+"Kýlýc verileri alýnamadý. Error message: "+e.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+"<Database> GetArmors conn.close: "+e.getMessage());
		}
		
		
		return result;
	}


}
