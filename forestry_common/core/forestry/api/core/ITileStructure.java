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
package forestry.api.core;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

public interface ITileStructure {

	/**
	 * @return String unique to the type of structure controlled by this structure logic. Should map to {@link IStructureLogic}
	 */
	String getTypeUID();

	/**
	 * Should map to {@link IStructureLogic}
	 */
	void validateStructure();

	/**
	 * Called when the structure resets.
	 */
	void onStructureReset();

	/**
	 * @return TileEntity that is the master in this structure, null if no structure exists.
	 */
	ITileStructure getCentralTE();

	/**
	 * Called to set the master TileEntity. Implementing TileEntity should keep track of the master's coordinates, not refer to the TE object itself.
	 * 
	 * @param tile
	 */
	void setCentralTE(TileEntity tile);

	/**
	 * @return IInventory representing the TE's inventory.
	 */
	IInventory getInventory();

	/**
	 * Only called on Forestry's own blocks.
	 */
	void makeMaster();

	/**
	 * @return true if this TE is the master in a structure, false otherwise.
	 */
	boolean isMaster();

	/**
	 * @return true if the TE is master or has a master.
	 */
	boolean isIntegratedIntoStructure();

}
