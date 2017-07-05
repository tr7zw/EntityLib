package de.tr7zw.entlib.test;

import org.bukkit.World;
import org.bukkit.entity.EntityType;

import de.tr7zw.entlib.CustomEntity;
import net.minecraft.server.v1_8_R3.EntityCreature;
import net.minecraft.server.v1_8_R3.PathfinderGoalRestrictSun;

public class SecondMob extends CustomEntity{

    public SecondMob(World world) {
        super(world, EntityType.SQUID);
        getHandler().addGoalRandomLookaround(0);
        getHandler().addGoalRandomStroll(1, 0.5);
        getHandler().addNMSGoalSelector(2, new PathfinderGoalRestrictSun((EntityCreature) getHandler()));
        bukkit().setHealth(1);
        bukkit().setCustomName("TestMob");
        bukkit().setCustomNameVisible(true);
    }

}
