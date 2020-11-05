package dev.tr7zw.entitylib.api;

import org.bukkit.entity.Zombie;

import dev.tr7zw.entitylib.api.mobs.CustomZombie;

public interface EntityWrapper {

	public CustomZombie wrapZombie(Zombie zombie);
	
}
