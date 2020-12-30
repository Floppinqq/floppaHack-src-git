package me.travis.wurstplus.wurstplustwo.hacks.memes;

// Default Imports
import com.mojang.realmsclient.gui.ChatFormatting;
import com.veteran.hack.event.events.RenderEvent;
import com.veteran.hack.util.VetHackTessellator;
import me.travis.wurstplus.wurstplustwo.guiscreen.hud.WurstplusArrayList;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// Set the extend
public class BoxESP extends WurstplusHack {

    // make the module be set

    public BoxESP() {
        // Info
        super(WurstplusCategory.WURSTPLUS_MEMES);
        this.name = ChatFormatting.RED + "BoxESP";
        this.tag = "BoxESP";
        this.description = "BoxESP";
    }

    WurstplusSetting BoxR = create("R", "BoxR", 255, 0, 255);
    WurstplusSetting BoxG = create("G", "BoxG", 255, 0, 255);
    WurstplusSetting BoxB = create("B", "BoxB", 255, 0, 255);

    // Code.
    public void onWorldRender(final RenderEvent event) {
        final List<Entity> entities = new ArrayList<Entity>();
        entities.addAll((Collection<? extends Entity>) BoxESP.mc.world.loadedEntityList.stream().filter(entity -> entity instanceof EntityThrowable || entity instanceof EntityArrow).collect(Collectors.toList()));
        for (final Entity e : entities) {
            VetHackTessellator.prepare(7);
            final Color c = new Color(this.BoxR.get_value(1), this.BoxG.get_value(1), this.BoxB.get_value(1), 200);
            VetHackTessellator.release();
        }

    }
}
