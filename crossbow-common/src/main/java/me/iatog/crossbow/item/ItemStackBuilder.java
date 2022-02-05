package me.iatog.crossbow.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.iatog.crossbow.nms.CraftNMS;

public class ItemStackBuilder {
	private ItemStack item;
	private String name;
	private List<String> lore;
	private List<ItemFlag> flags;
	private Map<Enchantment, Integer> enchantments;

	public ItemStackBuilder(ItemStack item) {
		this.item = item;
		this.enchantments = new HashMap<>();
		this.lore = new ArrayList<>();
		this.flags = new ArrayList<>();
	}

	public ItemStackBuilder(Material mat, int amount, short data) {
		this(new ItemStack(mat, amount, data));
	}

	public ItemStackBuilder(Material mat, int amount) {
		this(mat, amount, (short) 0);
	}

	public ItemStackBuilder(Material mat) {
		this(mat, 1, (short) 0);
	}

	public ItemStackBuilder(Material mat, short data) {
		this(mat, 1, data);
	}

	public Material getMaterial() {
		return this.item.getType();
	}

	public int getAmount() {
		return this.item.getAmount();
	}

	public String getName() {
		return this.name;
	}

	public List<String> getLore() {
		return this.lore;
	}

	public List<ItemFlag> getItemFlags() {
		return this.flags;
	}

	public Map<Enchantment, Integer> getEnchants() {
		return this.enchantments;
	}

	public ItemStack getItemStack() {
		return item;
	}

	public ItemStackBuilder setName(String text) {
		this.name = color(text);
		return this;
	}

	public ItemStackBuilder setLore(List<String> lore) {
		lore.forEach((line) -> {
			this.lore.add(color("&f" + line));
		});
		return this;
	}

	public ItemStackBuilder setLore(String... lore) {
		this.lore.clear();
		for (String line : lore) {
			this.lore.add(color("&f" + line));
		}
		return this;
	}

	public ItemStackBuilder addEnchant(Enchantment enchant, int level) {
		enchantments.put(enchant, level);
		return this;
	}

	public ItemStackBuilder addFlag(ItemFlag flag) {
		this.flags.add(flag);
		return this;
	}

	public ItemStackBuilder addFlags(ItemFlag[] flags) {
		for (int i = 0; i < flags.length; i++) {
			this.flags.add(flags[i]);
		}
		return this;
	}
	
	public ItemStackBuilder setNBTString(CraftNMS provider, String key, String value) {
		this.item = provider.setNBTString(item, key, value);
		return this;
	}

	public ItemStackBuilder setNBTBoolean(CraftNMS provider, String key, boolean value) {
		this.item = provider.setNBTBoolean(item, key, value);
		return this;
	}
	
	public ItemStack build() {
		return buildItem();
	}

	protected ItemStack buildItem() {
		ItemStack i = this.item;
		ItemMeta m = i.getItemMeta();
		if (this.name != null) {
			m.setDisplayName(this.name);
		}

		if (!this.lore.isEmpty()) {
			m.setLore(this.lore);
		}

		if (!enchantments.isEmpty()) {
			enchantments.forEach((enchant, level) -> {
				m.addEnchant(enchant, level, true);
			});
		}

		if (!this.flags.isEmpty()) {
			this.flags.forEach(flag -> {
				m.addItemFlags(flag);
			});
		}

		i.setItemMeta(m);
		return i;
	}
	
	private String color(String textToTranslate) {
		return ChatColor.translateAlternateColorCodes('&', textToTranslate);
	}
}
