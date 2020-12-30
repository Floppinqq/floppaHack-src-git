//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.hacks.render;

import java.util.Iterator;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.util.UtilTwo;
import net.b0at.api.event.EventHandler;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.Entity;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoSandRender extends WurstplusHack
{
    TileEntityShulkerBox sb;

    public NoSandRender() {
        super(WurstplusCategory.WURSTPLUS_RENDER);
        this.name = ChatFormatting.RED + "peek idk";
        this.tag = "NoSandRender";
        this.description = "allows you to drop FPS of other players but not you";
        this.sb = null;
    }

    public void toggleState() {
        ItemStack is = mc.player.inventory.getCurrentItem();

        if (is.getItem() instanceof ItemShulkerBox) {
            TileEntityShulkerBox entityBox = new TileEntityShulkerBox();
            UtilTwo.setPrivateValue(TileEntityShulkerBox.class, entityBox, ((ItemShulkerBox) is.getItem()).getBlock(), "blockType");
            entityBox.setWorld(mc.world);
            entityBox.readFromNBT(is.getTagCompound().getCompoundTag("BlockEntityTag"));
            sb = entityBox;
        }
    }

    @EventHandler
    public void onTick(TickEvent.PlayerTickEvent e) {
        if (sb != null) {
            mc.player.displayGUIChest(sb);
            sb = null;
        }
    }
}
