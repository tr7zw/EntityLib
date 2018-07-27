package de.tr7zw.entlib.nms.v1_11_R1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_11_R1.CraftServer;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftCreature;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;

import de.tr7zw.entlib.CustomEntity;
import de.tr7zw.entlib.EntityLib;
import de.tr7zw.entlib.NMSUtil;
import de.tr7zw.entlib.nms.inter.CCreature;
import de.tr7zw.entlib.nms.inter.Navigation;
import de.tr7zw.entlib.nms.inter.PathfinderGoal;
import net.minecraft.server.v1_11_R1.EntityCreature;
import net.minecraft.server.v1_11_R1.IMonster;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_11_R1.PathfinderGoalBreakDoor;
import net.minecraft.server.v1_11_R1.PathfinderGoalEatTile;
import net.minecraft.server.v1_11_R1.PathfinderGoalFleeSun;
import net.minecraft.server.v1_11_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_11_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_11_R1.PathfinderGoalMoveIndoors;
import net.minecraft.server.v1_11_R1.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_11_R1.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_11_R1.PathfinderGoalOpenDoor;
import net.minecraft.server.v1_11_R1.PathfinderGoalPanic;
import net.minecraft.server.v1_11_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_11_R1.PathfinderGoalRandomStrollLand;
import net.minecraft.server.v1_11_R1.PathfinderGoalRestrictOpenDoor;
import net.minecraft.server.v1_11_R1.PathfinderGoalRestrictSun;
import net.minecraft.server.v1_11_R1.World;

public class Creature1_11_R1 extends EntityCreature implements CCreature, IMonster{

    private CustomEntity wrap;

    @SuppressWarnings("deprecation")
    public Creature1_11_R1(org.bukkit.World world, CustomEntity wrap) {
        this(((CraftWorld)world).getHandle());
        this.wrap = wrap;
        EntityLib.mapping.put(world.getName() + "_" + this.getId(), (int) wrap.getMobType().getTypeId());
    }

    @SuppressWarnings("deprecation")
    public Creature1_11_R1(World world) {
        super(world);
        EntityLib.mapping.put(world.getWorld().getName() + "_" + this.getId(), (int) EntityType.WITCH.getTypeId());
    }

    @Override
    public Object getHandle() {
        return this;
    }

    @Override
    public Creature getCreature() {
        return new CraftCreature(((CraftServer)Bukkit.getServer()), this);
    }

    @Override
    public void setLocation(double x, double y, double z, float yaw, float pitch) {
        super.setLocation(x, y, z, yaw, pitch);
    }

