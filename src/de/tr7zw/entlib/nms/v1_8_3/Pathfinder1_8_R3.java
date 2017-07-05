package de.tr7zw.entlib.nms.v1_8_3;

import de.tr7zw.entlib.nms.inter.PathfinderWrapper;
import net.minecraft.server.v1_8_R3.PathfinderGoal;

public class Pathfinder1_8_R3 extends PathfinderGoal implements PathfinderWrapper{

    private de.tr7zw.entlib.nms.inter.PathfinderGoal goal;
    
    public Pathfinder1_8_R3(de.tr7zw.entlib.nms.inter.PathfinderGoal goal) {
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
    public boolean i() {
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
