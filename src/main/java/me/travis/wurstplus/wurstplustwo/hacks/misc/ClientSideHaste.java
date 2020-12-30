package me.travis.wurstplus.wurstplustwo.hacks.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.hacks.movement.ClientSideSpeed;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ClientSideHaste extends WurstplusHack {
    public ClientSideHaste() {
        super(WurstplusCategory.WURSTPLUS_MISC);
        this.name = ChatFormatting.GOLD + "Client Side Haste";
        this.tag = "ClientSideHaste";
        this.description = "Gives you haste, wow.";
    }

    WurstplusSetting haste_speed = create("HasteSpeed", "HSpeed", 1, 0, 5);

    public void update() {
        final PotionEffect effect = new PotionEffect(Potion.getPotionById(3), 123456789, haste_speed.get_value(1));
        effect.setPotionDurationMax(true);
        ClientSideSpeed.mc.player.addPotionEffect(effect);
    }
    public void disable() {
        ClientSideSpeed.mc.player.removePotionEffect(Potion.getPotionById(3));
    }
}
