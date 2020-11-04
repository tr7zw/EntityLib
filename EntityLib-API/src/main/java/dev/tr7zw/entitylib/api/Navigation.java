package dev.tr7zw.entitylib.api;

public abstract class Navigation {

    public Navigation(Object obj) {
    }
    
    
    public abstract boolean trywalkto(double x, double y, double z, double speed);
    
    public abstract boolean hasPath();
    
    public abstract void setSpeed(double speed);
    
    public abstract void updatePath();

    
}
