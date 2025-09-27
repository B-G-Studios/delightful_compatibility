package xyz.jamesbcyber.delightful_compatibility.commands;

import net.minecraft.network.chat.Component;
import xyz.jamesbcyber.delightful_compatibility.Utils.FileHandling;
import xyz.jamesbcyber.delightful_compatibility.Utils.JsonFormatting;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DumpNamespaceCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("dumpnamespace").executes(DumpNamespaceCommand::execute));
    }

//    public static Set<String> getItemNamespaces() {
//        Set<String> namespaces = new HashSet<>();
//        // BuiltInRegistries.ITEM is the registry for all items
//        for (Map.Entry<ResourceKey<Item>, Item> entry : BuiltInRegistries.ITEM.entrySet()) {
//            namespaces.add(resourceLocation.getNamespace());
//        }
//        return namespaces;
//    }
    private static int execute(CommandContext<CommandSourceStack> command){
        if (command.getSource().getEntity() instanceof ServerPlayer player) {
            Set<ResourceLocation> resourceLocations = ForgeRegistries.ITEMS.getKeys();
            Map<String, ArrayList<String>> ResourceMap = new HashMap<>();
            for (ResourceLocation RL : resourceLocations){
                String namespace = RL.getNamespace();
                ResourceMap.putIfAbsent(namespace, new ArrayList<String>());
                ResourceMap.get(namespace).add(RL.getPath());
            }
            String blob = "[";
            for (String namespace : ResourceMap.keySet()) {
                blob = blob + String.format("{\"namespace\" : \"%s\",\n\"items\" : ", namespace);
                blob = blob + JsonFormatting.ArrayToJsonString(ResourceMap.get(namespace));
                blob = blob + "},\n";
            }
            blob = blob + "]";
            blob = blob.replaceAll(",]", "]");

            File logfile = FileHandling.writeFile("Namespace.json", blob);
            if (logfile != null){
                MessageFormatting.sendOpenLogFileMessage(player, logfile.getAbsolutePath(), "Click for Dump");
            } else {
                player.sendSystemMessage(Component.literal("Failed to write file"));
            }
        }
        return Command.SINGLE_SUCCESS;

//        if(command.getSource().getEntity() instanceof ServerPlayer player) {
//            Set<String> itemNamespaces = getItemNamespaces();
//            System.out.println(itemNamespaces);
//            for (String namespace : itemNamespaces) {
//                MessageFormatting.sendClickToCopyMessage(player, "- " + namespace);
//            }
//            return Command.SINGLE_SUCCESS;
//        }
//        return 0;

    }
}
