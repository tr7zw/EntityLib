package de.tr7zw.entlib;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import de.tr7zw.entlib.nms.inter.EntityRegister;
import de.tr7zw.entlib.nms.v1_12_R1.Creature1_12_R1;
import de.tr7zw.entlib.test.TestListener;

public class EntityLib extends JavaPlugin{

    public static EntityLib instance;

    public static final HashMap<String, Integer> mapping = new HashMap<>();

    @Override
    public void onLoad(){
        NMSUtil.getHandler(EntityRegister.class).register(EntityType.VILLAGER, "custommob", Creature1_12_R1.class, "CustomMob");
    }

    @Override
    public void onEnable(){
        instance = this;
        Bukkit.getPluginManager().registerEvents(new EnitityListener(), this);
        Bukkit.getPluginManager().registerEvents(new TestListener(), this);
    }

    public static void spawn(CustomEntity entity, Location location) {
        entity.getHandler().setLocation(location.getX(), location.getY(), location.getZ(), location.getPitch(), location.getYaw());
        entity.getHandler().addtoWorld(location.getWorld());
    }

}