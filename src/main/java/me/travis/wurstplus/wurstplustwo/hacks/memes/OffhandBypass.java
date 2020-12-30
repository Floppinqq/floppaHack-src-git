package me.travis.wurstplus.wurstplustwo.hacks.memes;

// Default Imports
import com.mojang.realmsclient.gui.ChatFormatting;
import com.veteran.hack.util.VetHackTessellator;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.WurstplusTextureHelper;
import me.zero.alpine.fork.listener.Listener;
import net.b0at.api.event.EventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

import java.util.function.Predicate;

// Set the extend
public class OffhandBypass extends WurstplusHack {
    private final Listener<PlayerDestroyItemEvent> sendListener;

    // make the module be set

    public OffhandBypass() {
        // Info
        super(WurstplusCategory.WURSTPLUS_COMBAT);
        this.name = ChatFormatting.YELLOW + "OffhandBypass";
        this.tag = "OffhandBypass";
        this.description = "dsadawdawdas";
        
        //test
        Listener<PlayerDestroyItemEvent> sendListener;

        this.sendListener = new Listener<PlayerDestroyItemEvent>(e -> {
            if (e.getHand() == EnumHand.MAIN_HAND && OffhandBypass.mc.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL) {
                e.setCanceled(true);
            }
        }, (Predicate<PlayerDestroyItemEvent>[])new Predicate[0]);
        
    }
    // Code.



}
