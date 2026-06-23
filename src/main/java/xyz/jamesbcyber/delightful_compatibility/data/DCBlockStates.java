package xyz.jamesbcyber.delightful_compatibility.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DCBlockStates extends BlockStateProvider
{

	public DCBlockStates(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
		super(output, modid, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {

	}

}
