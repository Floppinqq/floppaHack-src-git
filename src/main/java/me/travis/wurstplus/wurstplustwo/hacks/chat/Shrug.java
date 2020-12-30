package me.travis.wurstplus.wurstplustwo.hacks.chat;

// Default Imports
import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

// Set the extend
public class Shrug extends WurstplusHack {

    /** ________________________________________
     *                                         |
     * @Author <Yoink/<Katatje>                |
     * @12/29/2020 - <floppaHack by Floppinqq> |
     *                                         |
     * ________________________________________|
     */

    public Shrug() {
        // Info
        super(WurstplusCategory.WURSTPLUS_CHAT);
        this.name = ChatFormatting.RED + "Shrug";
        this.tag = "Shrug";
        this.description = "best module ngl";
    }
    // Code.
    public boolean allowUsageWithoutPrefix(ICommandSender sender, String message)
    {
        return false;
    }
    public String getName()
    {
        return "shrug";
    }

    public String getUsage(ICommandSender sender)
    {
        return "/shrug";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args)
    {
        StringBuilder message = new StringBuilder();

        for (String s : args)
        {
            message.append(s).append(" ");
        }

        message.append(" \u00AF\\_(\u30C4)_/\u00AF");

        Minecraft.getMinecraft().player.sendChatMessage(message.toString());
    }

}
