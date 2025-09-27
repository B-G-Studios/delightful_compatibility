package xyz.jamesbcyber.delightful_compatibility.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.HashSet;
import java.util.Set;

import static xyz.jamesbcyber.delightful_compatibility.commands.MessageFormatting.sendHyperlinkClickToCopyMessage;

public class TestCommands {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("testrichmessage").executes(TestCommands::testrichmessage));
        dispatcher.register(Commands.literal("testlinkmessage").executes(TestCommands::testlinkmessage));
        dispatcher.register(Commands.literal("testlogfile").executes(TestCommands::testlogfile));
    }

    public static Set<String> getItemNamespaces() {
        Set<String> namespaces = new HashSet<>();
        // BuiltInRegistries.ITEM is the registry for all items
        for (ResourceLocation resourceLocation : BuiltInRegistries.ITEM.keySet()) {
            namespaces.add(resourceLocation.getNamespace());
        }
        return namespaces;
    }

    private static int testrichmessage(CommandContext<CommandSourceStack> command){
            ServerPlayer player = command.getSource().getPlayer();
            if (player != null) {
                MessageFormatting.sendClickToCopyMessage(player, "This text was copied!");
            }
            return Command.SINGLE_SUCCESS;
    }

    private static int testlinkmessage(CommandContext<CommandSourceStack> command){
        ServerPlayer player = command.getSource().getPlayer();
        if (player != null) {
            MessageFormatting.sendHyperlinkClickToCopyMessage(player, "This is the hyperlink copied text!");
        }
        return Command.SINGLE_SUCCESS;
    }

    private static int testlogfile(CommandContext<CommandSourceStack> command){
//        ServerPlayer player = command.getSource().getPlayer();
//        if (player != null) {
//            String logFilePath = MessageFormatting.writeHelloWorldToLogFile();
//            MessageFormatting.sendOpenLogFileMessage(player, logFilePath);
//        }
        return Command.SINGLE_SUCCESS;
    }

}
