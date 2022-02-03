package me.iatog.crossbow.nms;

import org.bukkit.inventory.ItemStack;

public interface CraftNMS {
	ItemStack setNBTString(ItemStack item, String key, String value);
	ItemStack setNBTBoolean(ItemStack item, String key, boolean value);
}
