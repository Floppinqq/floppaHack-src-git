package me.travis.wurstplus.wurstplustwo.hacks.chat;

import me.travis.wurstplus.FloppaHack;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;

import java.util.Random;

// Zero alpine manager.


public class YakGodChatSuffix extends WurstplusHack {
	public YakGodChatSuffix() {
		super(WurstplusCategory.WURSTPLUS_CHAT);

		this.name        = "YakGodSuffix";
		this.tag         = "YGChatSuffix";
		this.description = "yakgod.cc chatsuffix lol.";
	}

	WurstplusSetting ignore = create("Commands", "ChatSuffixCommands", true);
	WurstplusSetting type   = create("Type", "ChatSuffixType", "Default", combobox("Yak", "Dumb"));

	boolean accept_suffix;
	boolean suffix_yak;
	boolean suffix_dumb;


	StringBuilder suffix;


	String[] random_client_pre = {
			"yak",
			"yak",
			"yak"
	};

	String[] random_client_mid = {
			"hak",
			"client",
			"clone",
			"dead",
			"plus",
			"doored",
			"elite",
			"fag",
			"fork",
			"god",
			"green",
			"grid",
			"grind",
			"hack",
			"hacks",
			"hax",
			"kek",
			"krypt",
			"lag",
			"land",
			"leak",
			"life",
			"memed",
			"mule",
			"net",
			"nut",
			"punch",
			"rat",
			"skid",
			"top"
	};

	String[] random_client_domain = {
			".cc",
			".edu",
			".eu",
			".ez",
			".gay",
			".gg",
			".in",
			".ru"
	};

	@EventHandler
	private final Listener<WurstplusEventPacket.SendPacket> listener = new Listener<>(event -> {
		// If not be the CPacketChatMessage return.
		if (!(event.get_packet() instanceof CPacketChatMessage)) {
			return;
		}

		// Start event suffix.
		accept_suffix = true;

		// Get value.
		boolean ignore_prefix = ignore.get_value(true);

		String message = ((CPacketChatMessage) event.get_packet()).getMessage();
		String prefix = "";
		String withPrefix = prefix + message;

		// If is with some character.
		if (message.startsWith("/")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith("\\") && ignore_prefix) accept_suffix = false;
		if (message.startsWith("!")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith(":")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith(";")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith(".")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith(",")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith("@")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith("&")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith("*")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith("$")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith("#")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith("(")  && ignore_prefix) accept_suffix = false;
		if (message.startsWith(")")  && ignore_prefix) accept_suffix = false;

		// green or no

		// Compare the values type.
		if (type.in("Yak")) {
			suffix_yak = true;
			suffix_dumb = false;
		}

		if (type.in("Dumb")) {
			suffix_yak = false;
			suffix_dumb = true;
		}

		// If accept.
		if (accept_suffix) {
			if (suffix_yak) {
				// Just default.
				 message += FloppaHack.FLOPPAHACK_SIGN + convert_base("yakgod.cc");
			}

			if (suffix_dumb) {
				 message += FloppaHack.FLOPPAHACK_SIGN + " \u23d0 \uff10\uff12\uff17\uff28\uff41\uff43\uff4b \u23d0 \u1d00\u1d18\u1d0f\u029f\u029f\u028f\u1d0f\u0274 \u23d0 \u1d00\u1d04\u1d07 \u029c\u1d00\u1d04\u1d0b \u23d0 \u0299\u1d00\u1d04\u1d0b\u1d05\u1d0f\u1d0f\u0280\u1d07\u1d05 \u23d0 \u0299\u1d00\u029f\u1d05\u029c\u1d00\u1d04\u1d0b \u23d0 \u1d07\u029f\u1d07\u1d0d\u1d07\u0274\u1d1b\u1d00\ua731\uff0e\u1d04\u1d0f\u1d0d \u23d0 \u0493\u1d1c\u0280\u0280\u028f\u1d21\u1d00\u0280\u1d07 \u23d0 \u0262\u1d00\u028f \u23d0 \u041d\u03b5\u13ae\u043d\u15e9\u03b5\u0455\u01ad\u03c5\u0455 \u23d0 \u1d0b\u1d07\u1d07\u1d0d\u028f\uff0e\u1d04\u1d04\u30c4 \u23d0 \u1d0d\u028f\u0455\u1d1b\u026a\u1d04.\u1d04\u1d04 \u23d0 \u0274\u1d1c\u1d1b\u0262\u1d0f\u1d05\uff0e\u1d04\u1d04 \u0fc9 \u23d0 \uff30\uff25\uff2e\uff29\uff33 \u23d0 \u1d18\u029c\u1d0f\u0299\u1d0f\u0455.\u1d07\u1d1c \u23d0 \uff30\uff4c\uff49\uff56\uff49\uff44\uff0e\uff43\uff43 \u23d0 \u02b3\u1d58\u02e2\u02b0\u1d49\u02b3\u02b0\u1d43\u1d9c\u1d4f \u23d0 \u0455\u026a\u0274\u0262\u1d1c\u029f\u1d00\u0280\u026a\u1d1b\u028f\u029c\u1d00\u1d04\u1d0b\u2122 \u23d0 \u0e23\u0e4f\u0e22\u05e7\u0452\u0e04\u03c2\u043a \u23d0 \u1d1b\u0280\u026a\u1d18\u029f\ua731\u02e2\u026a\u02e3 \u23d0 \u166d\uff4f\u1587\uff0d\u1455\u14aa\uff49\u4e47\u144e\u3112";
			}

			// If message 256 string length substring.
			if (message.length() >= 256) {
				message.substring(0, 256);
			}
		}

		// Send the message.
		((CPacketChatMessage) event.get_packet()).message = message;
	});

	// Get the random values string.
	public String random_string(String[] list) {
		return list[new Random().nextInt(list.length)];
	}

	// Convert the base using the TravisFont.
	public String convert_base(String base) {
		return FloppaHack.smoth(base);
	}

	@Override
	public String array_detail() {
		// Update the detail.
		return this.type.get_current_value();
	}
}