package dev.tr7zw.entitylib.nms.v16r3.interfaces;

import dev.tr7zw.entitylib.api.CustomLiving;
import net.minecraft.server.v1_16_R3.EntityLiving;
import net.minecraft.server.v1_16_R3.EnumHand;

public interface NMSLiving extends NMSEntity, CustomLiving {

	public EntityLiving getNMSEntity();

	@Override
	default void swingMainHand() {
		getNMSEntity().swingHand(EnumHand.MAIN_HAND);
	}

	@Override
	default void swingOffHand() {
		getNMSEntity().swingHand(EnumHand.OFF_HAND);
	}
	
}
