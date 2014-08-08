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
package forestry.mail;

import net.minecraft.item.ItemStack;

public class TradeStationInfo {
	public final String moniker;
	public final ItemStack tradegood;
	public final ItemStack[] required;
	public final EnumStationState state;

	public TradeStationInfo(String moniker, ItemStack tradegood, ItemStack[] required, EnumStationState state) {
		this.moniker = moniker;
		this.tradegood = tradegood;
		this.required = required;
		this.state = state;
	}
}
