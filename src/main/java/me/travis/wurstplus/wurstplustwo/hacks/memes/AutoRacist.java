package me.travis.wurstplus.wurstplustwo.hacks.memes;

import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketChatMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoRacist extends WurstplusHack {

    public AutoRacist() {
        super(WurstplusCategory.WURSTPLUS_MEMES);

        this.name = "Auto Racist";
        this.tag = "AutoRacist";
        this.description = "nigga babe";
    }

    WurstplusSetting delay = create("Delay", "AntoRacistDelay", 10, 0, 100);
    WurstplusSetting anti_nword = create("Xtreme", "Xtreme", true);
    WurstplusSetting chanter = create("Chanter", "AntiRacismChanter", false);

    List<String> chants = new ArrayList<>();

    Random r = new Random();
    int tick_delay;

    @Override
    protected void enable() {
        tick_delay = 0;

        chants.add("dude <player> , why you are black? fuckoff");
        chants.add("repost for jingle floyd, ignore for trans rights");
        chants.add("where is niggers wtf");
        chants.add("why niggers exists? fuckoff god");
        chants.add("hahahaha you are black lmao");
        chants.add("support WLM, ignore BLM");
        chants.add("team wao go fuck yourself, <player> did you agree?");
        chants.add("<player> CHANGE YOUR DEFAULT SKIN TONE TO 1 NOW");
        chants.add("<player> exit here nigger");
        chants.add("fuck wao all my homes supports wlm babe");
        chants.add("<player> , <player> is nigger, kill him.");
        chants.add("DEREK CHAUVIN Is HOMIE BABE, HAHAHAHAH");
    }

    String[] random_correction = {
            "you has been flopped by floppahack",
            "SAY NO TO BLACKS, SAY YES TO WHITES",
            "TRANS RIGHTS = NIGGER RIGHTS, did you agree?",
            "Im an edgy teenager and saying the nword makes me feel empowered on the internet.",
            "mommy im just kidding dont punch me, niggers are cools",
            "Racist is like water, everyone have inside",
            "fire nigga fire fire",
            "Mommy and daddy are wrestling in the bedroom again so im going to play minecraft until their done",
            "haw to buy futur re caracked plaese",
            "do any nigger want marry with me?"
    };


    CharSequence nigger = "nigger";
    CharSequence nigga = "nigga";

    @Override
    public void update() {

        if(chanter.get_value(true)) {

            tick_delay++;

            if (tick_delay < delay.get_value(1) * 10) return;

            String s = chants.get(r.nextInt(chants.size()));
            String name = get_random_name();

            if (name.equals(mc.player.getName())) return;

            mc.player.sendChatMessage(s.replace("<player>", name));
            tick_delay = 0;

            }
        }

    public String get_random_name() {

            List<EntityPlayer> players = mc.world.playerEntities;
            return players.get(r.nextInt(players.size())).getName();
        }


    public String random_string(String[] list) {
        return list[r.nextInt(list.length)];
    }

    // Anti n-word

    @EventHandler
    private final Listener<WurstplusEventPacket.SendPacket> listener = new Listener<>(event -> {

        if (!(event.get_packet() instanceof CPacketChatMessage)) {
            return;
        }

        if(anti_nword.get_value(true)) {

            String message = ((CPacketChatMessage) event.get_packet()).getMessage().toLowerCase();

            if (message.contains(nigger) || message.contains(nigga)) {

                String x = Integer.toString((int) (mc.player.posX));
                String z = Integer.toString((int) (mc.player.posZ));

                String coords = x + " " + z;

                message = (random_string(random_correction));
                mc.player.connection.sendPacket(new CPacketChatMessage("Hi, im at 911, 69, 420, come teach me a lesson about racism"));

            }

            ((CPacketChatMessage) event.get_packet()).message = message;
        }
    });


}
