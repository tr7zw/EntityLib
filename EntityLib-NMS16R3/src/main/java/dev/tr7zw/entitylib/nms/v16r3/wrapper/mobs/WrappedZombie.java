package dev.tr7zw.entitylib.nms.v16r3.wrapper.mobs;

import org.bukkit.craftbukkit.v1_16_R3.entity.CraftZombie;
import org.bukkit.entity.Zombie;

import dev.tr7zw.entitylib.nms.v16r3.interfaces.NMSZombie;
import net.minecraft.server.v1_16_R3.EntityZombie;

public class WrappedZombie implements NMSZombie{

	private Zombie bukkitEntity;
	private EntityZombie nmsEntity;
	
	public WrappedZombie(Zombie entity) {
		this.bukkitEntity = entity;
		this.nmsEntity = ((CraftZombie)entity).getHandle();
	}
	
	@Override
	public Zombie getBukkitHandle() {
		return bukkitEntity;
	}

	@Override
	public EntityZombie getNMSEntity() {
		return nmsEntity;
	}

}
