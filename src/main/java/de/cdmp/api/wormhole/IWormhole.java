package de.cdmp.api.wormhole;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public interface IWormhole {

	/**
	 * Gets a list of all available adjacent blocks.
	 *
	 * @param fromDirection
	 *           The direction the request is coming from
	 * @return
	 */
	public List<WormholeTarget<Block, TileEntity>> getAllTargets(ForgeDirection fromDirection);
}
