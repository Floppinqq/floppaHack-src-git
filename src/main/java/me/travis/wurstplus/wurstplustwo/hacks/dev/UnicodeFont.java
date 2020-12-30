package me.travis.wurstplus.wurstplustwo.hacks.dev;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.network.play.client.CPacketChatMessage;

public class UnicodeFont extends WurstplusHack {

    public UnicodeFont() {
        super(WurstplusCategory.WURSTPLUS_BETA);

        this.name        = ChatFormatting.RED + "UnicodeFont";
        this.tag         = "UnicodeFont";
        this.description = "asdadawdaw";
    }

    public void onEnable() {
        final FontRenderer fontRenderer = UnicodeFont.mc.fontRenderer;
        final boolean unicodeFlag = true;
        fontRenderer.unicodeFlag = unicodeFlag;
        if (unicodeFlag) {
            return;
        }
        UnicodeFont.mc.fontRenderer.unicodeFlag = true;
        UnicodeFont.mc.gameSettings.forceUnicodeFont = true;
    }

    public void onDisable() {
        final FontRenderer fontRenderer = UnicodeFont.mc.fontRenderer;
        final boolean unicodeFlag = false;
        fontRenderer.unicodeFlag = unicodeFlag;
        if (unicodeFlag) {
            return;
        }
        UnicodeFont.mc.fontRenderer.unicodeFlag = false;
        UnicodeFont.mc.gameSettings.forceUnicodeFont = false;
    }
}


