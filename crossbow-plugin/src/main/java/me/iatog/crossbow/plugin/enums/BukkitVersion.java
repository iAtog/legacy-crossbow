package me.iatog.crossbow.plugin.enums;

public enum BukkitVersion {
	V1_8,
	V1_9,
	V1_10,
	V1_11,
	V1_12,
	V1_13;
	
	public int getSubVersion() {
		return Integer.parseInt(name().split("_")[1]);
	}
	
	public static BukkitVersion getVersion(int subVersion) {
		BukkitVersion ver = null;
		
		for(BukkitVersion version : values()) {
			if(subVersion == version.getSubVersion()) {
				ver = version;
				break;
			}
		}
		
		return ver;
	}
}
