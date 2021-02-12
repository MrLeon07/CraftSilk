package mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Zombie;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.EntityMonster;
import net.minecraft.server.v1_16_R3.EntityZombie;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;

public class bossZombie extends EntityZombie {

	@SuppressWarnings("deprecation")
	public bossZombie(org.bukkit.World world) {
		super(((CraftWorld)world).getHandle());
		Zombie craftZombie = (Zombie) this.getBukkitEntity();
		this.setBaby(true);
		craftZombie.setMaxHealth(100);
		this.setHealth(100);
		this.setCustomNameVisible(true);
		this.setAirTicks(120);
		this.setOnFire(0);
		craftZombie.setCustomName(ChatColor.AQUA+"MonsterKiller");
		this.targetSelector.a(0,new PathfinderGoalNearestAttackableTarget<EntityMonster>(this, EntityMonster.class, true));
		
	}
	
	public void spawn(Location location) {
		this.getWorld().addEntity(this);
		this.setLocation(location.getX(),location.getY(), location.getZ(),location.getPitch(),location.getYaw());
		
	}

	

	

}
