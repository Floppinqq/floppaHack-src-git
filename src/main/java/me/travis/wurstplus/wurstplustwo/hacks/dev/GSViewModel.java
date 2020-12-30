package me.travis.wurstplus.wurstplustwo.hacks.dev;

import me.travis.wurstplus.wurstplustwo.event.WurstplusEventBus;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
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

public class GSViewModel extends WurstplusHack {
    public static Minecraft mc = Minecraft.getMinecraft();

    WurstplusSetting type = create("Type", "ViewModelType", "FOV", combobox("Value", "FOV", "Both"));
    WurstplusSetting cancelEating = create("No Eat", "NoEat", false);
    WurstplusSetting items = create("Items", "FovItems", true);
    WurstplusSetting xLeft = create("Left X", "LeftX", 0.0, -2.0, 2.0);
    WurstplusSetting yLeft = create("Left Y", "LeftY", 0.2, -2.0, 2.0);
    WurstplusSetting zLeft = create("Left Z", "LeftZ", -1.2, -2.0, 2.0);
    WurstplusSetting xRight = create("Right X", "RightX", 0.0, -2.0, 2.0);
    WurstplusSetting yRight = create("Right Y", "RightY", 0.2, -2.0, 2.0);
    WurstplusSetting zRight = create("Right Z", "RightZ", -1.2, -2.0, 2.0);
    WurstplusSetting custom_fov = create("Fov", "Fov", 120, 60, 160);
    private float fov;
    public GSViewModel() {

        super(WurstplusCategory.WURSTPLUS_BETA);

        this.name = "GSView Model";
        this.tag = "GSViewModel";
        this.description = "GameSense view model (dont work :( )";

    }
    @EventHandler
    private final Listener<TransformSideFirstPersonEvent> eventListener = new Listener<>(event -> {
        if (type.in("Value") || type.in("Both")) {
            if (event.getEnumHandSide() == EnumHandSide.RIGHT) {
                GlStateManager.translate(xRight.get_value(0), yRight.get_value(0), zRight.get_value(0));
            } else if (event.getEnumHandSide() == EnumHandSide.LEFT) {
                GlStateManager.translate(xLeft.get_value(0), yLeft.get_value(0), zLeft.get_value(0));
            }
        }
    });

    @SubscribeEvent
    public void onFov(EntityViewRenderEvent.FOVModifier event) {
        if (type.in("FOV") || type.in("Both")) {
            event.setFOV(fov);
        }
        fov = mc.gameSettings.fovSetting;
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
