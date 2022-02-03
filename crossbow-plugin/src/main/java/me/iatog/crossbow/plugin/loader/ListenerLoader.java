package me.iatog.crossbow.plugin.loader;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.iatog.crossbow.plugin.listener.CrossbowListener;

public class ListenerLoader implements Loader {
	
	private JavaPlugin javaPlugin;
	
	public ListenerLoader(JavaPlugin javaPlugin) {
		this.javaPlugin = javaPlugin;
	}
	
	@Override
	public void onLoad() {
		registerListener(new CrossbowListener());
	}
	
	private final void registerListener(Listener...listeners) {
		PluginManager pluginManager = Bukkit.getPluginManager();
		
		for(Listener listener : listeners) {
			pluginManager.registerEvents(listener, javaPlugin);
		}
	}

}
