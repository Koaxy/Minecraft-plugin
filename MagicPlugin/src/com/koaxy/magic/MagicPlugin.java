package com.koaxy.magic;

import com.koaxy.magic.commands.MagicCommands;
import com.koaxy.magic.events.MagicPluginsEvents;
import com.koaxy.magic.items.MagicPluginItems;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStream;

public class MagicPlugin extends JavaPlugin {

    public void InitCommands()
    {

        MagicCommands commands = new MagicCommands();
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("farmtime").setExecutor(commands);
        getCommand("givewand").setExecutor(commands);
        getCommand("ci").setExecutor(commands);
        getCommand("fly").setExecutor(commands);
        getCommand("gmc").setExecutor(commands);
        getCommand("gms").setExecutor(commands);
        getCommand("gmsp").setExecutor(commands);
        //getCommand("gmp").setExecutor(commands);
    }

    @Override
    public void onEnable() {
        MagicPluginItems.init();
        getServer().getPluginManager().registerEvents(new MagicPluginsEvents(), this);
        // Begin
        InitCommands();
        // End of registering commands
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Registered all Command's succesfully!");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "MagicPlugin Is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Deregistering all command's");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "MagicPlugin Is Disabled!");
    }
}
