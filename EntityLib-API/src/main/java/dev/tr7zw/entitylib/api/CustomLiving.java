package dev.tr7zw.entitylib.api;

import org.bukkit.entity.LivingEntity;

public interface CustomLiving extends CustomEntity {

	public LivingEntity getBukkitHandle();

	public void swingMainHand();
	
	public void swingOffHand();
	
}
