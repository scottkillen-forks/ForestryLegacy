/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * 
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 ******************************************************************************/
package forestry.arboriculture.gadgets;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockTreeContainer extends BlockContainer {

	public BlockTreeContainer(int id, Material material) {
		super(id, material);
		setTickRandomly(true);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {

		if (world.rand.nextFloat() > 0.1)
			return;

		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (!(tile instanceof TileTreeContainer))
			return;

		((TileTreeContainer) tile).onBlockTick();
	}

}
