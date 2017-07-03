package de.tr7zw.entlib.nms.v1_12_R1;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftCreature;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;

import de.tr7zw.entlib.EntityLib;
import de.tr7zw.entlib.NMSUtil;
import de.tr7zw.entlib.CustomEntity;
import de.tr7zw.entlib.nms.inter.CCreature;
import de.tr7zw.entlib.nms.inter.PathfinderGoal;
import net.minecraft.server.v1_12_R1.EntityCreature;
import net.minecraft.server.v1_12_R1.IMonster;
import net.minecraft.server.v1_12_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_12_R1.PathfinderGoalRandomStrollLand;
import net.minecraft.server.v1_12_R1.World;

public class Creature1_12_R1 extends EntityCreature implements CCreature, IMonster{

    private CustomEntity wrap;

    @SuppressWarnings("deprecation")
    public Creature1_12_R1(org.bukkit.World world, CustomEntity wrap) {
        this(((CraftWorld)world).getHandle());
        this.wrap = wrap;
        EntityLib.mapping.put(world.getName() + "_" + this.getId(), (int) wrap.getMobType().getTypeId());
    }

    @SuppressWarnings("deprecation")
    public Creature1_12_R1(World world) {
        super(world);
        EntityLib.mapping.put(world.getWorld().getName() + "_" + this.getId(), (int) EntityType.VILLAGER.getTypeId());
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
    public void setLocation(double x, double y, double z, float pitch, float yaw) {
        super.setLocation(x, y, z, pitch, yaw);
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
        goalSelector.a(priority, (net.minecraft.server.v1_12_R1.PathfinderGoal) NMSUtil.getPathfinder(goal));
    }

    @Override
    public void addTargetSelector(int priority, PathfinderGoal goal) {
        targetSelector.a(priority, (net.minecraft.server.v1_12_R1.PathfinderGoal) NMSUtil.getPathfinder(goal));
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

}
