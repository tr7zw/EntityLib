package de.tr7zw.entlib.nms.inter;

public abstract class Navigation {

    public Navigation(Object obj) {
    }
    
    
    public abstract boolean trywalkto(double x, double y, double z, double speed);
    
    public abstract boolean hasPath();
    
    public abstract void setSpeed(double speed);
    
    public abstract void updatePath();

    
}
