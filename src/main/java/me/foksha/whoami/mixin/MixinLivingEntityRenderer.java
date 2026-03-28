package me.foksha.whoami.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntityRenderer.class)
public class MixinLivingEntityRenderer {
    @ModifyExpressionValue(
        method = "shouldShowName(Lnet/minecraft/world/entity/LivingEntity;D)Z",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/Minecraft;getCameraEntity()Lnet/minecraft/world/entity/Entity;"
        )
    )
    private Entity obfuscateCameraEntity(Entity original) {
        // Keep vanilla nametag checks, only bypass the `entity != cameraEntity` self check.
        return null;
    }
}
