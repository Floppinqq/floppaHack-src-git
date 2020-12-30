package me.travis.wurstplus.wurstplustwo.hacks.memes;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class TrueDurability extends WurstplusHack {
    private static TrueDurability instance;

    public TrueDurability() {
        super(WurstplusCategory.WURSTPLUS_MEMES);
        this.name = ChatFormatting.RED + "TrueDurabilityHUD";
        this.tag = "TrueDurabilityHUD";
        this.description = "TrueDurabilityHUD";
    }
    public static TrueDurability getInstance() {
        if (TrueDurability.instance == null) {
            TrueDurability.instance = new TrueDurability();
        }
        return TrueDurability.instance;
    }

}
