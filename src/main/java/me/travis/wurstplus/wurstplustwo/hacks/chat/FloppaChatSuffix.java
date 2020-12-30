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


public class FloppaChatSuffix extends WurstplusHack {
	public FloppaChatSuffix() {
		super(WurstplusCategory.WURSTPLUS_CHAT);

		this.name        = "Floppa Suffix";
		this.tag         = "FSuffix";
		this.description = "show off how cool u are";
	}

	WurstplusSetting ignore = create("AllowCommands", "ChatSuffixIgnore", true);
	WurstplusSetting green = create("Green", "GreenSuffix", false);
	WurstplusSetting type   = create("Type", "ChatSuffixType", "Default", combobox("Default", "Random", "Cool", "Floppaware"));

	boolean accept_suffix;
	boolean suffix_default;
	boolean suffix_random;
	boolean suffix_cool;
	boolean suffix_floppaware;


	StringBuilder suffix;


	String[] random_client_name = {
		"floppahack"
	};

	String[] random_client_finish = {
		".cc",
		" strong",
		" antibingus",
		" nigga killer",
			" leaked by ccc",
			".qq",
			" childesp update"
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
		String s = prefix + message;

		if (green.get_value(true)) {
			prefix = "> ";
		}

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
			suffix_floppaware = false;
		}

		if (type.in("Random")) {
			suffix_default = false;
			suffix_random  = true;
			suffix_cool = false;
			suffix_floppaware = false;
		}
		if (type.in("Cool")) {
			suffix_default = false;
			suffix_random  = false;
			suffix_floppaware = false;
			suffix_cool = true;

		}
		if (type.in("Floppaware")) {
			suffix_default = false;
			suffix_random  = false;
			suffix_cool = false;
			suffix_floppaware = true;
		}

		// If accept.
		if (accept_suffix) {
			if (suffix_default) {
				// Just default.
				 s += FloppaHack.FLOPPAHACK_SIGN + convert_base("floppahack");
			}

			if (suffix_random) {
				// Create first the string builder.
				StringBuilder suffix_with_randoms = new StringBuilder();

				// Convert the base using the TravisFont.
				suffix_with_randoms.append(convert_base(random_string(random_client_name)));
				suffix_with_randoms.append(convert_base(random_string(random_client_finish)));

				s += FloppaHack.FLOPPAHACK_SIGN + suffix_with_randoms.toString();
			}

			if (suffix_cool) {
				 s += FloppaHack.FLOPPAHACK_SIGN + convert_base("floppahack bingus flopper");
			}

			if (suffix_floppaware) {
				s += FloppaHack.FLOPPAHACK_SIGN + convert_base("floppaware");
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