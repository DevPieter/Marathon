package nl.devpieter.marathon.statics;

import nl.devpieter.marathon.Marathon;
import nl.devpieter.utilize.setting.SettingManager;
import nl.devpieter.utilize.setting.interfaces.ISetting;
import nl.devpieter.utilize.setting.settings.BooleanSetting;
import nl.devpieter.utilize.setting.settings.IntSetting;
import nl.devpieter.utilize.utils.common.FileUtils;

import java.io.File;
import java.util.List;

public class Settings {

    private static final File CONFIG_FOLDER = new File("config/marathon");
    private static final File SETTINGS_FILE = new File(CONFIG_FOLDER, "Settings.json");

    public static boolean WAS_FIRST_BOOT = false;

    private static final BooleanSetting FIRST_BOOT = new BooleanSetting(
            "marathon.first_boot",
            true
    );

    public static final BooleanSetting SPRINT_TOGGLED = new BooleanSetting(
            "marathon.sprint.toggled",
            false
    );

    public static final BooleanSetting SPRINT_INVERT_IF_TOGGLED = new BooleanSetting(
            "marathon.sprint.invert_if_toggled",
            true
    );

    public static final IntSetting SPRINT_DOUBLE_CLICK_DELAY = new IntSetting(
            "marathon.sprint.double_click_delay",
            300
    );

    public static final BooleanSetting SNEAK_TOGGLED = new BooleanSetting(
            "marathon.sneak.toggled",
            false
    );

    public static final BooleanSetting INVERT_SNEAKING_IF_TOGGLED = new BooleanSetting(
            "marathon.sneak.invert_if_toggled",
            true
    );

    public static final IntSetting SNEAK_DOUBLE_CLICK_DELAY = new IntSetting(
            "marathon.sneak.double_click_delay",
            300
    );

    public static void load() {
        if (!FileUtils.doesFileExist(SETTINGS_FILE)) {
            Marathon.getInstance().getLogger().info("Settings file does not exist, skipping load.");

            checkFirstBoot();
            return;
        }

        SettingManager settingManager = SettingManager.getInstance();
        settingManager.loadSettings(SETTINGS_FILE, List.of(
                FIRST_BOOT,
                SPRINT_TOGGLED,
                SPRINT_INVERT_IF_TOGGLED,
                SPRINT_DOUBLE_CLICK_DELAY,
                SNEAK_TOGGLED,
                INVERT_SNEAKING_IF_TOGGLED,
                SNEAK_DOUBLE_CLICK_DELAY
        ));

        Marathon.getInstance().getLogger().info("Settings loaded successfully.");
        checkFirstBoot();
    }

    public static void save(ISetting<?> setting) {
        if (!FileUtils.tryCreateFile(SETTINGS_FILE)) {
            Marathon.getInstance().getLogger().info("Could not create settings file.");
            return;
        }

        SettingManager settingManager = SettingManager.getInstance();
        settingManager.queueSave(SETTINGS_FILE, setting);
    }

    private static void checkFirstBoot() {
        WAS_FIRST_BOOT = FIRST_BOOT.getValue();

        if (WAS_FIRST_BOOT) {
            FIRST_BOOT.setValue(false);
            save(FIRST_BOOT);
        }
    }
}
