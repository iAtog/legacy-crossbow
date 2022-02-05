package me.iatog.crossbow.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.iatog.crossbow.nms.CraftNMS;
import me.iatog.crossbow.nms.v1_12_2.CraftNMSv1_12_2;
import me.iatog.crossbow.plugin.enums.BukkitVersion;
import me.iatog.crossbow.plugin.loader.CoreLoader;
import me.iatog.crossbow.plugin.loader.Loader;

public class LegacyCrossbowPlugin extends JavaPlugin {

	private final Loader coreLoader = new CoreLoader(this);
	private CraftNMS craftNMS;
	
	@Override
	public void onEnable() {
		this.coreLoader.onLoad();
	}

	@Override
	public void onDisable() {
		this.coreLoader.onUnload();
	}
	
	public CraftNMS getNMSIntegration() {
		return craftNMS;
	}
	
	public CraftNMS setNMSIntegration(BukkitVersion version) {
		switch(version.getSubVersion()) {
		case 12:
			craftNMS = new CraftNMSv1_12_2();
			break;
		}
		
		return craftNMS;
	}
}
