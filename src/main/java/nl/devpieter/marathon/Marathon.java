package nl.devpieter.marathon;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import nl.devpieter.marathon.listeners.KeyBindingListener;
import nl.devpieter.marathon.mixins.accessors.KeyBindingAccessor;
import nl.devpieter.marathon.statics.KeyBindings;
import nl.devpieter.marathon.statics.MarathonOptions;
import nl.devpieter.marathon.statics.Settings;
import nl.devpieter.sees.Sees;
import nl.devpieter.utilize.client.utils.PlayerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Marathon implements ClientModInitializer {

    private static Marathon INSTANCE;

    private final Logger logger = LoggerFactory.getLogger("Marathon");

    private boolean initialized = false;

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        Settings.load();

        MarathonOptions.init();
        KeyBindings.init();

        KeyBindings.HYBRID_SPRINT_KEY.onDoubleClick(this::toggleSprint);
        KeyBindings.HYBRID_SNEAK_KEY.onDoubleClick(this::toggleSneak);

        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {

            // Force disable vanilla sprint and sneak toggles.
            // When these are enabled, the game will crash.
            client.options.toggleSprint().set(false);
            client.options.toggleCrouch().set(false);

            if (Settings.WAS_FIRST_BOOT) {
                this.logger.info("First boot detected, hijacking sprint and sneak keys. ;D");

                KeyMapping currentSprintKey = client.options.keySprint;
                InputConstants.Key sprintKey = ((KeyBindingAccessor) currentSprintKey).marathon$getKey();
                KeyBindings.HYBRID_SPRINT_KEY.setKey(sprintKey);
                currentSprintKey.setKey(InputConstants.UNKNOWN);

                KeyMapping currentSneakKey = client.options.keyShift;
                InputConstants.Key sneakKey = ((KeyBindingAccessor) currentSneakKey).marathon$getKey();
                KeyBindings.HYBRID_SNEAK_KEY.setKey(sneakKey);
                currentSneakKey.setKey(InputConstants.UNKNOWN);
            }

            // A bit hacky, but it works.
            client.options.save();
            client.options.load();

            this.initialized = true;
        });

        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            KeyBindings.HYBRID_SPRINT_KEY.tick();
            KeyBindings.HYBRID_SNEAK_KEY.tick();
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (KeyBindings.TOGGLE_SPRINT_KEY.consumeClick()) this.toggleSprint();
            if (KeyBindings.TOGGLE_SNEAK_KEY.consumeClick()) this.toggleSneak();
        });

        Sees sees = Sees.getSharedInstance();
        sees.subscribe(new KeyBindingListener());
    }

    public static Marathon getInstance() {
        return INSTANCE;
    }

    public Logger getLogger() {
        return logger;
    }

    public boolean isInitialized() {
        return initialized;
    }

    private void toggleSprint() {
        Settings.SPRINT_TOGGLED.toggle();
        Settings.save(Settings.SPRINT_TOGGLED);

        MutableComponent sprintText = Component.translatable("marathon.text.sprint");
        MutableComponent statusText = Settings.SPRINT_TOGGLED.getValue() ? Component.translatable("marathon.text.toggled") : Component.translatable("marathon.text.untoggled");

        PlayerUtils.sendOverlayMessage(sprintText.append(" ").append(statusText));
    }

    private void toggleSneak() {
        Settings.SNEAK_TOGGLED.toggle();
        Settings.save(Settings.SNEAK_TOGGLED);

        MutableComponent sneakText = Component.translatable("marathon.text.sneak");
        MutableComponent statusText = Settings.SNEAK_TOGGLED.getValue() ? Component.translatable("marathon.text.toggled") : Component.translatable("marathon.text.untoggled");

        PlayerUtils.sendOverlayMessage(sneakText.append(" ").append(statusText));
    }
}
