package de.cdmp.api.wormhole;

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
}
