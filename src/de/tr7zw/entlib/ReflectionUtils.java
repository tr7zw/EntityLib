package de.tr7zw.entlib;

import org.bukkit.Bukkit;

import java.lang.reflect.Field;

public class ReflectionUtils {
    public static final String craftBukkitVersion;

    static {
        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        craftBukkitVersion = packageName.substring(packageName.lastIndexOf('.') + 1);
    }

    public static Class<?> getNMSClass(String className) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + craftBukkitVersion + "." + className);
    }

    public static Object getPrivateField(String fieldName, Class clazz, Object object) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setPrivateField(String fieldName, Class clazz, Object object, Object value) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
