package xyz.jamesbcyber.delightful_compatibility.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DCBlockTags extends BlockTagsProvider
{

	public DCBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.registerModTags();
		this.registerMinecraftTags();
		this.registerForgeTags();
		this.registerCompatibilityTags();

		this.registerBlockMineables();
	}

	protected void registerBlockMineables() {

	}

	protected void registerMinecraftTags() {

	}

	protected void registerForgeTags() {

	}

	protected void registerModTags() {

	}

	private void registerCompatibilityTags() {

	}
}
