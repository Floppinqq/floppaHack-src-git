package me.travis.wurstplus.wurstplustwo.hacks.memes;

// Default Imports
import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

// Set the extend
public class NoEntityTrace extends WurstplusHack {

    // make the module be set

    public NoEntityTrace() {
        // Info
        super(WurstplusCategory.WURSTPLUS_BETA);
        this.name = ChatFormatting.RED + "NoEntityTrace";
        this.tag = "NoEntityTrace";
        this.description = "adw";
    }
    // Code.
    public static boolean shouldBlock() {
        return false;
    }

}
