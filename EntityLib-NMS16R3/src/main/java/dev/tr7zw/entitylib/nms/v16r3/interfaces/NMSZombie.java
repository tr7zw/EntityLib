package dev.tr7zw.entitylib.nms.v16r3.interfaces;

import dev.tr7zw.entitylib.api.mobs.CustomZombie;
import net.minecraft.server.v1_16_R3.Entity;
import net.minecraft.server.v1_16_R3.EntityZombie;

public interface NMSZombie extends CustomZombie, NMSMonster{

	public EntityZombie getNMSEntity();
	
}
