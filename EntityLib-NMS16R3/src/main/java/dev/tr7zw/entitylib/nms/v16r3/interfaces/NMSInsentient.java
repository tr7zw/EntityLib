package dev.tr7zw.entitylib.nms.v16r3.interfaces;

import dev.tr7zw.entitylib.api.CustomInsentient;
import net.minecraft.server.v1_16_R3.EntityInsentient;

public interface NMSInsentient extends NMSLiving, CustomInsentient{

	public EntityInsentient getNMSEntity();
	
}
