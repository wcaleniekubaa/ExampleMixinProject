package poradnik.mixin;

import net.minecraft.launchwrapper.*;
import org.spongepowered.asm.launch.*;
import org.spongepowered.asm.mixin.*;

import java.io.*;
import java.util.*;

public class Tweaker implements ITweaker {

	private final ArrayList<String> arguments = new ArrayList<String>();

	@Override
	public void acceptOptions(List<String> args, File gameDir, File assetsDir, String version) {
		this.arguments.addAll(args);
		if (gameDir != null) {
			this.arguments.add("--gameDir");
			this.arguments.add(gameDir.getAbsolutePath());
		}
		if (assetsDir != null) {
			this.arguments.add("--assetsDir");
			this.arguments.add(assetsDir.getAbsolutePath());
		}
		if (version != null) {
			this.arguments.add("--version");
			this.arguments.add(version);
		}
	}

	@Override
	public void injectIntoClassLoader(LaunchClassLoader classLoader) {
		MixinBootstrap.init();
		Mixins.addConfiguration("mixins.poradnik.json");
	}

	@Override
	public String getLaunchTarget() {
		return "net.minecraft.client.main.Main";
	}

	@Override
	public String[] getLaunchArguments() {
		return arguments.toArray(new String[0]);
	}
}
