package de.tr7zw.entlib.test;

import org.bukkit.World;
import org.bukkit.entity.EntityType;

import de.tr7zw.entlib.CustomEntity;

public class SecondMob extends CustomEntity{

    public SecondMob(World world) {
        super(world, EntityType.CHICKEN);
        getHandler().addGoalRandomLookaround(0);
        getHandler().addGoalRandomStroll(1, 0.5);
        bukkit().setHealth(1);
    }

}
