package dev.tr7zw.entitylib.nms.v16r3;

import dev.tr7zw.entitylib.api.Navigation;

public class Navigation1_12_R1 extends Navigation{

    private net.minecraft.server.v1_12_R1.Navigation navi;
    
    public Navigation1_12_R1(Object obj) {
        super(obj);
        if(obj instanceof net.minecraft.server.v1_12_R1.Navigation){
            navi = (net.minecraft.server.v1_12_R1.Navigation) obj;
        }else{
            System.err.println("Navigation Wrapper got a wrong Object!");
        }
    }
    
    public boolean trywalkto(double x, double y, double z, double speed){
        return navi.a(x, y, z, speed);
    }
    
    public boolean hasPath(){
        return navi.o();
    }
    
    public void setSpeed(double speed){
        navi.a(speed);
    }
    
    public void updatePath(){
        navi.k();
    }

}
