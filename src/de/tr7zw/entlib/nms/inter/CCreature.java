package de.tr7zw.entlib.nms.inter;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import de.tr7zw.entlib.CustomEntity;

public interface CCreature {

    
    //Entity Handling
    public Object getHandle();
    
    public Creature getCreature();
    
    public void setLocation(double x, double y, double z, float pitch, float yaw);
    
    public void addtoWorld(World w);
    
    public EntityType getType();

    public CustomEntity getWrapper();
    
    //Goals, Targets
    public void addGoalSelector(int prio, PathfinderGoal goal);
    
    public void addTargetSelector(int priority, PathfinderGoal goal);
    
    public Entity getBukkitGoalTarget();
    
    public void addNMSGoalSelector(int prio, Object selector);
    
    public void addNMSTargetSelector(int prio, Object selector);
    
    public void addGoalRandomLookaround(int prio);
    
    public void addGoalRandomStroll(int prio, double speed);
    
    public void setsize(float with, float hight);
    
    //Controlling
    public void jump();
    
    public boolean inWater();
    
    
    //ETC
    public Random getRandom();
    
}
