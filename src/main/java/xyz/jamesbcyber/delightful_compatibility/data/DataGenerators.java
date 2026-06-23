package xyz.jamesbcyber.delightful_compatibility.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.jamesbcyber.delightful_compatibility.Delightful_compatibility;
import xyz.jamesbcyber.delightful_compatibility.data.loot.DCBlockLoot;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Delightful_compatibility.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
	public static String modID = Delightful_compatibility.MODID;
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		DCBlockTags blockTags = new DCBlockTags(output, lookupProvider, modID, helper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeServer(), new DCItemTags(output, lookupProvider, blockTags.contentsGetter(), modID, helper));
		generator.addProvider(event.includeServer(), new DCEntityTags(output, lookupProvider, modID, helper));
		generator.addProvider(event.includeServer(), new DCRecipes(output));
		generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(
				new LootTableProvider.SubProviderEntry(DCBlockLoot::new, LootContextParamSets.BLOCK)
		)));

		DCBlockStates blockStates = new DCBlockStates(output, modID, helper);
		generator.addProvider(event.includeClient(), blockStates);
		generator.addProvider(event.includeClient(), new DCItemModels(output, modID, blockStates.models().existingFileHelper));
	}
}
