package me.travis.wurstplus.wurstplustwo.hacks.render;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import net.minecraft.network.play.client.CPacketCloseWindow;

public class NoRender extends WurstplusHack {
    public NoRender() {
        super(WurstplusCategory.WURSTPLUS_RENDER);
        this.name = ChatFormatting.RED + "NoChat";
        this.tag = "NoRenderDEV";
        this.description = "no render lol";
    }
    WurstplusSetting ingameguichanges = create("wdawdaw", "dawdawd", true);

    public void update() {
        if (ingameguichanges.get_value(true)) {
            mc.ingameGUI.getChatGUI().clearChatMessages(true);
        }
    }

}
