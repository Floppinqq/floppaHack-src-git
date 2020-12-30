//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.hacks.chat;

import java.util.Random;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class AutoExcuse extends WurstplusHack
{
    int diedTime;
    
    public AutoExcuse() {
        super(WurstplusCategory.WURSTPLUS_CHAT);
        this.diedTime = 0;
        this.name = "Auto Cope";
        this.tag = "AutoExcuse";
        this.description = "tell people why you died";
    }
    
    @Override
    public void update() {
        if (this.diedTime > 0) {
            --this.diedTime;
        }
        if (AutoExcuse.mc.player.isDead) {
            this.diedTime = 500;
        }
        if (!AutoExcuse.mc.player.isDead && this.diedTime > 0) {
            final Random rand = new Random();
            final int randomNum = rand.nextInt(10) + 1;
            if (randomNum == 1) {
                AutoExcuse.mc.player.sendChatMessage("you win because you are a pingplayer :(");
            }
            if (randomNum == 2) {
                AutoExcuse.mc.player.sendChatMessage("i was in my hacker console :(");
            }
            if (randomNum == 3) {
                AutoExcuse.mc.player.sendChatMessage("bro im good i was testing settings :(");
            }
            if (randomNum == 5) {
                AutoExcuse.mc.player.sendChatMessage("i got desynced :(");
            }
            if (randomNum == 6) {
                AutoExcuse.mc.player.sendChatMessage("why you killed me");
            }
            if (randomNum == 7) {
                AutoExcuse.mc.player.sendChatMessage("i was looking into my 69 modules hack :(");
            }
            if (randomNum == 8) {
                AutoExcuse.mc.player.sendChatMessage("i was afk bruhh");
            }
            if (randomNum == 9) {
                AutoExcuse.mc.player.sendChatMessage("dont say ez, its cringe");
            }
            if (randomNum == 10) {
                AutoExcuse.mc.player.sendChatMessage("i promise i tryied, but lags make that harder");
            }
            this.diedTime = 0;
        }
    }
}
