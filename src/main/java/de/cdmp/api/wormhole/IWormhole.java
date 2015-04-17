package de.cdmp.api.wormhole;

import java.util.List;

public interface IWormhole {

	/**
	 * Gets a list of adjacent blocks dependent on the given "filter" parameter.
	 *
	 * @param searchedBlockClass
	 *           The class of Blocks that are valid results.
	 *           The resulting list may only contain WormholeTargets that have a
	 *           Block of the given class.
	 * @param fromDirection
	 *           The direction the request is coming from
	 * @return
	 */
	public <B extends Block> List<WormholeTarget<B, ? extends TileEntity>> findTargetsWithBlockClass(Class<B> searchedBlockClass, ForgeDirection fromDirection);

	/**
	 * Gets a list of adjacent blocks dependent on the given "filter" parameter.
	 *
	 * @param searchedTileClass
	 *           The class of TileEntities that are valid results.
	 *           The resulting list may only contain WormholeTargets that have a
	 *           valid tile of the given class.
	 * @param fromDirection
	 *           The direction the request is coming from
	 * @return
	 */
	public <T extends TileEntity> List<WormholeTarget<? extends Block, T>> findTargetsWithTileClass(Class<T> searchedTileClass, ForgeDirection fromDirection);

	/**
	 * Gets a list of adjacent blocks dependent on the given "filter" parameters.
	 *
	 * @param searchedBlockClass
	 *           The class of Blocks that are valid results.
	 *           The resulting list may only contain WormholeTargets that have a
	 *           Block of the given class.
	 * @param searchedTileClass
	 *           The class of TileEntities that are valid results.
	 *           The resulting list may only contain WormholeTargets that have a
	 *           valid tile of the given class.
	 * @param fromDirection
	 *           The direction the request is coming from
	 * @return
	 */
	public <B extends Block, T extends TileEntity> List<WormholeTarget<B, T>> findTargets(Class<B> searchedBlockClass, Class<T> searchedTileClass, ForgeDirection fromDirection);

	/**
	 * Gets a list of all available adjacent blocks.
	 *
	 * @param fromDirection
	 *           The direction the request is coming from
	 * @return
	 */
	public List<WormholeTarget<Block, TileEntity>> getAllTargets(ForgeDirection fromDirection);
}
