package de.tr7zw.entlib.test;

import de.tr7zw.entlib.CustomEntity;
import de.tr7zw.entlib.nms.inter.PathfinderGoal;

public class PathfinderGoalFloat extends PathfinderGoal{

    CustomEntity ent;
    
    public PathfinderGoalFloat(CustomEntity entity) {
        ent = entity;
    }

    @Override
    public boolean shouldExecute() {
        return ent.inWater();
    }

    @Override
    public void updateTask() {
        if (ent.getRandom().nextFloat() < 0.8F) {
            ent.jump();
        }
    }


}
