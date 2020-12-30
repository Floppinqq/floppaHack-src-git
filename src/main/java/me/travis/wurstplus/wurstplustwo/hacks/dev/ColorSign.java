package me.travis.wurstplus.wurstplustwo.hacks.dev;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.manager.WurstplusCommandManager;
import me.travis.wurstplus.wurstplustwo.util.WurstplusMessageUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.text.ITextComponent;

public class ColorSign extends WurstplusHack {

    public ColorSign() {
        super(WurstplusCategory.WURSTPLUS_BETA);

        this.name = ChatFormatting.RED + "Color Sign";
        this.tag = "ColorSign";
        this.description = "color signs with colors and formatting texts";
    }

    public void onEnable() {
        WurstplusMessageUtil.send_client_message("ColorSign in developement, sorry");
        disable();
    }
}
