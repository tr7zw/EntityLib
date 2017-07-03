package de.tr7zw.entlib.test;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.tr7zw.entlib.EntityLib;

public class TestListener implements Listener{
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if(event.getMessage().equalsIgnoreCase("spawn")){
            Bukkit.getScheduler().runTask(EntityLib.instance, new Runnable() {
                @Override
                public void run() {
                    TestMob tm = new TestMob(event.getPlayer().getWorld());
                    EntityLib.spawn(tm, event.getPlayer().getLocation());
                }
            });
        }
        if(event.getMessage().equalsIgnoreCase("test")){
            Bukkit.getScheduler().runTask(EntityLib.instance, new Runnable() {
                @Override
                public void run() {
                    SecondMob tm = new SecondMob(event.getPlayer().getWorld());
                    EntityLib.spawn(tm, event.getPlayer().getLocation());
                }
            });
        }
    }
    
}
