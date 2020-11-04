package dev.tr7zw.entitylib.nms.v16r3.interfaces;

import dev.tr7zw.entitylib.api.CustomCreature;
import net.minecraft.server.v1_16_R3.EntityCreature;

public interface NMSCreature extends CustomCreature, NMSInsentient{

	public EntityCreature getNMSEntity();
	
}
