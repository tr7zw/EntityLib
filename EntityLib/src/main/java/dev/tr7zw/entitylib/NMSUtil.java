package dev.tr7zw.entitylib;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.bukkit.World;
import org.bukkit.entity.EntityType;

import de.tr7zw.changeme.nbtapi.utils.MinecraftVersion;
import dev.tr7zw.entitylib.api.CCreature;
import dev.tr7zw.entitylib.api.EntityRegister;
import dev.tr7zw.entitylib.api.PathfinderGoal;
import dev.tr7zw.entitylib.api.PathfinderWrapper;
import dev.tr7zw.entitylib.nms.v1_16_R3.Creature1_12_R1;
import dev.tr7zw.entitylib.nms.v1_16_R3.EntityRegister1_12_R1;
import dev.tr7zw.entitylib.nms.v1_16_R3.Pathfinder1_12_R1;

public class NMSUtil {

    private static HashMap<Class<?>, Class<?>> nmsClasses = new HashMap<>();

    static {
        //1.12.2
        if(MinecraftVersion.getVersion() == MinecraftVersion.MC1_12_R1){
            registerClass(MinecraftVersion.MC1_12_R1, CCreature.class, Creature1_12_R1.class);
            registerClass(MinecraftVersion.MC1_12_R1, PathfinderWrapper.class, Pathfinder1_12_R1.class);
            registerClass(MinecraftVersion.MC1_12_R1, EntityRegister.class, EntityRegister1_12_R1.class);
        }
    }

    protected static void registerCustomEntity(){
        if(MinecraftVersion.getVersion() == MinecraftVersion.MC1_12_R1){
            NMSUtil.getHandler(EntityRegister.class).register(EntityType.VILLAGER, "custommob", Creature1_12_R1.class, "CustomMob");
        }
    }

    public static <T> T registerClass(MinecraftVersion version, Class<T> base, Class<? extends T> handler) {
        if (MinecraftVersion.getVersion().equals(version)) {
            //T inst = handler.newInstance();
            nmsClasses.put(base, handler);
            return null;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
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
