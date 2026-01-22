package nl.devpieter.marathon.statics;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import nl.devpieter.marathon.HybridKeyBinding;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static final KeyBinding TOGGLE_SPRINT_KEY = new KeyBinding(
            "marathon.key.toggle_sprint",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_BRACKET,
            KeyBinding.Category.MOVEMENT
    );

    public static final HybridKeyBinding HYBRID_SPRINT_KEY = new HybridKeyBinding(
            "marathon.key.hybrid_sprint",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_CONTROL,
            KeyBinding.Category.MOVEMENT,
            Settings.SPRINT_DOUBLE_CLICK_DELAY.getValue()
    );

    public static final KeyBinding TOGGLE_SNEAK_KEY = new KeyBinding(
            "marathon.key.toggle_sneak",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_BRACKET,
            KeyBinding.Category.MOVEMENT
    );

    public static final HybridKeyBinding HYBRID_SNEAK_KEY = new HybridKeyBinding(
            "marathon.key.hybrid_sneak",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_SHIFT,
            KeyBinding.Category.MOVEMENT,
            Settings.SNEAK_DOUBLE_CLICK_DELAY.getValue()
    );

    public static void init() {
        KeyBindingHelper.registerKeyBinding(TOGGLE_SPRINT_KEY);
        KeyBindingHelper.registerKeyBinding(HYBRID_SPRINT_KEY.keyBinding());
        KeyBindingHelper.registerKeyBinding(TOGGLE_SNEAK_KEY);
        KeyBindingHelper.registerKeyBinding(HYBRID_SNEAK_KEY.keyBinding());
    }
}
