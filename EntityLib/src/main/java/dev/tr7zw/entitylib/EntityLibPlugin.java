package dev.tr7zw.entitylib;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.tr7zw.entitylib.api.EntityLib;
import dev.tr7zw.entitylib.test.InteractListener;

public class EntityLibPlugin extends JavaPlugin{

    public static EntityLibPlugin instance;

    public static final HashMap<String, Integer> mapping = new HashMap<>();

    @Override
    public void onLoad(){
        //NMSUtil.registerCustomEntity();
    }

    @Override
    public void onEnable(){
        instance = this;
        EntityLib.setEntityWrapper(new dev.tr7zw.entitylib.nms.v16r3.NMSEntityWrapper());
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        //Bukkit.getPluginManager().registerEvents(new EnitityListener(), this);
        //Bukkit.getPluginManager().registerEvents(new TestListener(), this);
    }

    /*public static void spawn(CustomEntity entity, Location location) {
       entity.getHandler().setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        entity.getHandler().addtoWorld(location.getWorld());
    }*/

}
