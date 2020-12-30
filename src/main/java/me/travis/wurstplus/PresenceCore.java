package me.travis.wurstplus;

// Basic Things.
import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;

// Atomic for loop
import java.util.concurrent.atomic.AtomicInteger;

// Core Saver
public class PresenceCore {

    // Set Variables
    public static DiscordRichPresence presence;
    private static DiscordRPC rpc = DiscordRPC.INSTANCE;
    private final Minecraft mc = Minecraft.getMinecraft();
    private static Thread thread;

    // Start
    public void start() {
        final DiscordEventHandlers handlers = new DiscordEventHandlers();
        PresenceCore.rpc.Discord_Initialize("793502166618341376", handlers, true, "");
        /** <Atomic Integer Counter>
         * @auto - thanks by showing me how to do that >:)
         * <Floppinqq - floppaHack>
         * @12/29/2020
                        **/
        AtomicInteger counter = new AtomicInteger(0);
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                counter.getAndIncrement();
                if (counter.get() > 10) counter.set(1);

                /** <Rest of RPC
                 * @Floppinqq <floppaHack
                 * @12/29/2020
                 **/

                PresenceCore.presence.details = "floppaHack Strong";
                PresenceCore.presence.largeImageKey = counter.get() + "";
                PresenceCore.presence.largeImageText = FloppaHack.FLOPPAHACK_NAME + " " + FloppaHack.FLOPPAHACK_VERSION;
                PresenceCore.rpc.Discord_UpdatePresence(PresenceCore.presence);
                (PresenceCore.thread = new Thread(() -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        PresenceCore.rpc.Discord_RunCallbacks();
                        String string = "";
                        StringBuilder sb = new StringBuilder();
                        DiscordRichPresence presence;
                        presence = PresenceCore.presence;
                        presence.details = sb.append(string).toString();
                        PresenceCore.presence.state = "Playing on " + mc.getCurrentServerData().serverIP;
                        PresenceCore.rpc.Discord_UpdatePresence(PresenceCore.presence);
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException ex) {
                        }
                    }
                }, "RPC-Callback-Handler")).start(); //start
            }
        });
    }

    // When disable
    public void stop() {
        DiscordRPC.INSTANCE.Discord_ClearPresence();
        DiscordRPC.INSTANCE.Discord_Shutdown();
    }
    /**@Floppinqq
      @12/29/2020
      @FloppaHack-b1.1
     **/

}