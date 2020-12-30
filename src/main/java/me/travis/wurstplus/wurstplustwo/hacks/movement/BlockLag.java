package me.travis.wurstplus.wurstplustwo.hacks.movement;

// Default Imports
import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.ZoriWrapper;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

// Set the extend
public class BlockLag extends WurstplusHack {

    // make the module be set

    public BlockLag() {
        // Info
        super(WurstplusCategory.WURSTPLUS_MOVEMENT);
        this.name = ChatFormatting.RED + "BlockLag";
        this.tag = "Burrow";
        this.description = "burrow ezzz from zori lmfao ez nig";
    }
    // Code.
    public void onEnable() {
        if (this.is_active()) {
            mc.player.jump();

            mc.player.setPosition(mc.player.posX, mc.player.posY - 0.420, mc.player.posZ);
        }
    }
}
