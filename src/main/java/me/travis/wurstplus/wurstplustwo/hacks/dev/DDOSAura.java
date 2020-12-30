package me.travis.wurstplus.wurstplustwo.hacks.dev;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.event.WurstplusEventBus;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.WurstplusMessageUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemExpBottle;

public class DDOSAura extends WurstplusHack {

    public DDOSAura() {
        super(WurstplusCategory.WURSTPLUS_BETA);

        this.name        = ChatFormatting.RED + "DDOS Aura";
        this.tag         = "DDOSAura";
        this.description = "DDOS people on range";
   }

    public void onEnable() {
            WurstplusMessageUtil.send_client_message("You're ddosing.");
    }

}


