package me.iatog.crossbow.nms.v1_12_2;

import me.iatog.crossbow.nms.CraftNMS;

import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import net.minecraft.server.v1_12_R1.NBTTagCompound;

public class CraftNMSv1_12_2 implements CraftNMS {
	
	private NBTTagCompound getTag(net.minecraft.server.v1_12_R1.ItemStack craftItemStack) {
		return craftItemStack.getTag() == null ? new NBTTagCompound() : craftItemStack.getTag();
	}
	
	@Override
	public ItemStack setNBTString(ItemStack item, String key, String value) {
		net.minecraft.server.v1_12_R1.ItemStack craftItemStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = getTag(craftItemStack);
		
		tag.setString(key, value);
		craftItemStack.setTag(tag);
		return CraftItemStack.asBukkitCopy(craftItemStack);
	}

	@Override
	public ItemStack setNBTBoolean(ItemStack item, String key, boolean value) {
		net.minecraft.server.v1_12_R1.ItemStack craftItemStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = getTag(craftItemStack);
		
		tag.setBoolean(key, value);
		craftItemStack.setTag(tag);
		return CraftItemStack.asBukkitCopy(craftItemStack);
	}

	@Override
	public boolean hasKey(ItemStack item, String key) {
		net.minecraft.server.v1_12_R1.ItemStack craftItemStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = getTag(craftItemStack);
		
		return tag.hasKey(key);
	}

	@Override
	public String getString(ItemStack item, String key) {
		net.minecraft.server.v1_12_R1.ItemStack craftItemStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = getTag(craftItemStack);
		
		return tag.getString(key);
	}

	@Override
	public boolean getBoolean(ItemStack item, String key) {
		net.minecraft.server.v1_12_R1.ItemStack craftItemStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = getTag(craftItemStack);
		
		return tag.getBoolean(key);
	}
	
}
