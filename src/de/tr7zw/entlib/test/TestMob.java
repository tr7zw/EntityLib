package de.tr7zw.entlib.test;

import org.bukkit.World;
import org.bukkit.entity.EntityType;

import de.tr7zw.entlib.CustomEntity;
import net.minecraft.server.v1_8_R3.EntityCreature;
import net.minecraft.server.v1_8_R3.PathfinderGoalPanic;

public class TestMob extends CustomEntity{

    public TestMob(World world) {
        super(world, EntityType.BLAZE);
        addGoalSelector(1, new PathfinderGoalFloat(this));
        getHandler().addNMSGoalSelector(2, new PathfinderGoalPanic((EntityCreature) getHandler(), 1));
    }

}
