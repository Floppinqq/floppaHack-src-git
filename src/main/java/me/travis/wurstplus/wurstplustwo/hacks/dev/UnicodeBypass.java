package me.travis.wurstplus.wurstplustwo.hacks.dev;

import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;

public class UnicodeBypass extends WurstplusHack {

    public UnicodeBypass() {
        super(WurstplusCategory.WURSTPLUS_BETA);

        this.name        = "UnicodeBypass";
        this.tag         = "UnicodeBypass";
        this.description = "turns & into §";
    }

    @EventHandler
    private final Listener<WurstplusEventPacket.SendPacket> listener = new Listener<>(event -> {
        if(event.get_packet() instanceof CPacketChatMessage){
            if(((CPacketChatMessage) event.get_packet()).getMessage().startsWith("/")) return;
            String old = ((CPacketChatMessage) event.get_packet()).getMessage();
            String s = old.replace("&", "§");
            if(s.length() > 255) return;
            ((CPacketChatMessage) event.get_packet()).message = s;
        }
    });
}


