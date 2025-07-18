package nl.devpieter.marathon.mixins;

import net.minecraft.client.option.KeyBinding;
import nl.devpieter.marathon.Marathon;
import nl.devpieter.marathon.statics.KeyBindings;
import nl.devpieter.marathon.statics.Settings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(KeyBinding.class)
public abstract class KeyBindingMixin {

    @Shadow
    public abstract String getTranslationKey();

    @Inject(at = @At("HEAD"), method = "isPressed", cancellable = true)
    private void isPressed(CallbackInfoReturnable<Boolean> cir) {
        if (this.getTranslationKey().equals("key.sprint")) this.handleSprint(cir);
        else if (this.getTranslationKey().equals("key.sneak")) this.handleSneak(cir);
    }

    @Unique
    private void handleSprint(CallbackInfoReturnable<Boolean> cir) {
        boolean holding = KeyBindings.HYBRID_SPRINT_KEY.isPressed();
        if (holding) cir.setReturnValue(true);

        boolean toggled = Settings.SPRINT_TOGGLED.getValue();

        if (toggled && holding && Settings.SPRINT_INVERT_IF_TOGGLED.getValue()) {
            cir.setReturnValue(false);
        } else if (toggled) {
            cir.setReturnValue(true);
        }
    }

    @Unique
    private void handleSneak(CallbackInfoReturnable<Boolean> cir) {
        boolean holding = KeyBindings.HYBRID_SNEAK_KEY.isPressed();
        if (holding) cir.setReturnValue(true);

        boolean toggled = Settings.SNEAK_TOGGLED.getValue();

        if (toggled && holding && Settings.INVERT_SNEAKING_IF_TOGGLED.getValue()) {
            cir.setReturnValue(false);
        } else if (toggled) {
            cir.setReturnValue(true);
        }
    }
}
