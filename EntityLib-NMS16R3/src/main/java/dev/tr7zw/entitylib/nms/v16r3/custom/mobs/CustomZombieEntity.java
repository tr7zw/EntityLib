package dev.tr7zw.entitylib.nms.v16r3.custom.mobs;

import org.bukkit.entity.Zombie;

import dev.tr7zw.entitylib.nms.v16r3.interfaces.NMSZombie;
import net.minecraft.server.v1_16_R3.EntityZombie;
import net.minecraft.server.v1_16_R3.World;

public class CustomZombieEntity extends EntityZombie implements NMSZombie{

	public CustomZombieEntity(World world) {
		super(world);
	}

	@Override
	public Zombie getBukkitHandle() {
		return (Zombie) getBukkitEntity();
	}

	@Override
	public EntityZombie getNMSEntity() {
		return this;
	}

}
