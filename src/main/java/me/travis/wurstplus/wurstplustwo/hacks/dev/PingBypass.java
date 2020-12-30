package me.travis.wurstplus.wurstplustwo.hacks.dev;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class PingBypass extends WurstplusHack {

    public PingBypass() {
        super(WurstplusCategory.WURSTPLUS_BETA);

        this.name        = ChatFormatting.RED + "Ping Bypass";
        this.tag         = "PingBypass";
        this.description = "PingBypass";
    }
    WurstplusSetting EU = create("EU", "EU", true);
    WurstplusSetting US = create("US", "US", true);
    WurstplusSetting CH = create("China", "China", true);

    public void onEnable() {
        mc.player.sendChatMessage("oh oh ah ah floppaHack pingbypass china stronggg");
    }
}