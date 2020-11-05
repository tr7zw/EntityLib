package dev.tr7zw.entitylib.test;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import dev.tr7zw.entitylib.api.EntityLib;
import dev.tr7zw.entitylib.api.mobs.CustomZombie;

public class InteractListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEntityEvent event) {
		if(event.getRightClicked().getType() == EntityType.ZOMBIE) {
			CustomZombie zombie = EntityLib.getEntityWrapper().wrapZombie((Zombie) event.getRightClicked());
			zombie.swingMainHand();
		}
	}
	
}
