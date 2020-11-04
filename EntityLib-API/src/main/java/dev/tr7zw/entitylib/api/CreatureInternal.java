package dev.tr7zw.entitylib.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.World;

import de.tr7zw.itemnbtapi.NBTCompound;
import dev.tr7zw.entitylib.CustomEntity;
import dev.tr7zw.entitylib.EntityLib;

public interface CreatureInternal {

    public void setWrapper(CustomEntity wrap);
    
    public CustomEntity getWrapper();
    
    public int getId();
    
    public void die();
    
    default void loadEntity(World world, NBTCompound compound){
        System.out.println("Loading");
        String s = compound.getString("wrapper");
        try {
            if(s != null){
                Class<? extends CustomEntity> wc = (Class<? extends CustomEntity>) Class.forName(s);
                if(wc != null){
                    Constructor<? extends CustomEntity> c = null;
                    try{
                        c = wc.getConstructor(org.bukkit.World.class, CCreature.class);
                    }catch(Exception ex){}
                    if(c != null){
                        setWrapper(c.newInstance(world, this));
                        EntityLib.mapping.put(world.getName() + "_" + this.getId(), (int) getWrapper().getMobType().getTypeId());
                    }else{
                        System.out.println("Tried loading an unknown custom entity of type '" + s + "', but the Class has no (World, CCreature) constructor! Removing.");
                    }
                }else{
                    System.out.println("Tried loading an unknown custom entity of type '" + s + "'! Removing.");
                }
            }else{
                System.out.println("Tried loading an unknown custom entity! Removing.");
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
            e.printStackTrace();
        }
        if(getWrapper() == null){
            die();
        }
    }
    
}
