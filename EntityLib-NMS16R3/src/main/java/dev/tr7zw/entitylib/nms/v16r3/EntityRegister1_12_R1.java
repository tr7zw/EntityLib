/*package dev.tr7zw.entitylib.nms.v16r3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.entity.EntityType;

import dev.tr7zw.entitylib.api.EntityRegister;
import net.minecraft.server.v1_12_R1.EntityTypes;

public class EntityRegister1_12_R1 extends EntityRegister{

    @SuppressWarnings("deprecation")
    public void register(EntityType type, String internalname, Class<?> clazz, String displayname){
        try {
            Method method = null;
            for(Method m : EntityTypes.class.getDeclaredMethods()){
                if(m.getName().equals("a") && m.getParameterTypes().length == 4){
                    if(m.getParameterTypes()[0].equals(int.class) && m.getParameterTypes()[1].equals(String.class))
                        method = m;
                }
            }
            method.setAccessible(true);
            method.invoke(null, type.getTypeId(), internalname, clazz, displayname);

        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
}
*/