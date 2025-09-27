package xyz.jamesbcyber.delightful_compatibility.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommandsRegister {

    @SubscribeEvent
    public static void RegisterCommands(RegisterCommandsEvent event){
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        DumpNamespaceCommand.register(dispatcher);
        TestCommands.register(dispatcher);

    }
}
