package xyz.jamesbcyber.delightful_compatibility.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class DCItemTags extends ItemTagsProvider
{
	public DCItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTagProvider, String modID, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, provider, blockTagProvider, modID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.registerMinecraftTags();
		this.registerModTags();
		this.registerForgeTags();
		this.registerCompatibilityTags();
	}

	private void registerMinecraftTags() {

	}

	private void registerModTags() {

	}

	private void registerForgeTags() {

	}

	public void registerCompatibilityTags() {

	}
}
