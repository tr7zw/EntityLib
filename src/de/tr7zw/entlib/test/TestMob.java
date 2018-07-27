package de.tr7zw.entlib.test;

import org.bukkit.World;
import org.bukkit.entity.EntityType;

import de.tr7zw.entlib.CustomEntity;
import de.tr7zw.entlib.nms.inter.CCreature;

public class TestMob extends CustomEntity{

    public TestMob(World world) {
        super(world, EntityType.CREEPER);
        init();
    }

    public TestMob(World world, CCreature creature){
        super(world, EntityType.CREEPER, creature);
        init();
    }

    private void init(){
       getHandler().setPersistent(true);
        
        getHandler().addGoalFloat(0);
        getHandler().addGoalMeleeAttack(1, 1);
        getHandler().addGoalMoveIndoors(2);
        getHandler().addGoalRestrictOpenDoor(3);
        getHandler().addGoalOpenDoor(4);
        getHandler().addGoalMoveTowardsRestriction(5, 0.6);
        getHandler().addGoalMoveThroughVillage(7, 0.6);
        getHandler().addGoalRandomStroll(15, 0.4);
        getHandler().addGoalRandomLookaround(16);
       // getHandler().addNMSTargetSelector(1, new PathfinderGoalNearestAttackableTarget<EntityPlayer>((EntityCreature) getHandler(), EntityPlayer.class, true));
        
        //bukkit().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.25);
        
        //getHandler().addNMSGoalSelector(2, new PathfinderGoalPanic((EntityCreature) getHandler(), 1));
    }

}
