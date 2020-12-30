package me.travis.wurstplus.wurstplustwo.hacks.dev;

import club.minnced.discord.rpc.DiscordRPC;
import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.PresenceCore;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

// Turn as a module
public class FloppaRPC extends WurstplusHack{
    public FloppaRPC() {
        super(WurstplusCategory.WURSTPLUS_BETA);
        this.name = ChatFormatting.RED + "FloppaRPC";
        this.tag = "FloppaRPC";
        this.description = "show da floppin flopper rpc in ur discord babe babe";
    }


    private void onEnable() {
        new PresenceCore().start();
    }

    // Disable
    private void onDisable() {
        DiscordRPC.INSTANCE.Discord_ClearPresence();
        DiscordRPC.INSTANCE.Discord_Shutdown();
    }

    /**@Floppinqq
      @12/29/2020
      @FloppaHack-b1.1 **/

}