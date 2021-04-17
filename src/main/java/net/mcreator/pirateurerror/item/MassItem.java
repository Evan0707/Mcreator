
package net.mcreator.pirateurerror.item;

@PirateurErrorModElements.ModElement.Tag
public class MassItem extends PirateurErrorModElements.ModElement {

	@ObjectHolder("pirateur_error:mass")
	public static final Item block = null;

	public MassItem(PirateurErrorModElements instance) {
		super(instance, 5);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxDamage(1800).rarity(Rarity.EPIC));
			setRegistryName("mass");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Masse de l'ogre"));
		}

	}

}
