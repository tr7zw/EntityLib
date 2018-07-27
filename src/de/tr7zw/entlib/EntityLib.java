package de.tr7zw.entlib;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import de.tr7zw.entlib.test.TestListener;

public class EntityLib extends JavaPlugin{

    public static EntityLib instance;

    public static final HashMap<String, Integer> mapping = new HashMap<>();

    @Override
    public void onLoad(){
        NMSUtil.registerCustomEntity();
    }

    @Override
    public void onEnable(){
        instance = this;
        Bukkit.getPluginManager().registerEvents(new EnitityListener(), this);
        Bukkit.getPluginManager().registerEvents(new TestListener(), this);
    }

    public static void spawn(CustomEntity entity, Location location) {
        entity.getHandler().setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        entity.getHandler().addtoWorld(location.getWorld());
    }

}
