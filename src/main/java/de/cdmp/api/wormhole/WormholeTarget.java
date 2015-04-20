package de.cdmp.api.wormhole;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class WormholeTarget<B extends Block, T extends TileEntity> {
	private final World blockWorld;
	private final int blockX, blockY, blockZ;
	private final B block;
	private final T tile;

	public WormholeTarget(final World blockWorld, final int blockX, final int blockY, final int blockZ, final B block, final T tile) {
		this.blockWorld = blockWorld;
		this.blockX = blockX;
		this.blockY = blockY;
		this.blockZ = blockZ;
		this.block = block;
		this.tile = tile;
	}

    public World getBlockWorld() {
        return blockWorld;
    }

    public int getBlockX() {
        return blockX;
    }

    public int getBlockY() {
        return blockY;
    }

    public int getBlockZ() {
        return blockZ;
    }

    public B getBlock() {
        return block;
    }

    public T getTile() {
        return tile;
    }
}
