package de.cdmp.api.wormhole;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class WormholeHelper {

	private WormholeHelper() {
		// no instance here. go away.
	}

	/**
	 * Gets a list of adjacent blocks dependent on the given "filter" parameter.
	 *
	 * @param wormhole
	 *           the wormhole that should be checked for adjacent targets
	 * @param blockFilter
	 *           The class of Blocks that are valid results. The resulting list
	 *           may only contain WormholeTargets that have a Block of the given
	 *           class.
	 * @param fromDirection
	 *           The direction the request is coming from
	 * @return
	 */
	public static <B extends Block> List<WormholeTarget<B, TileEntity>> filterByBlock(IWormhole wormhole, Class<B> blockFilter, ForgeDirection fromDirection) {
		return filter(wormhole, blockFilter, null, fromDirection);
	}

	/**
	 * Gets a list of adjacent blocks dependent on the given "filter" parameter.
	 *
	 * @param wormhole
	 *           the wormhole that should be checked for adjacent targets
	 * @param tileFilter
	 *           The class of TileEntities that are valid results. The resulting
	 *           list may only contain WormholeTargets that have a valid tile of
	 *           the given class.
	 * @param fromDirection
	 *           The direction the request is coming from
	 * @return
	 */
	public static <T extends TileEntity> List<WormholeTarget<Block, T>> filterByTile(IWormhole wormhole, Class<T> tileFilter, ForgeDirection fromDirection) {
		return filter(wormhole, null, tileFilter, fromDirection);
	}

	/**
	 * Gets a list of adjacent blocks dependent on the given "filter" parameters.
	 *
	 * @param wormhole
	 *           the wormhole that should be checked for adjacent targets
	 * @param searchedBlockClass
	 *           The class of Blocks that are valid results. The resulting list
	 *           may only contain WormholeTargets that have a Block of the given
	 *           class.
	 * @param tileFilter
	 *           The class of TileEntities that are valid results. The resulting
	 *           list may only contain WormholeTargets that have a valid tile of
	 *           the given class.
	 * @param fromDirection
	 *           The direction the request is coming from
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <B extends Block, T extends TileEntity> List<WormholeTarget<B, T>> filter(IWormhole wormhole, Class<B> blockFilter, Class<T> tileFilter, ForgeDirection fromDirection) {
		List<WormholeTarget<Block, TileEntity>> targets = wormhole.getAllTargets(fromDirection);
		List<WormholeTarget<B, T>> results = new ArrayList<>(targets.size());

		for (WormholeTarget<Block, TileEntity> target : targets) {
			if (blockFilter != null && (target.getBlock() == null || !blockFilter.isAssignableFrom(target.getBlock().getClass())))
				continue;

			if (tileFilter != null && (target.getTile() == null || !tileFilter.isAssignableFrom(target.getTile().getClass())))
				continue;

			results.add((WormholeTarget<B, T>) target);
		}

		return results;
	}
}
