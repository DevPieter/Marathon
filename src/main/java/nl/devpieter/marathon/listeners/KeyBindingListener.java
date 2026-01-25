package nl.devpieter.marathon.listeners;

import nl.devpieter.marathon.Marathon;
import nl.devpieter.marathon.statics.KeyBindings;
import nl.devpieter.marathon.statics.Settings;
import nl.devpieter.sees.annotations.SEventListener;
import nl.devpieter.sees.listener.SListener;
import nl.devpieter.utilize.enums.KeyActionOverride;
import nl.devpieter.utilize.events.interaction.keybinding.KeyBindingPressedCheckEvent;
import org.jetbrains.annotations.NotNull;

public class KeyBindingListener implements SListener {

    private final Marathon marathon = Marathon.getInstance();

    @SEventListener
    public void onKeyBindingPressedCheck(KeyBindingPressedCheckEvent event) {
        if (event.getKeyId().equals("key.sprint") && marathon.isInitialized()) event.setResult(handleSprint());
        else if (event.getKeyId().equals("key.sneak") && marathon.isInitialized()) event.setResult(handleSneak());
    }

    private @NotNull KeyActionOverride handleSprint() {
        KeyActionOverride override = KeyActionOverride.FORCE_RELEASE;

        boolean holding = KeyBindings.HYBRID_SPRINT_KEY.isPressed();
        if (holding) override = KeyActionOverride.FORCE_PRESS;

        boolean toggled = Settings.SPRINT_TOGGLED.getValue();

        if (toggled && holding && Settings.SPRINT_INVERT_IF_TOGGLED.getValue()) {
            override = KeyActionOverride.FORCE_RELEASE;
        } else if (toggled) {
            override = KeyActionOverride.FORCE_PRESS;
        }

        return override;
    }

    private @NotNull KeyActionOverride handleSneak() {
        KeyActionOverride override = KeyActionOverride.FORCE_RELEASE;

        boolean holding = KeyBindings.HYBRID_SNEAK_KEY.isPressed();
        if (holding) override = KeyActionOverride.FORCE_PRESS;

        boolean toggled = Settings.SNEAK_TOGGLED.getValue();

        if (toggled && holding && Settings.INVERT_SNEAKING_IF_TOGGLED.getValue()) {
            override = KeyActionOverride.FORCE_RELEASE;
        } else if (toggled) {
            override = KeyActionOverride.FORCE_PRESS;
        }

        return override;
    }
}
