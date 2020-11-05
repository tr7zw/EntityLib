package dev.tr7zw.entitylib.api;

import org.bukkit.entity.Entity;
import org.bukkit.util.BoundingBox;

public interface CustomEntity {

	/**
	 * @return
	 */
	public Entity getBukkitHandle();
	
	/**
	 * Returns the entity x position without going through the Bukkit API and
	 * creating a Location instance there.
	 * 
	 * @return
	 */
	public double getX();

	/**
	 * Returns the entity y position without going through the Bukkit API and
	 * creating a Location instance there.
	 * 
	 * @return
	 */
	public double getY();

	/**
	 * Returns the entity z position without going through the Bukkit API and
	 * creating a Location instance there.
	 * 
	 * @return
	 */
	public double getZ();

	/**
	 * Returns the entity yaw without going through the Bukkit API and
	 * creating a Location instance there.
	 * 
	 * @return
	 */
	public float getYaw();
	
	/**
	 * Returns the entity pitch without going through the Bukkit API and
	 * creating a Location instance there.
	 * 
	 * @return
	 */
	public float getPitch();
	
	/**
	 * Returns the BoundingBox of the Entity
	 * 
	 * @return
	 */
	public BoundingBox getEntityBoundingBox();
	
	
	/**
	 * Replace the entities BoundingBox
	 * 
	 * @param boundingBox
	 */
	public void setEntityBoundingBox(BoundingBox boundingBox);
	
}
