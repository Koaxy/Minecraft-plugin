package com.koaxy.magic.commands;

import com.koaxy.magic.items.MagicPluginItems;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import java.util.Locale;

public class MagicCommands implements CommandExecutor {

    // Definitions for our Permissions!
   // public String HealPermission = ""; // keep it empty currently as it is un-used.
    //public String GameModePermission = "MagicCommand.gamemode";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only Players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        // /heal

        if (cmd.getName().equalsIgnoreCase("heal"))
        {
            if (player.hasPermission("MagicCommand.heal")){
                double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                player.setHealth(maxHealth);
                player.sendMessage("§e§l(!) §eYou have been healed!");
            }
            else
            {
                player.sendMessage(ChatColor.RED + "Excuse me, you do not have permission to access this command!");
            }
        }
        else if (cmd.getName().equalsIgnoreCase("feed")){
            if (player.hasPermission("MagicCommand.feed"))
            {
                player.setFoodLevel(20);
                player.sendMessage(player.getDisplayName() + "§e§l(!) §eYou have been fed!");
            }
            else {
                player.sendMessage(ChatColor.RED + "Excuse me, you do not have permission to access this command!");
            }
        }

        else if (cmd.getName().equalsIgnoreCase("farmtime"))
        {
            if (player.hasPermission("MagicCommand.spawnmobs"))
            {
                if (args.length >= 2){
                    try {
                        EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                        int amount = Integer.parseInt(args[1]);
                        for(int i = 0; i < amount; i++){
                            player.getWorld().spawnEntity(player.getLocation(), entity);
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        player.sendMessage("Not a valid entity!");
                    }
                }
                else
                {
                    player.sendMessage("§e§l(!) §c/farmtime <mob> <amount>");
                }
            }
            else
            {
                player.sendMessage(ChatColor.RED + "Excuse me, you do not have permission to access this command!");
            }

        }
        else if(cmd.getName().equalsIgnoreCase("givewand"))
        {
            if (player.hasPermission("MagicCommand.givewand"))
            {
                player.getInventory().addItem(MagicPluginItems.wand);
            }
            else
            {
                player.sendMessage(ChatColor.RED + "Excuse me, you do not have permission to access this command!");
            }
        }
        else if (cmd.getName().equalsIgnoreCase("ci"))
        {
            if (player.hasPermission("MagicCommand.manageinventory"))
            {
                player.getInventory().clear();
                player.sendMessage("§e§l(!) §cCleared you're Inventory!");
            }
            else
            {
                player.sendMessage(ChatColor.RED + "Excuse me, you do not have permission to access this command!");
            }

        }


        else if (cmd.getName().equalsIgnoreCase("fly"))
        {
            if (player.hasPermission("MagicCommand.fly")) {
                if (player.isFlying()){
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage("Flying is Disabled");
                }
                else
                {
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage("Flying is Enabled");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Excuse me, you do not have permission to access this command!");
            }
        }
        else if (cmd.getName().equalsIgnoreCase("gmc"))
        {
            if (player.hasPermission("MagicCommand.gamemode")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("§e§l(!) §cSet Your gamemode to creative!");
            }
            else {
                player.sendMessage(ChatColor.RED + "Excuse me, you do not have permission to access this command!");
            }
        }
        else if (cmd.getName().equalsIgnoreCase("gmsp"))
        {
            if (player.hasPermission("MagicCommand.gamemode"))
            {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("§e§l(!) §cSet Your gamemode to spectator mode!");
            }
            else
            {
                player.sendMessage(ChatColor.RED + "Excuse me, you do not have permission to access this command!");
            }
        }
        else if (cmd.getName().equalsIgnoreCase("gms")) {
            if (player.hasPermission("MagicCommand.gamemode")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("§e§l(!) §cSet Your gamemode to creative!");
            } else {
                player.sendMessage(ChatColor.RED + "Excuse me, you do not have permission to access this command!");
            }
        }
        return true;
    }
}
