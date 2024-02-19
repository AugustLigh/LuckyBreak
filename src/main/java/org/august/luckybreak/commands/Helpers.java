package org.august.luckybreak.commands;

import org.august.luckybreak.ConfigManager;
import org.august.luckybreak.main.LuckyBreak;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Helpers {
    private static final ChatColor AQUA = ChatColor.AQUA;
    private static final ChatColor GOLD = ChatColor.GOLD;
    private static final ChatColor GREEN = ChatColor.GREEN;
    // Define the message templates as constants
    private static final String ALREADY_MESSAGE = AQUA + "[LuckyBreak] " + "%s" + "The LuckyBreak is already %s!";
    private static final String SUCCESS_MESSAGE = AQUA + "[LuckyBreak] " + "%s" + "Successfully %s the LuckyBreak!";
    public static void sendMessage(CommandSender sender, boolean isPlayer, String message) {
        if (isPlayer) {
            sender.sendMessage(message);
        } else {
            LuckyBreak.getPlugin().getServer().getConsoleSender().sendMessage(message);
        }
    }

    public static void togglePlugin(CommandSender sender, boolean isPlayer, boolean enable) {
        if (ConfigManager.getInstance().getConfig().isActivated() == enable) {
            String message = String.format(ALREADY_MESSAGE, enable ? GOLD : GREEN, enable ? "activated" : "deactivated");
            sendMessage(sender, isPlayer, message);
        } else {
            ConfigManager.getInstance().getConfig().setActivated(enable);

            String message = String.format(SUCCESS_MESSAGE, enable ? GOLD : GREEN, enable ? "activated" : "deactivated");
            sendMessage(sender, isPlayer, message);
        }
    }
}
