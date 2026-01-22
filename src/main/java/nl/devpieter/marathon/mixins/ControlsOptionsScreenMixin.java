package nl.devpieter.marathon.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.gui.screen.option.ControlsOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import nl.devpieter.marathon.statics.Options;
import nl.devpieter.utilize.utils.minecraft.ClientUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

@Mixin(ControlsOptionsScreen.class)
public class ControlsOptionsScreenMixin {

    @ModifyReturnValue(at = @At("RETURN"), method = "getOptions(Lnet/minecraft/client/option/GameOptions;)[Lnet/minecraft/client/option/SimpleOption;")
    private static SimpleOption<?>[] replaceOption(SimpleOption<?>[] original, GameOptions gameOptions) {
        List<SimpleOption<?>> modified = new ArrayList<>(List.of(original));

        GameOptions options = ClientUtils.getClient().options;
        SimpleOption<Boolean> sprintOption = options.getSprintToggled();
        SimpleOption<Boolean> sneakOption = options.getSneakToggled();

        for (int i = 0; i < modified.size(); i++) {
            if (modified.get(i) == sprintOption) modified.set(i, Options.SPRINT_TOGGLED_DECOY_OPTION);
            else if (modified.get(i) == sneakOption) modified.set(i, Options.SNEAK_TOGGLED_DECOY_OPTION);
        }

        return modified.toArray(new SimpleOption[0]);
    }
}
