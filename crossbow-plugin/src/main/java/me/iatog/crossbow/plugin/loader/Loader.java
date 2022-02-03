package me.iatog.crossbow.plugin.loader;

public interface Loader {
	void onLoad();
	default void onUnload() {};
}
