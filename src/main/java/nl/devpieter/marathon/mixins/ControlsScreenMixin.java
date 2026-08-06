package nl.devpieter.marathon.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.options.controls.ControlsScreen;
import nl.devpieter.marathon.statics.MarathonOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

@Mixin(ControlsScreen.class)
public class ControlsScreenMixin {

    @ModifyReturnValue(at = @At("RETURN"), method = "options")
    private static OptionInstance<?>[] replaceOption(OptionInstance<?>[] original, Options options) {
        List<OptionInstance<?>> modified = new ArrayList<>(List.of(original));

        OptionInstance<Boolean> sprintOption = options.toggleSprint();
        OptionInstance<Boolean> sneakOption = options.toggleCrouch();

        for (int i = 0; i < modified.size(); i++) {
            if (modified.get(i) == sprintOption) modified.set(i, MarathonOptions.SPRINT_TOGGLED_DECOY_OPTION);
            else if (modified.get(i) == sneakOption) modified.set(i, MarathonOptions.SNEAK_TOGGLED_DECOY_OPTION);
        }

        return modified.toArray(new OptionInstance[0]);
    }
}
