package xyz.jamesbcyber.delightful_compatibility.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import xyz.jamesbcyber.delightful_compatibility.Delightful_compatibility;

@Mod.EventBusSubscriber(modid = Delightful_compatibility.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DCCommands {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        LiteralArgumentBuilder<CommandSourceStack> baseCommand = Commands.literal("delightful");
        if (ModList.get().isLoaded("ers")) {
            ErsCommands.register(baseCommand);
        }

        dispatcher.register(baseCommand);
    }

}
