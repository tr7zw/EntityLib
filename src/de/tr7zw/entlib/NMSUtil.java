package de.tr7zw.entlib;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.bukkit.World;

import de.tr7zw.entlib.nms.inter.CCreature;
import de.tr7zw.entlib.nms.inter.EntityRegister;
import de.tr7zw.entlib.nms.inter.PathfinderGoal;
import de.tr7zw.entlib.nms.inter.PathfinderWrapper;
import de.tr7zw.entlib.nms.v1_12_R1.Creature1_12_R1;
import de.tr7zw.entlib.nms.v1_12_R1.EntityRegister1_12_R1;
import de.tr7zw.entlib.nms.v1_12_R1.Pathfinder1_12_R1;

public class NMSUtil {

    private static HashMap<Class<?>, Class<?>> nmsClasses = new HashMap<>();

    static {
        //1.8.3

        //1.11.2
        registerClass(MinecraftVersion.MC1_12_R1, CCreature.class, Creature1_12_R1.class);
        registerClass(MinecraftVersion.MC1_12_R1, PathfinderWrapper.class, Pathfinder1_12_R1.class);
        registerClass(MinecraftVersion.MC1_12_R1, EntityRegister.class, EntityRegister1_12_R1.class);
    }


    public static <T> T registerClass(MinecraftVersion version, Class<T> base, Class<? extends T> handler) {
        if (MinecraftVersion.getVersion().equals(version)) {
            //T inst = handler.newInstance();
            nmsClasses.put(base, handler);
            return null;
        }
        return null;
    }

    public static <T> T getHandler(Class<T> base) {
        try {
            return (T) nmsClasses.get(base).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Class<?> getClassHandler(Class<?> base){
        return nmsClasses.get(base);
    }
    
    public static CCreature getnewCreature(World w, CustomEntity wrap){
        try {
            return (CCreature) getClassHandler(CCreature.class).getConstructor(World.class, CustomEntity.class).newInstance(w, wrap);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Object getPathfinder(PathfinderGoal goal){
        try {
            return getClassHandler(PathfinderWrapper.class).getConstructor(PathfinderGoal.class).newInstance(goal);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

}
