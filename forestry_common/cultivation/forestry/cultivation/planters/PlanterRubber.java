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
package forestry.cultivation.planters;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import forestry.api.core.ForestryAPI;
import forestry.core.config.ForestryBlock;
import forestry.core.gadgets.Machine;
import forestry.core.gadgets.MachineFactory;
import forestry.core.gadgets.TileMachine;
import forestry.core.network.GuiId;
import forestry.core.utils.StringUtil;
import forestry.core.utils.StructureBlueprint;
import forestry.core.utils.Vect;
import forestry.plugins.CropProviderRubber;
import forestry.plugins.PluginIC2;

public class PlanterRubber extends Planter {

	public static class Factory extends MachineFactory {
		@Override
		public Machine createMachine(TileEntity tile) {
			return new PlanterRubber((TileMachine) tile);
		}
	}

	public PlanterRubber(TileMachine tile) {
		super(tile);
		if (PluginIC2.instance.isAvailable()) {
			cropProviders.add(new CropProviderRubber());
		}

		validSoil = new ItemStack(ForestryBlock.soil, 1, 0);
		validGround = new ItemStack(ForestryBlock.soil, 1, 0);
		validWaste = new ItemStack(Block.sand);
		validDisposal = new ItemStack(Block.sand);

		site = StructureBlueprint.getBlueprint("defaultArboretum");
		siteOffset = new Vect(-7, 0, -7);
		soil = StructureBlueprint.getBlueprint("rubberSoil");
		soilOffset = new Vect(-6, 0, -6);
		plantation = StructureBlueprint.getBlueprint("rubberPlantation");
		plantationOffset = new Vect(-6, 1, -6);
	}

	@Override
	public String getName() {
		return StringUtil.localize("tile.planter.2");
	}

	@Override
	public void openGui(EntityPlayer player, IInventory tile) {
		player.openGui(ForestryAPI.instance, GuiId.PlantationGUI.ordinal(), player.worldObj, this.tile.xCoord, this.tile.yCoord, this.tile.zCoord);
	}

	public static final StructureBlueprint rubberSoil = new StructureBlueprint("rubberSoil", new Vect(13, 1, 13));
	public static final StructureBlueprint rubberPlantation = new StructureBlueprint("rubberPlantation", new Vect(13, 1, 13));

	static {
		int i = 0;

		i = ForestryBlock.soil.blockID;
		int[][] soil = new int[][] { new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 3
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 4
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 5
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 6
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 7
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 8
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 9
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 10
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 11
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		rubberSoil.setPlane(0, soil);

		i = Block.sapling.blockID;
		int[][] plantation = new int[][] { new int[] { i, 0, i, 0, i, 0, i, 0, i, 0, i, 0, i }, // 1
				new int[] { 0, i, 0, i, 0, i, 0, i, 0, i, 0, i, 0 }, // 2
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 3
				new int[] { 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0 }, // 4
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 5
				new int[] { 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0 }, // 6
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 7
				new int[] { 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0 }, // 8
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 9
				new int[] { 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0 }, // 10
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 11
				new int[] { 0, i, 0, i, 0, i, 0, i, 0, i, 0, i, 0 }, // 12
				new int[] { i, 0, i, 0, i, 0, i, 0, i, 0, i, 0, i } // 13
		};
		rubberPlantation.setPlane(0, plantation);
	}

	@Override
	public boolean doWork() {
		if (!PluginIC2.instance.isAvailable())
			return false;

		return super.doWork();
	}
}
