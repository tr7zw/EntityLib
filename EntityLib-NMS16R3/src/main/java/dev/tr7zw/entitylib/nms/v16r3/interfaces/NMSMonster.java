package dev.tr7zw.entitylib.nms.v16r3.interfaces;

import dev.tr7zw.entitylib.api.CustomMonster;
import net.minecraft.server.v1_16_R3.EntityMonster;

public interface NMSMonster extends NMSCreature, CustomMonster{

	public EntityMonster getNMSEntity();
	
}
