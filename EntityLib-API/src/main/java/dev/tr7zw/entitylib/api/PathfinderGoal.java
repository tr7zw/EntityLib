package dev.tr7zw.entitylib.api;

public abstract class PathfinderGoal {

    public abstract boolean shouldExecute(); 
   
    public boolean continueExecuting() {   
        return shouldExecute();   
    }   
    public boolean isInterruptible() {   
        return true;  
    }   
    public void startExecuting() {  

    }  
    public void resetTask() {  

    }  
    public void updateTask() {   

    }
    
}
