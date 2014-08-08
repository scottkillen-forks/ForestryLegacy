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
package forestry.storage.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

import org.lwjgl.opengl.GL11;

import forestry.core.config.Defaults;

public class GuiBackpackT2 extends GuiContainer {

	public GuiBackpackT2(Container container) {
		super(container);

		xSize = 176;
		ySize = 192;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		int tex = this.mc.renderEngine.getTexture(Defaults.TEXTURE_PATH_GUI + "/backpackT2.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(tex);
		int startX = (this.width - this.xSize) / 2;
		int startY = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(startX, startY, 0, 0, this.xSize, this.ySize);
	}

}
