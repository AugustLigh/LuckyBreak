package org.august.luckybreak.utils;

import org.august.luckybreak.ConfigManager;
import org.august.luckybreak.dto.DropSettings;
import org.bukkit.Material;

import java.util.*;

public class LogicUtils {
    private final static List<Material> onlyItem = new ArrayList<>();
    private final static int len;
    private final static Random r;

    private static final List<Material> UNOBTAINABLE_MATERIALS = Arrays.asList(
            Material.BEDROCK, // Бедрок
            Material.END_PORTAL_FRAME, // Рамка портала в Энд
            Material.BARRIER, // Барьер
            Material.COMMAND_BLOCK, // Командный блок
            Material.STRUCTURE_BLOCK, // Блок структуры
            Material.PETRIFIED_OAK_SLAB, // Окаменелая дубовая плита
            Material.REINFORCED_DEEPSLATE, // Укрепленный глубокий сланец
            Material.BUDDING_AMETHYST, // Почкование аметиста
            Material.INFESTED_COBBLESTONE, // Зараженный булыжник
            Material.INFESTED_DEEPSLATE, // Зараженный глубокий сланец
            Material.INFESTED_STONE, // Зараженный камень
            Material.INFESTED_STONE_BRICKS // Зараженные каменные кирпичи
    );


    static {
        r = new Random();
        ConfigManager configManager = ConfigManager.getInstance();

        for (Material mat : Material.values()) {
            if (mat.isItem() && !isExcluded(mat, configManager)) {
                onlyItem.add(mat);
            }
        }

        len = onlyItem.size();
    }

    public static synchronized Material getRandomItems() {
        int index = r.nextInt(len);
        return onlyItem.get(index);
    }

    public static List<Material> getItems() {
        return Collections.unmodifiableList(onlyItem);
    }

    private static boolean isExcluded(Material mat, ConfigManager config) {
        DropSettings dropSettings = config.getConfig().getDropSettings();
        if (dropSettings.isDropRequested()) {
            if (UNOBTAINABLE_MATERIALS.contains(mat)) {
                return true;
            }
        }

        if (dropSettings.isDropEgs()) {
            if (mat.name().contains("SPAWN_EGG")) {
                return true;
            }
        }

        return false;
    }

}

