package dev.tr7zw.entitylib.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BoundingBox {
	public final float width;
	public final float height;
	public final boolean fixed;
}
