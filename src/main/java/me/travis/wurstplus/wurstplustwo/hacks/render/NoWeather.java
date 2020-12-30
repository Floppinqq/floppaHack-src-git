package me.travis.wurstplus.wurstplustwo.hacks.render;

import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class NoWeather extends WurstplusHack {
	
	
    public NoWeather() {
	
    super(WurstplusCategory.WURSTPLUS_RENDER);
    
	this.name        = "No Weather";
	this.tag         = "NoWeather";
	this.description = "Disables weather render";
	
    }
	
    @Override
    public void update() {
        if (mc.world == null) {
            return;
        }
        if (mc.world.isRaining()) {
            mc.world.setRainStrength(0.0f);
        }
        if (mc.world.isThundering()) {
            mc.world.setThunderStrength(0.0f);
        }
    }
}
