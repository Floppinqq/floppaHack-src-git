package me.travis.wurstplus.wurstplustwo.hacks.movement;

import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventGUIScreen;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;

import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.gui.GuiChat;

import org.lwjgl.input.Keyboard;
public class InventoryMove extends WurstplusHack {
    public InventoryMove() {
        super(WurstplusCategory.WURSTPLUS_MOVEMENT);
        this.name = "Inventory Move";
        this.tag = "InventoryMove";
        this.description = "move in guis";
        
    }

	private static final KeyBinding[] KEYS = new KeyBinding[]{mc.gameSettings.keyBindForward, mc.gameSettings.keyBindRight, mc.gameSettings.keyBindBack, mc.gameSettings.keyBindLeft, mc.gameSettings.keyBindJump, mc.gameSettings.keyBindSprint};
	int JUMP                         = mc.gameSettings.keyBindJump.getKeyCode();

	@EventHandler
	public Listener<WurstplusEventGUIScreen.Displayed> listener = new Listener<>(event -> {
		if (mc.currentScreen instanceof GuiChat || mc.currentScreen == null) {
			return;
		}

		walk();
	});

	@Override
	public void update() {
		if (mc.currentScreen instanceof GuiChat || mc.currentScreen == null) {
			return;
		}

		mc.player.rotationYaw  += Keyboard.isKeyDown(205) ? 4.0f : (Keyboard.isKeyDown(203) ? -4.0f : 0.0f);
		mc.player.rotationPitch = (float) (mc.player.rotationPitch + (Keyboard.isKeyDown(208) ? 4 : (Keyboard.isKeyDown(200) ? -4 : 0)) * 0.75);
		mc.player.rotationPitch = MathHelper.clamp(mc.player.rotationPitch, - 90.0f, 90.0f);

		if (Keyboard.isKeyDown(JUMP)) {
			if (mc.player.isInLava() || mc.player.isInWater()) {
				mc.player.motionY += 0.38f;
			} else {
				if (mc.player.onGround) {
					mc.player.jump();
				}
			}
		}

		walk();
	}

	public void walk() {
		KeyBinding[] keys = KEYS;

		int keys_n   = keys.length;
		int keys_n_2 = 0;

		while (keys_n_2 < keys_n) {
			KeyBinding key_binding = keys[keys_n_2];

			if (Keyboard.isKeyDown(key_binding.getKeyCode())) {
				if (key_binding.getKeyConflictContext() != KeyConflictContext.UNIVERSAL) {
					key_binding.setKeyConflictContext(KeyConflictContext.UNIVERSAL);
				}

				KeyBinding.setKeyBindState(key_binding.getKeyCode(), true);
			} else {
				KeyBinding.setKeyBindState(key_binding.getKeyCode(), false);
			}

			++keys_n_2;
		}
	}
}