package main;

import java.util.HashMap;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.AlchemyWindow;
import Commands.commandEx;
import Commands.itemCommand;
import Events.Events;
import GameSystem.entityRegistry;
import database.DBconnector;
import items.CustomArmor;
import items.CustomSword;
import mobs.bossZombie;
import net.minecraft.server.v1_16_R3.*;
import settings.Stages;


public class Main extends JavaPlugin{
	private static String DbUrl = "jdbc:mysql://185.26.147.184:3306/test";
	private static String DbUserName = "root";
	private static String Dbpassword = "cd1opBASx2zq6";
	public static HashMap<Integer,CustomSword> swords;// = new HashMap<Material,itemInfoForArmors>();
	public static HashMap<Integer, CustomArmor> armors;
	public static HashMap<Integer,Stages> stages;// = new HashMap<Material, itemInfoForWeapons>();
	public static DBconnector DbConnection;
	public entityRegistry reg = new entityRegistry();
	@Override
	public void onEnable() {
		LoadSettings();
		System.out.println("CraftSilk Plugini aktif edildi");
		this.getCommand("cmonster").setExecutor(new commandEx());
		this.getCommand("item").setExecutor(new itemCommand());
		this.getCommand("simya").setExecutor(new AlchemyWindow());
		reg.registerEntity("Zombie", 54, EntityZombie.class, bossZombie.class);
		this.getServer().getPluginManager().registerEvents(new Events(), this);
		
			}
	@Override
	public void onDisable() {
		System.out.println("plugin kapatýldý :(");
		
		
		
	}
	public static void LoadSettings() {
		if(armors!=null) {
			armors.clear();
		}
		if(swords!=null) {
			swords.clear();
		}
		if(stages!=null) {
			stages.clear();
		}
		DbConnection = new DBconnector(DbUrl,DbUserName,Dbpassword);
		if(DbConnection.tryConnect()) {
		stages = DbConnection.getStages();
		armors = DbConnection.getArmors();
		swords = DbConnection.getSwords();
	
		System.out.println("<Database> Verileri alýmý tamamlandý.");}
		else {
			System.out.println("<Database> Database baðlantýsý saðlanamadý. Lütfen baðlantýyý kontrol edip plugini tekrar yükleyin!!!!");
			}
		
		
	}

}
