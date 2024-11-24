package net.kofeychi.Modularity.base;
/*
 * ModularityAPI
 * Copyright (c) 2024. Kofeychi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import com.mojang.brigadier.arguments.*;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.kofeychi.Modularity.API.BaseAPI;
import net.kofeychi.Modularity.Networking.Networking;
import net.kofeychi.Modularity.Registry.Registry;
import net.kofeychi.Modularity.Registry.ShakePacket;
import net.kofeychi.Modularity.ScreenShake.ScreenShakeModule;
import net.kofeychi.Modularity.Util.Utils;
import net.kofeychi.Modularity.Loader.Addon;
import net.kofeychi.Modularity.Loader.Loader;
import net.kofeychi.Modularity.logger.ModularityLogger;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;
import net.minecraft.util.math.Vec3d;
@SuppressWarnings("All")
@MethodsReturnNonnullByDefault
public class Modularity implements ModInitializer {
	public static final String MODID = "modularity";

	// MODULARITY ADDON LOADER MAIN INFO
	public static String ID = "Modularity";
	public static String VERSION = "V1.0 BETA";
	public static String MainMethod = "Setup";
	public static void Setup(Boolean n) {}
	// MODULARITY ADDON LOADER MAIN INFO

	// MODULARITY CONSTANTS
	public static boolean isDevelopment = true;//FabricLoader.getInstance().isDevelopmentEnvironment();

	public static MinecraftServer Server;
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTING.register(server -> Modularity.Server = server);
		ServerLifecycleEvents.SERVER_STOPPING.register(server -> Modularity.Server = null);
		PayloadTypeRegistry.playS2C().register(ShakePacket.ShakePayload.ID, ShakePacket.ShakePayload.CODEC);
		PayloadTypeRegistry.playS2C().register(ShakePacket.PosShakePayload.ID, ShakePacket.PosShakePayload.CODEC);
		try {
			Loader.AddonList.add(new Addon(Modularity.class));
			Loader.AddonList.add(new Addon(ModularityLogger.class));
			Loader.AddonList.add(new Addon(Loader.class));
			Loader.AddonList.add(new Addon(BaseAPI.class));
			Loader.AddonList.add(new Addon(Utils.class));
			Loader.AddonList.add(new Addon(Registry.class));
			Loader.AddonList.add(new Addon(Networking.class));
			Loader.AddonList.add(new Addon(ScreenShakeModule.class));
		} catch (NoSuchFieldException | IllegalAccessException ignored) {
		}
		Loader.INIT();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		if (isDevelopment) {
			CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
				dispatcher.register(CommandManager.literal("modularity").requires(source -> source.hasPermissionLevel(1))
						.then(CommandManager.literal("shake").requires(source -> source.hasPermissionLevel(1))
								.then(CommandManager.literal("normal").requires(source -> source.hasPermissionLevel(1))
										.then(CommandManager.argument("Duration", IntegerArgumentType.integer())
												.then(CommandManager.argument("Intensivity1", FloatArgumentType.floatArg())
														.then(CommandManager.argument("Intensivity2", FloatArgumentType.floatArg())
																.then(CommandManager.argument("Intensivity3", FloatArgumentType.floatArg())
																		.then(CommandManager.argument("EasingIn", StringArgumentType.string()).suggests(new EasingSuggestionProvider())
																				.then(CommandManager.argument("EasingOut", StringArgumentType.string()).suggests(new EasingSuggestionProvider())
																						.then(CommandManager.argument("UsePerlin", BoolArgumentType.bool())
																								.then(CommandManager.argument("mode", IntegerArgumentType.integer(0, 1))
																										.then(CommandManager.argument("isRot", BoolArgumentType.bool())
																												.then(CommandManager.argument("isPos", BoolArgumentType.bool())
																														.then(CommandManager.argument("ps", DoubleArgumentType.doubleArg())
																												.executes(Modularity::CMD)))))))))))))
								.then(CommandManager.literal("positional").requires(source -> source.hasPermissionLevel(1))
										.then(CommandManager.argument("Duration", IntegerArgumentType.integer())
												.then(CommandManager.argument("POS", Vec3ArgumentType.vec3())
														.then(CommandManager.argument("falloffDistance", FloatArgumentType.floatArg())
																.then(CommandManager.argument("maxDistance", FloatArgumentType.floatArg())
																		.then(CommandManager.argument("Easing", StringArgumentType.string()).suggests(new EasingSuggestionProvider())
																				.then(CommandManager.argument("Intensivity1", FloatArgumentType.floatArg())
																						.then(CommandManager.argument("Intensivity2", FloatArgumentType.floatArg())
																								.then(CommandManager.argument("Intensivity3", FloatArgumentType.floatArg())
																										.then(CommandManager.argument("EasingIn", StringArgumentType.string()).suggests(new EasingSuggestionProvider())
																												.then(CommandManager.argument("EasingOut", StringArgumentType.string()).suggests(new EasingSuggestionProvider())
																														.then(CommandManager.argument("UsePerlin", BoolArgumentType.bool())
																																.then(CommandManager.argument("mode", IntegerArgumentType.integer(0, 1))
																																		.then(CommandManager.argument("isRot", BoolArgumentType.bool())
																																				.then(CommandManager.argument("isPos", BoolArgumentType.bool())
																																						.then(CommandManager.argument("ps", DoubleArgumentType.doubleArg())
																																				.executes(Modularity::POSCMD)))))))))))))))))
						));
			});
		}
	}
	public static int POSCMD(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		int dur = IntegerArgumentType.getInteger(context,"Duration");
		Vec3d pos = Vec3ArgumentType.getVec3(context,"POS");
		float falloffDistance = FloatArgumentType.getFloat(context,"falloffDistance");
		float maxDistance = FloatArgumentType.getFloat(context,"maxDistance");
		String e = StringArgumentType.getString(context,"Easing");
		float i1 = FloatArgumentType.getFloat(context,"Intensivity1")/10;
		float i2 = FloatArgumentType.getFloat(context,"Intensivity2")/10;
		float i3 = FloatArgumentType.getFloat(context,"Intensivity3")/10;
		String e1 = StringArgumentType.getString(context,"EasingIn");
		String e2 = StringArgumentType.getString(context,"EasingOut");
		boolean p = BoolArgumentType.getBool(context,"UsePerlin");
		int mode = IntegerArgumentType.getInteger(context,"mode");
		boolean isrot = BoolArgumentType.getBool(context,"isRot");
		boolean ispos = BoolArgumentType.getBool(context,"isPos");
		float ps = (float) DoubleArgumentType.getDouble(context,"ps")/10;
		BaseAPI.ScreenShakeAPI.SendPosToAllPlayers(dur,pos,falloffDistance,maxDistance,e,i1,i2,i3,e1,e2,p,mode,isrot,ispos,ps);
		return 1;
	}
	public static int CMD(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		int dur = IntegerArgumentType.getInteger(context,"Duration");
		float i1 = FloatArgumentType.getFloat(context,"Intensivity1")/10;
		float i2 = FloatArgumentType.getFloat(context,"Intensivity2")/10;
		float i3 = FloatArgumentType.getFloat(context,"Intensivity3")/10;
		String e1 = StringArgumentType.getString(context,"EasingIn");
		String e2 = StringArgumentType.getString(context,"EasingOut");
		boolean p = BoolArgumentType.getBool(context,"UsePerlin");
		int mode = IntegerArgumentType.getInteger(context,"mode");
		boolean isrot = BoolArgumentType.getBool(context,"isRot");
		boolean ispos = BoolArgumentType.getBool(context,"isPos");
		float ps = (float) DoubleArgumentType.getDouble(context,"ps")/10;
		BaseAPI.ScreenShakeAPI.SendNormalToAllPlayers(dur,i1,i2,i3,e1,e2,p,mode,isrot,ispos,ps);
		return 1;
	}
}