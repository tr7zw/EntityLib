package dev.tr7zw.entitylib.nms.v16r3.interfaces;

import org.bukkit.util.BoundingBox;

import dev.tr7zw.entitylib.api.CustomEntity;
import net.minecraft.server.v1_16_R3.AxisAlignedBB;
import net.minecraft.server.v1_16_R3.Entity;
import net.minecraft.server.v1_16_R3.World;

public interface NMSEntity extends CustomEntity{

	public Entity getNMSEntity();
	
	public default World getNMSWorld() {
		return getNMSEntity().world;
	}

	public default double getX() {
		return getNMSEntity().locX();
	}
	
	public default double getY() {
		return getNMSEntity().locY();
	}
	
	public default double getZ() {
		return getNMSEntity().locZ();
	}
	
	public default float getYaw() {
		return getNMSEntity().yaw;
	}
	
	public default float getPitch() {
		return getNMSEntity().pitch;
	}
	
	public default BoundingBox getBoundingBox() {
		AxisAlignedBB box = getNMSEntity().getBoundingBox();
		return new BoundingBox(box.maxX, box.maxY, box.maxZ, box.minX, box.minY, box.minZ);
	}
	
	public default void setBoundingBox(BoundingBox boundingBox) {
		getNMSEntity().a(new AxisAlignedBB(boundingBox.getMinX(), boundingBox.getMinY(), boundingBox.getMinZ(), boundingBox.getMaxX(), boundingBox.getMaxY(), boundingBox.getMaxZ()));
	}
	
}
