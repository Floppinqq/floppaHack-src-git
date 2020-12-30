package me.travis.wurstplus.wurstplustwo.hacks.dev;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventDamageBlock;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.WurstplusMessageUtil;
import me.zero.alpine.fork.listener.Listener;
import net.b0at.api.event.EventHandler;
import net.minecraft.network.play.client.CPacketConfirmTeleport;

public class CancelPortal extends WurstplusHack {
    public CancelPortal() {
        super(WurstplusCategory.WURSTPLUS_BETA);
        this.name = ChatFormatting.RED + "CancelPortal";
        this.name = "CancelPortal";
        this.description = "Makes you be able to open gui and chat while in portal";
    }

    public void onEnable() {
        WurstplusMessageUtil.send_client_message("enabled hahahaha");
        final Listener<WurstplusEventPacket> listener = new Listener<>(event -> {
            if (event.get_packet() instanceof CPacketConfirmTeleport) {
                event.cancel();
            }
        });
    }
}
