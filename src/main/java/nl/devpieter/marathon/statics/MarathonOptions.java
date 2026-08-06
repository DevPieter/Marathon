package nl.devpieter.marathon.statics;


import net.minecraft.client.OptionInstance;
import net.minecraft.network.chat.Component;

public class MarathonOptions {

    public static final OptionInstance<Boolean> SPRINT_TOGGLED_DECOY_OPTION = new OptionInstance<>(
            "key.sprint",
            OptionInstance.cachedConstantTooltip(Component.literal("Marathon hijacks this option to provide toggle sprint functionality.")),
            (optionText, value) -> Component.literal("Marathon"),
            OptionInstance.BOOLEAN_VALUES,
            false,
            value -> {
            }
    );

    public static final OptionInstance<Boolean> SNEAK_TOGGLED_DECOY_OPTION = new OptionInstance<>(
            "key.sneak",
            OptionInstance.cachedConstantTooltip(Component.literal("Marathon hijacks this option to provide toggle sneak functionality.")),
            (optionText, value) -> Component.literal("Marathon"),
            OptionInstance.BOOLEAN_VALUES,
            false,
            value -> {
            }
    );

    public static void init() {
        // Java magic
    }
}
