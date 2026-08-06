package nl.devpieter.marathon.statics;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import nl.devpieter.marathon.HybridKeyBinding;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static final KeyMapping TOGGLE_SPRINT_KEY = new KeyMapping(
            "marathon.key.toggle_sprint",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_BRACKET,
            KeyMapping.Category.MOVEMENT
    );

    public static final HybridKeyBinding HYBRID_SPRINT_KEY = new HybridKeyBinding(
            "marathon.key.hybrid_sprint",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_CONTROL,
            KeyMapping.Category.MOVEMENT,
            Settings.SPRINT_DOUBLE_CLICK_DELAY.getValue()
    );

    public static final KeyMapping TOGGLE_SNEAK_KEY = new KeyMapping(
            "marathon.key.toggle_sneak",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_BRACKET,
            KeyMapping.Category.MOVEMENT
    );

    public static final HybridKeyBinding HYBRID_SNEAK_KEY = new HybridKeyBinding(
            "marathon.key.hybrid_sneak",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_SHIFT,
            KeyMapping.Category.MOVEMENT,
            Settings.SNEAK_DOUBLE_CLICK_DELAY.getValue()
    );

    public static void init() {
        KeyMappingHelper.registerKeyMapping(TOGGLE_SPRINT_KEY);
        KeyMappingHelper.registerKeyMapping(HYBRID_SPRINT_KEY.keyBinding());
        KeyMappingHelper.registerKeyMapping(TOGGLE_SNEAK_KEY);
        KeyMappingHelper.registerKeyMapping(HYBRID_SNEAK_KEY.keyBinding());
    }
}
