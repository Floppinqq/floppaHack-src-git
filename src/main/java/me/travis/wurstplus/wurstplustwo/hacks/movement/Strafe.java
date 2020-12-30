//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.hacks.movement;

import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPlayerJump;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.WurstplusMessageUtil;
import me.travis.wurstplus.wurstplustwo.util.WurstplusPlayerUtil;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.init.MobEffects;

import java.util.function.Predicate;

public class Strafe extends WurstplusHack
{
    private final WurstplusPlayerUtil util;
    private int jumpTicks;
    private boolean speed_potion_effect;
    WurstplusSetting speed_mode;
    WurstplusSetting auto_jump;
    @EventHandler
    private final Listener<WurstplusEventPlayerJump> on_jump;

    public Strafe() {
        super(WurstplusCategory.WURSTPLUS_BETA);
        this.util = new WurstplusPlayerUtil();
        this.jumpTicks = 0;
        this.speed_mode = this.create("Mode", "StrafeMode", "", this.combobox("Strafe", "OnGround"));
        this.auto_jump = this.create("Auto Jump", "StrafeAutoJump", true);
        this.on_jump = new Listener<WurstplusEventPlayerJump>(event -> event.cancel(), new Predicate[0]);
        this.name = "StrafeDev";
        this.tag = "StrafeDev";
        this.description = "dev dev dev dev dev";
    }
    @Override
    public void update() {
        double player_speed = this.util.getSpeed();
        if (Strafe.mc.player.isElytraFlying() || Strafe.mc.player.isRiding() || (Strafe.mc.player.moveForward == 0.0f && Strafe.mc.player.moveStrafing == 0.0f)) {
            return;
        }
        if (this.speed_mode.in("Strafe")) {
            this.util.setSpeed(this.util.getSpeed());
            Strafe.mc.player.speedInAir = 0.029f;
            this.util.setTimer(1.05f);
            if (Strafe.mc.player.speedInAir >= 0.029f) {
                mc.player.speedInAir = 0.02f;
            }
            if (this.jumpTicks > 0) {
                --this.jumpTicks;
            }
            if (mc.player.isPotionActive(MobEffects.SPEED)) {
                final int amplifier = mc.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
                player_speed *= (1.0d + 0.2d * (amplifier + 1));
            }
            if (this.auto_jump.get_value(true) && Strafe.mc.player.onGround && this.jumpTicks <= 0) {
                Strafe.mc.player.motionY = 0.405F;
                if (Strafe.mc.player.isSprinting()) {
                    this.util.addSpeed(0.0);
                }
                if (player_speed >= 0.2880) {
                    player_speed = 0.2799;
                }
                Strafe.mc.player.isAirBorne = true;
                this.jumpTicks = 4;
            }
        }
        if (this.speed_mode.in("OnGround") && Strafe.mc.player.onGround) {
            this.util.setSpeed(0.6174077d);
        }
    }
    public void enable() {
        WurstplusMessageUtil.send_client_message("StrafeDev is in developement, you probably will rubberband some times, but its fast.");
    }
    public void disable() {
        Strafe.mc.player.speedInAir = 0.02f;
        this.util.setTimer(1.0f);
        this.jumpTicks = 0;
    }
}