    @Override
    public void addtoWorld(org.bukkit.World w) {
        ((CraftWorld) w).getHandle().addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public EntityType getType() {
        return wrap.getMobType();
    }

    @Override
    public CustomEntity getWrapper() {
        return wrap;
    }

    @Override
    public void addGoalSelector(int priority, PathfinderGoal goal) {
        goalSelector.a(priority, (net.minecraft.server.v1_11_R1.PathfinderGoal) NMSUtil.getPathfinder(goal));
    }

    @Override
    public void addTargetSelector(int priority, PathfinderGoal goal) {
        targetSelector.a(priority, (net.minecraft.server.v1_11_R1.PathfinderGoal) NMSUtil.getPathfinder(goal));
    }

    @Override
    public Entity getBukkitGoalTarget() {
        if(getGoalTarget() == null)return null;
        return getGoalTarget().getBukkitEntity();
    }

    @Override
    public void jump() {
        super.getControllerJump().a();
    }

    @Override
    public boolean inWater() {
        return super.inWater;
    }

    @Override
    public Random getRandom(){
        return random;
    }

    @Override
    public void addGoalRandomLookaround(int prio) {
        goalSelector.a(prio, new PathfinderGoalRandomLookaround(this));
    }

    @Override
    public void addGoalRandomStroll(int prio, double speed) {
        goalSelector.a(prio, new PathfinderGoalRandomStrollLand(this, speed));
    }

    @Override
    public void setsize(float with, float hight) {
        super.setSize(width, hight);
    }

    @Override
    public void addNMSGoalSelector(int prio, Object selector) {
        if(selector != null && selector instanceof net.minecraft.server.v1_11_R1.PathfinderGoal){
            goalSelector.a(prio, (net.minecraft.server.v1_11_R1.PathfinderGoal) selector);
        }else{
            new ClassCastException("The NMS Pathfinder Goal was null or of a wrong class/nms version!").printStackTrace();
        }
    }

    @Override
    public void addNMSTargetSelector(int prio, Object selector) {
        if(selector != null && selector instanceof net.minecraft.server.v1_11_R1.PathfinderGoal){
            targetSelector.a(prio, (net.minecraft.server.v1_11_R1.PathfinderGoal) selector);
        }else{
            new ClassCastException("The NMS Pathfinder Goal was null or of a wrong class/nms version!").printStackTrace();
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public void a(NBTTagCompound nbttagcompound) {
        // NBTSaving
        super.a(nbttagcompound);
        System.out.println("Loading");
        String s = nbttagcompound.getString("wrapper");
        try {
            if(s != null){
                Class<? extends CustomEntity> wc = (Class<? extends CustomEntity>) Class.forName(s);
                if(wc != null){
                    Constructor<? extends CustomEntity> c = null;
                    try{
                        c = wc.getConstructor(org.bukkit.World.class, CCreature.class);
                    }catch(Exception ex){}
                    if(c != null){
                        wrap = c.newInstance(world.getWorld(), this);
                        EntityLib.mapping.put(world.getWorld().getName() + "_" + this.getId(), (int) wrap.getMobType().getTypeId());
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
        if(wrap == null){
            die();
        }
    }

    @Override
    public void b(NBTTagCompound nbttagcompound) {
        // NBTLoading
        super.b(nbttagcompound);
        System.out.println("Saving");
        nbttagcompound.setString("wrapper", wrap.getClass().getName());
    }

    @Override
    public void setPersistent(boolean persistent) {
        super.persistent = (persistent);
    }

    @Override
    public void addGoalMoveThroughVillage(int prio, double speed) {
        goalSelector.a(prio, new PathfinderGoalMoveThroughVillage(this, speed, true));
    }

    @Override
    public void addGoalMeleeAttack(int prio, double dmg) {
        goalSelector.a(prio, new PathfinderGoalMeleeAttack(this, dmg, true));
    }

    @Override
    public void addGoalMoveIndoors(int prio) {
        goalSelector.a(prio, new PathfinderGoalMoveIndoors(this));
    }

    @Override
    public void addGoalPanic(int prio, double speed) {
        goalSelector.a(prio, new PathfinderGoalPanic(this, speed));
    }

    @Override
    public void addGoalRestrictSun(int prio) {
        goalSelector.a(prio, new PathfinderGoalRestrictSun(this));
    }

    @Override
    public void addGoalRestrictOpenDoor(int prio) {
        goalSelector.a(prio, new PathfinderGoalRestrictOpenDoor(this));
    }

    @Override
    public void addGoalFleeSun(int prio, double speed) {
        goalSelector.a(prio, new PathfinderGoalFleeSun(this, speed));
    }

    @Override
    public void addGoalBreakDoor(int prio) {
        goalSelector.a(prio, new PathfinderGoalBreakDoor(this));
    }

    @Override
    public void addGoalEatTile(int prio) {
        goalSelector.a(prio, new PathfinderGoalEatTile(this));
    }

    @Override
    public void addGoalFloat(int prio) {
        goalSelector.a(prio, new PathfinderGoalFloat(this));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void addGoalAvoidTarget(int prio, EntityType type, float dist, double speed) {
        goalSelector.a(prio, new PathfinderGoalAvoidTarget(this, type.getEntityClass(), dist, speed, speed));
    }

    @Override
    public void addGoalOpenDoor(int prio) {
        goalSelector.a(prio, new PathfinderGoalOpenDoor(this, true));
    }

    @Override
    public void addGoalMoveTowardsRestriction(int prio, double speed) {
        goalSelector.a(prio, new PathfinderGoalMoveTowardsRestriction(this, speed));
    }

    @Override
    public Navigation getNavigator() {
        return new Navigation1_11_R1(getNavigation());
    }

}
