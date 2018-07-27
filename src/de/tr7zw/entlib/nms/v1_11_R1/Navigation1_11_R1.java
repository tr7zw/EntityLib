package de.tr7zw.entlib.nms.v1_11_R1;

import de.tr7zw.entlib.nms.inter.Navigation;

public class Navigation1_11_R1 extends Navigation{

    private net.minecraft.server.v1_11_R1.Navigation navi;
    
    public Navigation1_11_R1(Object obj) {
        super(obj);
        if(obj instanceof net.minecraft.server.v1_11_R1.Navigation){
            navi = (net.minecraft.server.v1_11_R1.Navigation) obj;
        }else{
            System.err.println("Navigation Wrapper got a wrong Object!");
        }
    }
    
    public boolean trywalkto(double x, double y, double z, double speed){
        return navi.a(x, y, z, speed);
    }
    
    public boolean hasPath(){
        return navi.n();
    }
    
    public void setSpeed(double speed){
        navi.a(speed);
    }
    
    public void updatePath(){
        navi.k();
    }

}
