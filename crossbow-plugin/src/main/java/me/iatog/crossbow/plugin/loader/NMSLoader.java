package me.iatog.crossbow.plugin.loader;

import org.bukkit.Bukkit;

import me.iatog.crossbow.plugin.LegacyCrossbowPlugin;
import me.iatog.crossbow.plugin.enums.BukkitVersion;

public class NMSLoader implements Loader {
	
	private LegacyCrossbowPlugin main;
	
	public NMSLoader(LegacyCrossbowPlugin main) {
		this.main = main;
	}
	
	@Override
	public void onLoad() {
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		int subVersion = Integer.parseInt(version.replace("1_", "").replaceAll("_R\\d", ""));
		BukkitVersion ver = BukkitVersion.getVersion(subVersion);
		main.setNMSIntegration(ver);
	}
}
