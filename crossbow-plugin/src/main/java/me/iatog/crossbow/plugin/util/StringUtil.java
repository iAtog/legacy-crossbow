package me.iatog.crossbow.plugin.util;

import org.bukkit.ChatColor;

public class StringUtil {
	
	public static String colorize(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
}
