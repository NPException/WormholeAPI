package de.cdmp.api.wormhole;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * <b>(!) <i>You should NOT keep a WormholeTarget longer than the current tick,
 * since it's information and referenced objects might be invalid or out of sync
 * in the next tick!</i></b><br>
 * A small piece of space that is adjacent to a wormhole. It will contain the
 * Block type that is occupying that space, and may contain the TileEntity that
 * is sitting there, if available.
 * 
 * @author Davenonymous, Jezza, NPException
 *
 */
public class WormholeTarget<B extends Block, T extends TileEntity> {
	private final IBlockAccess world;
	private final int x, y, z;
	private final ForgeDirection direction;

	private boolean blockLoaded;
	private B block;

	private boolean tileLoaded;
	private T tile;

	/**
	 * Creates a new WormholeTarget
	 * @param world the target world
	 * @param x
	 * @param y
	 * @param z
	 * @param direction the direction in which the target lies relative to the wormhole exit
	 */
	public WormholeTarget(final IBlockAccess world, final int x, final int y, final int z, ForgeDirection direction) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.direction = direction;
	}

	public IBlockAccess getWorld() {
		return world;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	/**
	 * The direction the wormhole "exit" points to. (wormhole exit -> target)
	 * @return
	 */
	public ForgeDirection getDirection() {
		return direction;
	}

	@SuppressWarnings("unchecked")
	public B getBlock() {
		if (!blockLoaded) {
			block = (B) world.getBlock(x, y, z);
			blockLoaded = true;
		}
		return block;
	}

	@SuppressWarnings("unchecked")
	public T getTile() {
		if (!tileLoaded) {
			tile = (T) world.getTileEntity(x, y, z);
			tileLoaded = true;
		}
		return tile;
	}
}
