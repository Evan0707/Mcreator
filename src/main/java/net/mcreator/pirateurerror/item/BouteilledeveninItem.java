
package net.mcreator.pirateurerror.item;

@PirateurErrorModElements.ModElement.Tag
public class BouteilledeveninItem extends PirateurErrorModElements.ModElement {

	@ObjectHolder("pirateur_error:bouteilledevenin")
	public static final Item block = null;

	public BouteilledeveninItem(PirateurErrorModElements instance) {
		super(instance, 10);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("bouteilledevenin");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
