package me.iatog.crossbow.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.iatog.crossbow.plugin.loader.CoreLoader;
import me.iatog.crossbow.plugin.loader.Loader;

public class LegacyCrossbowPlugin extends JavaPlugin {

	private final Loader coreLoader = new CoreLoader(this);

	@Override
	public void onEnable() {
		this.coreLoader.onLoad();
	}

	@Override
	public void onDisable() {
		this.coreLoader.onUnload();
	}

}
