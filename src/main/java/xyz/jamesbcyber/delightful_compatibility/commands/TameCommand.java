package xyz.jamesbcyber.delightful_compatibility.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;

public class TameCommand {
    private static final String TARGETS = "targets";

    public static void registerSubCommands(LiteralArgumentBuilder<CommandSourceStack> baseCommand) {
        baseCommand.then(Commands.literal("tame")
                .then(Commands.argument(TARGETS, EntityArgument.entities())
                        .executes(TameCommand::tameAny))
        );
    }

    public static int tameAny(CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        if (ctx.getSource().getEntity() instanceof Player player) {
            int tamedCounter = 0;
            for (Entity entity : EntityArgument.getEntities(ctx, TARGETS)) {
                if (entity instanceof TamableAnimal){
                    ((TamableAnimal) entity).tame(player);
                    tamedCounter++;
                }
            }
            player.sendSystemMessage(Component.translatable("delightful.commands.tame_response", tamedCounter));
        }

        return Command.SINGLE_SUCCESS;
    }
}
