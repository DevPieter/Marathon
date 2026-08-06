package nl.devpieter.marathon;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

public class HybridKeyBinding {

    private final KeyMapping keyBinding;

    private long doubleClickThreshold;

    private boolean wasHeldLastTick;
    private long lastPressTime;

    private Runnable onDoubleClick = () -> {
    };

    public HybridKeyBinding(String translationKey, InputConstants.Type type, int code, KeyMapping.Category category, long doubleClickThreshold) {
        this.doubleClickThreshold = doubleClickThreshold;
        this.keyBinding = new KeyMapping(translationKey, type, code, category);
    }

    public void tick() {
        boolean isPressed = this.keyBinding.isDown();
        long currentTime = System.currentTimeMillis();

        if (isPressed) {
            if (!this.wasHeldLastTick) {
                if (currentTime - this.lastPressTime < this.doubleClickThreshold) this.onDoubleClick.run();
                this.lastPressTime = currentTime;
            }
        }

        this.wasHeldLastTick = isPressed;
    }

    public HybridKeyBinding onDoubleClick(Runnable action) {
        this.onDoubleClick = action;
        return this;
    }

    public long doubleClickThreshold() {
        return this.doubleClickThreshold;
    }

    public void setDoubleClickThreshold(long doubleClickThreshold) {
        this.doubleClickThreshold = doubleClickThreshold;
    }

    public KeyMapping keyBinding() {
        return this.keyBinding;
    }

    public boolean wasHeldLastTick() {
        return this.wasHeldLastTick;
    }

    public long lastPressTime() {
        return this.lastPressTime;
    }

    public boolean isDown() {
        return this.keyBinding.isDown();
    }

    public boolean consumeClick() {
        return this.keyBinding.consumeClick();
    }

    public void setKey(InputConstants.Key key) {
        this.keyBinding.setKey(key);
    }
}
