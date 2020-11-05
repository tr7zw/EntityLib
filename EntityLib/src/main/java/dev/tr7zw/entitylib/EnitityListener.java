/*package dev.tr7zw.entitylib;

import org.bukkit.event.Listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class EnitityListener implements Listener{

    public EnitityListener(){
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(EntityLib.instance,
                ListenerPriority.NORMAL, 
                PacketType.Play.Server.SPAWN_ENTITY_LIVING) {
            @Override
            public void onPacketSending(PacketEvent event) {
                try{
                    PacketContainer packet = event.getPacket();
                    Integer entid = packet.getIntegers().read(0);
                    if(EntityLib.mapping.containsKey(event.getPlayer().getWorld().getName() + "_" + entid)){
                        packet.getIntegers().write(1, EntityLib.mapping.get(event.getPlayer().getWorld().getName() + "_" + entid));
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
    
}
*/