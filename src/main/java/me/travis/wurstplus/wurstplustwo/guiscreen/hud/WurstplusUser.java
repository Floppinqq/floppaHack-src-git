package me.travis.wurstplus.wurstplustwo.guiscreen.hud;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.FloppaHack;
import me.travis.wurstplus.wurstplustwo.guiscreen.render.WurstplusDraw;
import me.travis.wurstplus.wurstplustwo.guiscreen.render.pinnables.WurstplusPinnable;
import me.travis.wurstplus.wurstplustwo.util.WurstplusTimeUtil;
import net.minecraft.util.math.MathHelper;


public class WurstplusUser extends WurstplusPinnable {
	public WurstplusUser() {
		super("Welcomer", "User", 1, 0, 0);
	}

	private int scaled_width;
	private int scaled_height;
	private int scale_factor;

	@Override
	public void render() {
		updateResolution();
		int nl_r = FloppaHack.get_setting_manager().get_setting_with_tag("HUD", "HUDStringsColorR").get_value(1);
		int nl_g = FloppaHack.get_setting_manager().get_setting_with_tag("HUD", "HUDStringsColorG").get_value(1);
		int nl_b = FloppaHack.get_setting_manager().get_setting_with_tag("HUD", "HUDStringsColorB").get_value(1);
		int nl_a = FloppaHack.get_setting_manager().get_setting_with_tag("HUD", "HUDStringsColorA").get_value(1);

		int time = WurstplusTimeUtil.get_hour();
		String line;

		if (time >= 0 && time < 12) {
			line = "Welcome to floppaHack " + ChatFormatting.RED + ChatFormatting.BOLD + mc.player.getName() + ChatFormatting.YELLOW + ChatFormatting.BOLD + ", you looks good :^)";
		} else if (time >= 12 && time < 16) {
			line = "Howdy, nice day to you, " + ChatFormatting.RED + ChatFormatting.BOLD +  mc.player.getName() + ChatFormatting.RESET + ChatFormatting.GREEN + " :^)";
		} else if (time >= 16 && time < 24) {
			line = "Heyy " + ChatFormatting.RED + ChatFormatting.BOLD +  mc.player.getName() + ChatFormatting.LIGHT_PURPLE + ", how are you? :^)";
		} else {
			line = "Welcome, " + ChatFormatting.RED + ChatFormatting.BOLD +  mc.player.getName();
		}

		mc.fontRenderer.drawStringWithShadow(line, scaled_width / 2f - mc.fontRenderer.getStringWidth(line) / 2f, 20f, new WurstplusDraw.TravisColor(nl_r,nl_g,nl_b,nl_a).hex());

		this.set_width(this.get(line, "width") + 2);
		this.set_height(this.get(line, "height") + 2);
	}

	public void updateResolution() {
		this.scaled_width = mc.displayWidth;
		this.scaled_height = mc.displayHeight;
		this.scale_factor = 1;
		final boolean flag = mc.isUnicode();
		int i = mc.gameSettings.guiScale;
		if (i == 0) {
			i = 1000;
		}
		while (this.scale_factor < i && this.scaled_width / (this.scale_factor + 1) >= 320 && this.scaled_height / (this.scale_factor + 1) >= 240) {
			++this.scale_factor;
		}
		if (flag && this.scale_factor % 2 != 0 && this.scale_factor != 1) {
			--this.scale_factor;
		}
		final double scaledWidthD = this.scaled_width / (double)this.scale_factor;
		final double scaledHeightD = this.scaled_height / (double)this.scale_factor;
		this.scaled_width = MathHelper.ceil(scaledWidthD);
		this.scaled_height = MathHelper.ceil(scaledHeightD);
	}

}