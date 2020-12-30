package me.travis.wurstplus.wurstplustwo.hacks.memes;

import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.WurstplusMessageUtil;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public final class RocanStrafe extends WurstplusHack {
    public RocanStrafe() {
        super(WurstplusCategory.WURSTPLUS_MEMES);
        this.name = "AutoCoordLeak";
        this.tag = "ACL";
        this.description = "leak ur coords lmfao";
    }

    public void enable() {

        mc.player.sendChatMessage("i just got backdoored, my coords are: " + mc.player.posX + ", " + mc.player.posY + ", " + mc.player.posZ + ". Come here kill me!");
        WurstplusMessageUtil.send_client_message(":trollface:");
    }
}
