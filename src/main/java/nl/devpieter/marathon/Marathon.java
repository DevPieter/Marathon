package nl.devpieter.marathon;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import nl.devpieter.marathon.mixins.accessors.KeyBindingAccessor;
import nl.devpieter.marathon.statics.KeyBindings;
import nl.devpieter.marathon.statics.Settings;
import nl.devpieter.utilize.utils.PlayerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Marathon implements ClientModInitializer {

    private static Marathon INSTANCE;

    private final Logger logger = LoggerFactory.getLogger("Marathon");

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        Settings.load();
        KeyBindings.init();

        KeyBindings.HYBRID_SPRINT_KEY.onDoubleClick(this::toggleSprint);
        KeyBindings.HYBRID_SNEAK_KEY.onDoubleClick(this::toggleSneak);

        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            if (!Settings.WAS_FIRST_BOOT) return;
            this.logger.info("First boot detected, hijacking sprint and sneak keys. ;D");

            KeyBinding currentSprintKey = client.options.sprintKey;
            InputUtil.Key sprintKey = ((KeyBindingAccessor) currentSprintKey).getBoundKey();
            KeyBindings.HYBRID_SPRINT_KEY.setBoundKey(sprintKey);
            currentSprintKey.setBoundKey(InputUtil.UNKNOWN_KEY);

            KeyBinding currentSneakKey = client.options.sneakKey;
            InputUtil.Key sneakKey = ((KeyBindingAccessor) currentSneakKey).getBoundKey();
            KeyBindings.HYBRID_SNEAK_KEY.setBoundKey(sneakKey);
            currentSneakKey.setBoundKey(InputUtil.UNKNOWN_KEY);

            // Bit hacky, but it works.
            client.options.write();
            client.options.load();
        });

        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            KeyBindings.HYBRID_SPRINT_KEY.tick();
            KeyBindings.HYBRID_SNEAK_KEY.tick();
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (KeyBindings.TOGGLE_SPRINT_KEY.wasPressed()) this.toggleSprint();
            if (KeyBindings.TOGGLE_SNEAK_KEY.wasPressed()) this.toggleSneak();
        });
    }

    public static Marathon getInstance() {
        return INSTANCE;
    }

    public Logger getLogger() {
        return logger;
    }

    private void toggleSprint() {
        Settings.SPRINT_TOGGLED.toggle();
        Settings.save(Settings.SPRINT_TOGGLED);

        MutableText sprintText = Text.translatable("marathon.text.sprint");
        MutableText statusText = Settings.SPRINT_TOGGLED.getValue() ? Text.translatable("marathon.text.toggled") : Text.translatable("marathon.text.untoggled");

        PlayerUtils.sendMessage(sprintText.append(" ").append(statusText), true);
    }

    private void toggleSneak() {
        Settings.SNEAK_TOGGLED.toggle();
        Settings.save(Settings.SNEAK_TOGGLED);

        MutableText sneakText = Text.translatable("marathon.text.sneak");
        MutableText statusText = Settings.SNEAK_TOGGLED.getValue() ? Text.translatable("marathon.text.toggled") : Text.translatable("marathon.text.untoggled");

        PlayerUtils.sendMessage(sneakText.append(" ").append(statusText), true);
    }
}
