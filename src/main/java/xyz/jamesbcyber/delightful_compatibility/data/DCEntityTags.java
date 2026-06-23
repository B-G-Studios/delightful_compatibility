package xyz.jamesbcyber.delightful_compatibility.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class DCEntityTags extends EntityTypeTagsProvider
{
	public DCEntityTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modid, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, modid, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {

	}
}
