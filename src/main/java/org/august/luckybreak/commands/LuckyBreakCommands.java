package org.august.luckybreak.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class LuckyBreakCommands implements CommandExecutor {
    private final Map<String, CommandExecutor> commands = new HashMap<>();

    public LuckyBreakCommands() {
        commands.put("start", new StartCommand());
        commands.put("stop", new StopCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            try {
                CommandExecutor executor = commands.get(args[0].toLowerCase());
                if (executor != null) {
                    checkPermission(sender, "luckybreak.toggle", executor, command, label, args);
                }
            } catch (IllegalArgumentException e) {
                sendUsageMessage(sender);
            }
        } else {
            sendUsageMessage(sender);
        }

        return true;
    }

    private void checkPermission(CommandSender sender, String permission, CommandExecutor commandClass, Command command, String label, String[] args) {
        if (sender.hasPermission(permission)) {
            commandClass.onCommand(sender, command, label, args);
        } else {
            boolean isPlayer = sender instanceof Player;
            Helpers.sendMessage(sender, isPlayer, ChatColor.RED + "You don't have permission to use this command!");
        }
    }

    private void sendUsageMessage(CommandSender sender) {
        boolean isPlayer = sender instanceof Player;
        Helpers.sendMessage(sender, isPlayer, ChatColor.AQUA + "[LuckyBreak] " + ChatColor.GREEN + "Usage: " + ChatColor.GOLD
                + "/luckybreak /start/stop");
    }
}
