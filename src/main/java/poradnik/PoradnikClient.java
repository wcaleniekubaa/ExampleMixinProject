package poradnik;

import net.minecraft.client.*;
import org.apache.logging.log4j.*;

public class PoradnikClient {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Minecraft mc = Minecraft.getMinecraft();
	public static void init() {
		LOGGER.info("Client is initializing");
	}
	public static void start() {
		LOGGER.info("Client is starting");
	}
	public static void shutdown() {
		LOGGER.info("Client is shutdown");
	}
}
