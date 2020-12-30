//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

//
// Decompiled by Procyon v0.5.36
//

package me.travis.wurstplus.wurstplustwo.hacks.movement;

import java.util.Iterator;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.util.WurstplusMessageUtil;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.Entity;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import net.minecraftforge.client.MinecraftForgeClient;

public class ElytraFly extends WurstplusHack
{
    public ElytraFly() {
        super(WurstplusCategory.WURSTPLUS_MOVEMENT);
        this.name = ChatFormatting.RED + "ElytraFly";
        this.tag = "ElytraFly";
        this.description = "fly w elytra duh";
    }

    WurstplusSetting speed = create("Speed", "ElytraSpeed", 1.16, 1.10, 1.16);

    @Override
    public void update() {
        if(mc.player.capabilities.isFlying || mc.player.isElytraFlying())
            mc.player.setSprinting(false);
        if (mc.player.capabilities.isFlying) {
            mc.player.setVelocity(0, 0, 0);
            mc.player.setPosition(mc.player.posX, mc.player.posY + 0, mc.player.posZ);
            mc.player.capabilities.setFlySpeed((float)speed.get_value(1));
            mc.player.setSprinting(false);
        }

        if (mc.player.onGround) {
            mc.player.capabilities.allowFlying = false;
        }

        if (mc.player.isElytraFlying()) {
            mc.player.capabilities.setFlySpeed(.915f);
            mc.player.capabilities.isFlying = true;

            if (!mc.player.capabilities.isCreativeMode)
                mc.player.capabilities.allowFlying = true;
        }
    }

    public void onEnable() {
        WurstplusMessageUtil.send_client_message("Enabled.");
    }
}
