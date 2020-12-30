package me.travis.wurstplus.wurstplustwo.hacks.render;

// Default Imports
import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

// Set the extend
public class NoHurtCamDEV extends WurstplusHack {

    // make the module be set

    public NoHurtCamDEV() {
        // Info
        super(WurstplusCategory.WURSTPLUS_MEMES);
        this.name = ChatFormatting.RED + "NoChat";
        this.tag = "nc";
        this.description = "aaaaaaaaaaaaaaaaaaaaaa";
        NoHurtCamDEV.INSTANCE = this;
    }
    // Code.
    private static NoHurtCamDEV INSTANCE;

    public static boolean shouldDisable() {
        return NoHurtCamDEV.INSTANCE != null && NoHurtCamDEV.INSTANCE.is_active();
    }

}
