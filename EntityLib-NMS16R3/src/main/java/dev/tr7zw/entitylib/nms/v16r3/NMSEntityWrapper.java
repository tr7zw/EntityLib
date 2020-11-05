package dev.tr7zw.entitylib.nms.v16r3;

import org.bukkit.entity.Zombie;

import dev.tr7zw.entitylib.api.EntityWrapper;
import dev.tr7zw.entitylib.api.mobs.CustomZombie;
import dev.tr7zw.entitylib.nms.v16r3.wrapper.mobs.WrappedZombie;

public class NMSEntityWrapper implements EntityWrapper{

	@Override
	public CustomZombie wrapZombie(Zombie zombie) {
		return new WrappedZombie(zombie);
	}

}
