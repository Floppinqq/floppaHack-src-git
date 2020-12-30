package com.veteran.hack.event;

import me.travis.wurstplus.wurstplustwo.util.ZoriWrapper;
import me.zero.alpine.type.Cancellable;

public class MinecraftEvent extends Cancellable
{
    private Era era;
    private final float partialTicks;

    public MinecraftEvent() {
        this.era = Era.PRE;
        this.partialTicks = ZoriWrapper.mc.getRenderPartialTicks();
    }

    public MinecraftEvent(final Era p_Era) {
        this.era = Era.PRE;
        this.partialTicks = ZoriWrapper.mc.getRenderPartialTicks();
    }

    public Era getEra() {
        return this.era;
    }

    public float getPartialTicks() {
        return this.partialTicks;
    }

    public enum Era
    {
        PRE,
        PERI,
        POST;
    }
}