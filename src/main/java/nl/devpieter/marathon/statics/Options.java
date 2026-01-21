package nl.devpieter.marathon.statics;

import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

public class Options {

    public static final SimpleOption<Boolean> SPRINT_TOGGLED_DECOY_OPTION = new SimpleOption<>(
            "key.sneak",
            SimpleOption.constantTooltip(Text.of("Marathon hijacks this option to provide toggle sprint functionality.")),
            (optionText, value) -> Text.of("Marathon"),
            SimpleOption.BOOLEAN,
            false,
            value -> {
            }
    );

    public static final SimpleOption<Boolean> SNEAK_TOGGLED_DECOY_OPTION = new SimpleOption<>(
            "key.sneak",
            SimpleOption.constantTooltip(Text.of("Marathon hijacks this option to provide toggle sneak functionality.")),
            (optionText, value) -> Text.of("Marathon"),
            SimpleOption.BOOLEAN,
            false,
            value -> {
            }
    );

    public static void init() {
        // Java magic
    }
}
