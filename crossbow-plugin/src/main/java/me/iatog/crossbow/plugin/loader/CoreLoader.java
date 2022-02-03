package me.iatog.crossbow.plugin.loader;

import java.util.ArrayList;
import java.util.List;

import me.iatog.crossbow.plugin.LegacyCrossbowPlugin;

public class CoreLoader implements Loader {

	private LegacyCrossbowPlugin main;
	private List<Loader> loaders;

	public CoreLoader(LegacyCrossbowPlugin main) {
		this.main = main;
		this.loaders = new ArrayList<>();
	}

	@Override
	public void onLoad() {
		registerLoader(new ListenerLoader(main));

		main.getLogger().info("�aLegacy Crossbow was enabled: " + main.getDescription().getVersion());
	}

	@Override
	public void onUnload() {
		main.getLogger().info("I say hello to her and she says gusbai");
		loaders.forEach(loader -> loader.onUnload());
	}

	private void registerLoader(Loader... loaders) {
		for (Loader loader : loaders) {
			loader.onLoad();
			this.loaders.add(loader);
		}
	}

}
