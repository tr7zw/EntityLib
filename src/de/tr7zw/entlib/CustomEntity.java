package de.tr7zw.entlib;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import de.tr7zw.entlib.nms.inter.CCreature;
import de.tr7zw.entlib.nms.inter.PathfinderGoal;

public class CustomEntity {

    private final EntityType mobtype;
    private final CCreature handler;
    private final Creature creature;

    public CustomEntity(World world, EntityType mobtype) {
        this.mobtype = mobtype;
        handler = NMSUtil.getnewCreature(world, this);
        creature = handler.getCreature();
    }
    
    public CustomEntity(World world, EntityType mobtype, CCreature creature){
        this.mobtype = mobtype;
        handler = creature;
        this.creature = handler.getCreature();
    }

    public EntityType getMobType(){
        return mobtype;
    }

    public CCreature getHandler(){
        return handler;
    }

    public Creature bukkit(){
        return creature;
    }

    //AI

    public void addGoalSelector(int prio, PathfinderGoal goal){
        handler.addGoalSelector(prio, goal);
    }

    public void addTargetSelector(int priority, PathfinderGoal goal){
        handler.addTargetSelector(priority, goal);
    }

    public Entity getBukkitGoalTarget(){
        return handler.getBukkitGoalTarget();
    }

    public void jump(){
        handler.jump();
    }

    public boolean inWater(){
        return handler.inWater();
    }
    
    public Random getRandom(){
        return handler.getRandom();
    }

    /*
    //NMS Getter/Setter



    public boolean inLava(){
        return ab();
    }

    public void setGenericSpeed(double speed){
        if(this.getAttributeMap().a(GenericAttributes.MOVEMENT_SPEED.getName()) == null){
            this.getAttributeMap().b(GenericAttributes.MOVEMENT_SPEED);
        }
        this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(speed);
    }

    public void setGenericFollowRange(double range){
        if(this.getAttributeMap().a(GenericAttributes.FOLLOW_RANGE.getName()) == null){
            this.getAttributeMap().b(GenericAttributes.FOLLOW_RANGE);
        }
        this.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(range);
    }

    public void setGenericAttack(double dmg){
        if(this.getAttributeMap().a(GenericAttributes.ATTACK_DAMAGE.getName()) == null){
            this.getAttributeMap().b(GenericAttributes.ATTACK_DAMAGE);
        }
        this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(dmg);
    }

    public void setGenericKnockbackresistance(double resistance){
        if(this.getAttributeMap().a(GenericAttributes.c.getName()) == null){
            this.getAttributeMap().b(GenericAttributes.c);
        }
        this.getAttributeInstance(GenericAttributes.c).setValue(resistance);
    }

    public double getGenericSpeed(){
        if(this.getAttributeMap().a(GenericAttributes.MOVEMENT_SPEED.getName()) == null){
            this.getAttributeMap().b(GenericAttributes.MOVEMENT_SPEED);
        }
        return this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue();
    }

    public double getGenericFollowRange(){
        if(this.getAttributeMap().a(GenericAttributes.FOLLOW_RANGE.getName()) == null){
            this.getAttributeMap().b(GenericAttributes.FOLLOW_RANGE);
        }
        return this.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).getValue();
    }

    public double getGenericAttack(){
        if(this.getAttributeMap().a(GenericAttributes.ATTACK_DAMAGE.getName()) == null){
            this.getAttributeMap().b(GenericAttributes.ATTACK_DAMAGE);
        }
        return this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).getValue();
    }

    public double getGenericKnockbackresistance(){
        if(this.getAttributeMap().a(GenericAttributes.c.getName()) == null){
            this.getAttributeMap().b(GenericAttributes.c);
        }
        return this.getAttributeInstance(GenericAttributes.c).getValue();
    }

    public void setSpeed(float speed){
        this.k(speed);
    }

    public float getSpeed(){
        return this.bI();
    }

    public void setStepHight(float hight){
        this.S = hight;
    }

    public float getStepHight(){
        return this.S;
    }

    public Random getRandom(){
        return bc();
    }

    //Override to readable

    @Override  
    protected String z() { 
        return soundSay();  
    }    
    @Override   
    protected String bo() {   
        return soundHurt();  
    }    
    @Override   
    protected String bp() {  
        return soundDie();   
    }

    public String soundSay(){return null;} 
    public String soundHurt(){return "game.neutral.hurt";} 
    public String soundDie(){return "game.neutral.die";} 

    //Functions

    @SuppressWarnings("rawtypes")
    public void clearPathfinding() {
        List goalB = (List) ReflectionUtils.getPrivateField("b", PathfinderGoalSelector.class, this.goalSelector);
        goalB.clear();
        List goalC = (List) ReflectionUtils.getPrivateField("c", PathfinderGoalSelector.class, this.goalSelector);
        goalC.clear();
        List targetB = (List) ReflectionUtils.getPrivateField("b", PathfinderGoalSelector.class, this.targetSelector);
        targetB.clear();
        List targetC = (List) ReflectionUtils.getPrivateField("c", PathfinderGoalSelector.class, this.targetSelector);
        targetC.clear();
    }
     */
}
