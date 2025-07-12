package nl.devpieter.marathon;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class HybridKeyBinding {

    private final KeyBinding keyBinding;

    private long doubleClickThreshold;

    private boolean wasHeldLastTick;
    private long lastPressTime;

    private Runnable onDoubleClick = () -> {
    };

    public HybridKeyBinding(String translationKey, InputUtil.Type type, int code, String category, long doubleClickThreshold) {
        this.doubleClickThreshold = doubleClickThreshold;
        this.keyBinding = new KeyBinding(translationKey, type, code, category);
    }

    public void tick() {
        boolean isPressed = this.keyBinding.isPressed();
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

    public KeyBinding keyBinding() {
        return this.keyBinding;
    }

    public boolean wasHeldLastTick() {
        return this.wasHeldLastTick;
    }

    public long lastPressTime() {
        return this.lastPressTime;
    }

    public boolean isPressed() {
        return this.keyBinding.isPressed();
    }

    public boolean wasPressed() {
        return this.keyBinding.wasPressed();
    }

    public void setBoundKey(InputUtil.Key key) {
        this.keyBinding.setBoundKey(key);
    }
}
