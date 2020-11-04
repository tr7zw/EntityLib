package dev.tr7zw.entitylib.api;

import org.bukkit.entity.EntityType;

public abstract class EntityRegister {

    public abstract void register(EntityType type, String internalname, Class<?> clazz, String displayname);
    
}
