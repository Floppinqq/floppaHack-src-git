package me.travis.wurstplus.wurstplustwo.hacks.dev;

import me.travis.wurstplus.wurstplustwo.event.events.TransformSideFirstPersonEvent;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SimpleViewModel extends WurstplusHack {
    public static Minecraft mc = Minecraft.getMinecraft();

    WurstplusSetting items = create("Items", "FovItems", true);
    WurstplusSetting custom_fov = create("Fov", "Fov", 120, 60, 160);
    private float fov;
    public SimpleViewModel() {

        super(WurstplusCategory.WURSTPLUS_BETA);

        this.name = "View Model";
        this.tag = "SViewModel";
        this.description = "A Simple view model.";

    }

    @Override
    protected void enable() {
        fov = mc.gameSettings.fovSetting;
        MinecraftForge.EVENT_BUS.register(this);
    }
    @Override
    public void update() {
        mc.gameSettings.fovSetting = custom_fov.get_value(1);
    }
    @SubscribeEvent
    public void fov_event(final EntityViewRenderEvent.FOVModifier m) {
        if (items.get_value(true))
            m.setFOV(custom_fov.get_value(1));
    }
    @Override
    protected void disable() {
        mc.gameSettings.fovSetting = fov;
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}
