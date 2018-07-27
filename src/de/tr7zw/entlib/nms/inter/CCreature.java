package de.tr7zw.entlib.nms.inter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import org.bukkit.World;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import de.tr7zw.entlib.CustomEntity;
import de.tr7zw.entlib.EntityLib;
import de.tr7zw.itemnbtapi.NBTCompound;

public interface CCreature {

    
    //Entity Handling
    public Object getHandle();
    
    public Creature getCreature();
    
    public void setLocation(double x, double y, double z, float yaw, float pitch);
    
    public void addtoWorld(World w);
    
    public EntityType getType();

    public CustomEntity getWrapper();
    
    public Navigation getNavigator();
    
    //Goals, Targets
    public void addGoalSelector(int prio, PathfinderGoal goal);
    
    public void addTargetSelector(int priority, PathfinderGoal goal);
    
    public Entity getBukkitGoalTarget();
    
    public void addNMSGoalSelector(int prio, Object selector);
    
    public void addNMSTargetSelector(int prio, Object selector);
    
    public void addGoalRandomLookaround(int prio);
    
    public void addGoalMoveThroughVillage(int prio, double speed);
    
    public void addGoalMeleeAttack(int prio, double dmg);
    
    public void addGoalMoveIndoors(int prio);
    
    public void addGoalPanic(int prio, double speed);
    
    public void addGoalRestrictSun(int prio);
    
    public void addGoalRestrictOpenDoor(int prio);
    
    public void addGoalOpenDoor(int prio);
    
    public void addGoalFleeSun(int prio, double speed);
    
    public void addGoalBreakDoor(int prio);
    
    public void addGoalEatTile(int prio);
    
    public void addGoalFloat(int prio);
    
    public void addGoalAvoidTarget(int prio, EntityType type, float dist, double speed);
    
    public void addGoalMoveTowardsRestriction(int prio, double speed);
       /*
     *  
        new PathfinderGoalFollowEntity(arg0, arg1, arg2, arg3)
        new PathfinderGoalHurtByTarget(entitycreature, flag, aclass)
        new PathfinderGoalLeapAtTarget(arg0, arg1)
        new PathfinderGoalLookAtPlayer(arg0, arg1, arg2, arg3)
        new PathfinderGoalMoveTowardsRestriction(arg0, arg1)
        new PathfinderGoalMoveTowardsTarget(arg0, arg1, arg2)
        new PathfinderGoalTargetNearestPlayer(entityinsentient)
     */
    
    public void addGoalRandomStroll(int prio, double speed);
    
    public void setsize(float with, float hight);
    
    //Controlling
    public void jump();
    
    public boolean inWater();
    
    public void setPersistent(boolean persistent);
    
    //ETC
    public Random getRandom();
    
}
