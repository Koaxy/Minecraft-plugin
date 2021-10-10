package com.koaxy.magic.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MagicPluginItems
{
    public static ItemStack wand;

    public static void init(){
        createWand();
    }

    private static void createWand()
    {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Stick of Magic");
        List<String> lore = new ArrayList<>();
        lore.add("This powerful artifact is magic");
        lore.add("relic of epic shit");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 5000000, true);
        item.setItemMeta(meta);
        wand = item;
    }

}
