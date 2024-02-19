package org.august.luckybreak.handlers;

import org.august.luckybreak.ConfigManager;
import org.august.luckybreak.utils.LogicUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class BlockBreakEvent implements Listener {

    @org.bukkit.event.EventHandler
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent e) {
        if (!ConfigManager.getInstance().getConfig().isActivated()) {
            return;
        }

        e.setDropItems(false);
        if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
            final Block block = e.getBlock();
            final World world = block.getWorld();

            Material itemType = LogicUtils.getRandomItems();
            if (itemType != null) {
                ItemStack randItem = new ItemStack(itemType, 1);
                world.dropItemNaturally(block.getLocation(), randItem);
            } else {
                e.getPlayer().sendMessage("Не удалось получить случайный предмет");
            }
        }

    }

}
