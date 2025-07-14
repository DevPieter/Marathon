package nl.devpieter.marathon.enums;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public enum HudLocation {

    // TODO - Add more or change existing locations.
    TOP_LEFT("hud.location.top_left"),
    TOP_CENTER("hud.location.top_center"),
    TOP_RIGHT("hud.location.top_right"),
    BOTTOM_LEFT("hud.location.bottom_left"),
    BOTTOM_RIGHT("hud.location.bottom_right"),
    ABOVE_HOTBAR("hud.location.above_hotbar"),
    BELOW_CROSSHAIR("hud.location.below_crosshair");

    private final String translationKey;

    HudLocation(String translationKey) {
        this.translationKey = translationKey;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public @NotNull MutableText getText() {
        return Text.translatable(translationKey);
    }
}
