package xyz.jamesbcyber.delightful_compatibility.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * Credits to Vazkii and team for some references on mass-reading blocks to datagen!
 */
public class DCItemModels extends ItemModelProvider
{
	public DCItemModels(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
		super(output, modid, existingFileHelper);
	}

	@Override
	protected void registerModels() {

	}

	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated")).texture("layer0",
				ResourceLocation.fromNamespaceAndPath(item.getId().getNamespace(),"item/" + item.getId().getPath()));
	}
}