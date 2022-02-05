package me.iatog.crossbow.api;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.iatog.crossbow.item.ItemStackBuilder;
import me.iatog.crossbow.nms.CraftNMS;

public class CrossbowAPI {
	
	private CraftNMS craftNMS;
	
	private CrossbowAPI(CraftNMS craftNMS) {
		this.craftNMS = craftNMS;
	}
	
	public static CrossbowAPI newCrossbowAPI(CraftNMS craftNMS) {
		return new CrossbowAPI(craftNMS);
	}
	
	public CraftNMS getNMSIntegration() {
		return craftNMS;
	}
	
	public ItemStack createCrossbow() {
		ItemStackBuilder builder = new ItemStackBuilder(Material.BOW);
		builder.setNBTBoolean(craftNMS, "atog-crossbow", true);
		builder.setNBTBoolean(craftNMS, "atog-crossbow-charged", false);
		builder.setName("Crossbow");
		
		return builder.build();
	}
	
	public boolean isCrossbow(ItemStack item) {
		return craftNMS.hasKey(item, "atog-crossbow");
	}
	
	public boolean isChargedCrossbow(ItemStack item) {
		return craftNMS.getBoolean(item, "atog-crossbow-charged");
	}
	
}
