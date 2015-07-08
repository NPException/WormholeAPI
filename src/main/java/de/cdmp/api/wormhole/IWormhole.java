package de.cdmp.api.wormhole;

import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public interface IWormhole {

	/**
	 * Gets a list of all available adjacent blocks.<br>
	 * <br>
	 * <i>It is recomended for implemtations of this interface to keep a List and a view to that list
	 * (using {@link Collections#unmodifiableList(java.util.List)}) for each {@link ForgeDirection} internally.
	 * That way only the backing list needs to be modified and the unmodifiable view can be returned.
	 * This will prevent unnecessary GC overhead due to Object creation.</i><br>
	 * <br>
	 * <b>Attention: </b> Though this kind of implementation is recomended, it is not guaranteed.
	 * So you should never expect a List you got from calling this method to be the current representation of the wormholes targets.
	 * (Because the target list might only be updated due to a call to this method, for example.)
	 *
	 * @param fromDirection
	 *           The direction the request is coming from
	 * @return
	 */
	public List<WormholeTarget<Block, TileEntity>> getAllTargets(ForgeDirection fromDirection);
}
