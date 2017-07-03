package de.tr7zw.entlib;

import org.bukkit.Bukkit;

public enum MinecraftVersion {
    Unknown(0), MC1_8_R3(183), MC1_12_R1(1121);

    MinecraftVersion(int id) {
        this.id = id;
    }

    private static MinecraftVersion version;
    private final int id;

    public int getId() {
        return id;
    }

    public static MinecraftVersion getVersion() {
        if (version != null) {
            return version;
        }
        final String ver = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        System.out.println("[EntityLib] Found Spigot: " + ver + "! Trying to find NMS support");
        try {
            version = MinecraftVersion.valueOf(ver.replace("v", "MC"));
        } catch (IllegalArgumentException ex) {
            version = MinecraftVersion.Unknown;
        }
        if(version != Unknown){
            System.out.println("[EntityLib] NMS support '" + version.name() + "' loaded!");
        }else{
            System.out.println("[EntityLib] Wasn't able to find NMS Support! Some functions will not work!");
        }
        return version;
    }
}
