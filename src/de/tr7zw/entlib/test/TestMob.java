package de.tr7zw.entlib.test;

import org.bukkit.World;
import org.bukkit.entity.EntityType;

import de.tr7zw.entlib.CustomEntity;

public class TestMob extends CustomEntity{

    public TestMob(World world) {
        super(world, EntityType.BLAZE);
        addGoalSelector(1, new PathfinderGoalFloat(this));
    }

}
