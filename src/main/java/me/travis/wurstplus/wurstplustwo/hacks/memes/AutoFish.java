package me.travis.wurstplus.wurstplustwo.hacks.memes;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import net.b0at.api.event.EventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.lang.reflect.Field;
import java.lang.Class;

public class AutoFish extends WurstplusHack {
    private boolean catching;
    private double tolerance;

    public AutoFish() {
        super(WurstplusCategory.WURSTPLUS_MEMES);
        this.name = ChatFormatting.RED + "Auto Fish";
        this.tag = "AutoFish";
        this.description = "fishs automatically";
    }

    @EventHandler
    public void onPlayerTick(TickEvent.PlayerTickEvent e){
        if (this.is_active()) {
            if (mc.player.fishEntity != null
                    && isHooked(mc.player.fishEntity)
                    && !catching) {
                catching = true;

                new Thread("AutoFish") {

                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        catching = false;
                    }
                };
            }
        }
    }
    private boolean isHooked(EntityFishHook hook)
    {
        return hook.motionX == 0.0D && hook.motionZ == 0.0D
                && hook.motionY <= tolerance;
    }

}
