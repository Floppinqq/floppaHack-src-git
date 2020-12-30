package me.travis.wurstplus.wurstplustwo.hacks.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.hacks.movement.ClientSideSpeed;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ClientSideStrenght extends WurstplusHack {
    public ClientSideStrenght() {
        super(WurstplusCategory.WURSTPLUS_MISC);
        this.name = ChatFormatting.GOLD + "Strenght";
        this.tag = "ClientSideStrenght";
        this.description = "Gives you strenght, wow.";
    }

    WurstplusSetting str_multiplier = create("Multiplier", "Multiplier", 1, 0, 2);

    public void update() {
        final PotionEffect effect = new PotionEffect(Potion.getPotionById(5), 123456789, str_multiplier.get_value(1));
        effect.setPotionDurationMax(true);
        ClientSideSpeed.mc.player.addPotionEffect(effect);
    }
    public void disable() {
        ClientSideSpeed.mc.player.removePotionEffect(Potion.getPotionById(5));
    }
}
