package dev.tr7zw.entitylib.nms.v1_16_R3;

import dev.tr7zw.entitylib.api.PathfinderWrapper;
import net.minecraft.server.v1_12_R1.PathfinderGoal;

public class Pathfinder1_12_R1 extends PathfinderGoal implements PathfinderWrapper{

    private dev.tr7zw.entitylib.api.PathfinderGoal goal;
    
    public Pathfinder1_12_R1(dev.tr7zw.entitylib.api.PathfinderGoal goal) {
        this.goal = goal;
    }

    @Override     
    public boolean a() {
        return goal.shouldExecute();
    }     
    @Override     
    public boolean b() {
        return goal.continueExecuting();
    }     
    @Override     
    public boolean g() {
        return goal.isInterruptible();
    }     
    @Override
    public void c() { 
        goal.startExecuting();     
    }    
    @Override 
    public void d() {  
        goal.resetTask();  
    }  
    @Override  
    public void e() {   
        goal.updateTask();   
    }    
    

}
