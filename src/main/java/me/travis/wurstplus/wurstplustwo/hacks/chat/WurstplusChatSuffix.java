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


public class WurstplusChatSuffix extends WurstplusHack {
	public WurstplusChatSuffix() {
		super(WurstplusCategory.WURSTPLUS_CHAT);

		this.name        = "Chat Suffix";
		this.tag         = "ChatSuffix";
		this.description = "show off how cool u are";
	}

	WurstplusSetting ignore = create("Ignore", "ChatSuffixIgnore", true);
	WurstplusSetting type   = create("Type", "ChatSuffixType", "Default", combobox("Default", "Random", "Cool"));

	boolean accept_suffix;
	boolean suffix_default;
	boolean suffix_random;
	boolean suffix_cool;


	StringBuilder suffix;


	String[] random_client_name = {
		"floppahack"
	};

	String[] random_client_finish = {
		".cc",
		" strong",
		" best edition",
		" nigga killer",
			" bbc edition",
			" auto groom update",
			" anti bingus update"
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
		String prefix = "> ";
		String s = prefix + message;

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

		// Compare the values type.
		if (type.in("Default")) {
			suffix_default = true;
			suffix_cool = false;
			suffix_random  = false;
		}

		if (type.in("Random")) {
			suffix_default = false;
			suffix_random  = true;
			suffix_cool = false;
		}
		if (type.in("Cool")) {
			suffix_default = false;
			suffix_random  = false;
			suffix_cool = true;
		}

		// If accept.
		if (accept_suffix) {
			if (suffix_default) {
				// Just default.
				 message += FloppaHack.FLOPPAHACK_SIGN + convert_base("floppahack");
			}

			if (suffix_random) {
				// Create first the string builder.
				StringBuilder suffix_with_randoms = new StringBuilder();

				// Convert the base using the TravisFont.
				suffix_with_randoms.append(convert_base(random_string(random_client_name)));
				suffix_with_randoms.append(convert_base(random_string(random_client_finish)));

				message += FloppaHack.FLOPPAHACK_SIGN + suffix_with_randoms.toString();
			}

			if (suffix_cool) {
				 message += FloppaHack.FLOPPAHACK_SIGN + convert_base("floppahack bingus flopper");
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