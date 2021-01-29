package net.luis.cave.items.weapons;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.ICrossbowUser;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Crossbow extends ShootableItem implements IVanishable {

	private boolean isLoadingStart = false;
	private boolean isLoadingMiddle = false;

	public Crossbow(Item.Properties propertiesIn) {
		
		super(propertiesIn);
		
	}

	public Predicate<ItemStack> getAmmoPredicate() {
		
		return ARROWS_OR_FIREWORKS;
		
	}

	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		
		return ARROWS;
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		ItemStack itemstack = player.getHeldItem(hand);
		
		if (isCharged(itemstack)) {
			
			fireProjectiles(world, player, hand, itemstack, isChargedCrossbow(itemstack), 1.0F);
			setCharged(itemstack, false);
			return ActionResult.resultConsume(itemstack);
			
		} else if (!player.findAmmo(itemstack).isEmpty()) {
			
			if (!isCharged(itemstack)) {
				
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
				player.setActiveHand(hand);
				
			}

			return ActionResult.resultConsume(itemstack);
			
		} else {
			
			return ActionResult.resultFail(itemstack);
			
		}
		
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity entityLiving, int timeLeft) {
		
		int i = this.getUseDuration(stack) - timeLeft;
		float f = getCharge(i, stack);
		
		if (f >= 1.0F && !isCharged(stack) && hasAmmo(entityLiving, stack)) {
			
			setCharged(stack, true);
			SoundCategory soundcategory = entityLiving instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
			world.playSound((PlayerEntity) null, entityLiving.getPosX(), entityLiving.getPosY(),
					entityLiving.getPosZ(), SoundEvents.ITEM_CROSSBOW_LOADING_END, soundcategory, 1.0F,
					1.0F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
			
		}

	}

	private static boolean hasAmmo(LivingEntity entity, ItemStack stack) {
		
		int enchMultishot = EnchantmentHelper.getEnchantmentLevel(Enchantments.MULTISHOT, stack);
		int j = enchMultishot == 0 ? 1 : 3;
		boolean isCreative = entity instanceof PlayerEntity && ((PlayerEntity) entity).abilities.isCreativeMode;
		ItemStack ammoItem = entity.findAmmo(stack);
		ItemStack ammoItemCopy = ammoItem.copy();

		for (int k = 0; k < j; ++k) {
			
			if (k > 0) {
				
				ammoItem = ammoItemCopy.copy();
				
			}

			if (ammoItem.isEmpty() && isCreative) {
				
				ammoItem = new ItemStack(Items.ARROW);
				ammoItemCopy = ammoItem.copy();
				
			}

			if (!addChargedProjectile(entity, stack, ammoItem, k > 0, isCreative)) {
				
				return false;
				
			}
			
		}

		return true;
		
	}

	private static boolean addChargedProjectile(LivingEntity shooter, ItemStack stack, ItemStack arrow, boolean multishot, boolean creative) {
		
		int enchInfinity = EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack);
		
		if (arrow.isEmpty()) {
			
			return false;
			
		} else {
			
			boolean isCreative = creative && arrow.getItem() instanceof ArrowItem;
			boolean hasInfinity = enchInfinity > 0;
			ItemStack itemstack;
			
			if (!isCreative && !creative && !multishot && !hasInfinity) {
				
				itemstack = arrow.split(1);
				
				if (arrow.isEmpty() && shooter instanceof PlayerEntity) {
					
					((PlayerEntity) shooter).inventory.deleteStack(arrow);
					
				}
				
			} else {
				
				itemstack = arrow.copy();
				
			}

			addChargedProjectile(stack, itemstack);
			return true;
			
		}
		
	}

	public static boolean isCharged(ItemStack stack) {
		
		CompoundNBT compoundnbt = stack.getTag();
		return compoundnbt != null && compoundnbt.getBoolean("Charged");
		
	}
	

	public static void setCharged(ItemStack stack, boolean charged) {
		
		CompoundNBT compoundnbt = stack.getOrCreateTag();
		compoundnbt.putBoolean("Charged", charged);
		
	}
	

	private static void addChargedProjectile(ItemStack crossbow, ItemStack projectile) {
		
		CompoundNBT compoundnbt = crossbow.getOrCreateTag();
		ListNBT listnbt;
		
		if (compoundnbt.contains("ChargedProjectiles", 9)) {
			
			listnbt = compoundnbt.getList("ChargedProjectiles", 10);
			
		} else {
			
			listnbt = new ListNBT();
			
		}

		CompoundNBT compoundnbt1 = new CompoundNBT();
		projectile.write(compoundnbt1);
		listnbt.add(compoundnbt1);
		compoundnbt.put("ChargedProjectiles", listnbt);
		
	}
	

	private static List<ItemStack> getChargedProjectiles(ItemStack stack) {
		
		List<ItemStack> list = Lists.newArrayList();
		CompoundNBT compoundnbt = stack.getTag();
		
		if (compoundnbt != null && compoundnbt.contains("ChargedProjectiles", 9)) {
			
			ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 10);
			
			if (listnbt != null) {
				
				for (int i = 0; i < listnbt.size(); ++i) {
					
					CompoundNBT compoundnbt1 = listnbt.getCompound(i);
					list.add(ItemStack.read(compoundnbt1));
					
				}
				
			}
			
		}

		return list;
		
	}
	

	private static void clearProjectiles(ItemStack stack) {
		
		CompoundNBT compoundnbt = stack.getTag();
		
		if (compoundnbt != null) {
			
			ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 9);
			listnbt.clear();
			compoundnbt.put("ChargedProjectiles", listnbt);
			
		}

	}
	

	public static boolean hasChargedProjectile(ItemStack stack, Item ammoItem) {
		
		return getChargedProjectiles(stack).stream().anyMatch((p_220010_1_) -> {
			
			return p_220010_1_.getItem() == ammoItem;
			
		});
		
	}
	

	private void fireProjectile(World world, LivingEntity shooter, Hand handIn, ItemStack crossbow,
			ItemStack projectile, float soundPitch, boolean isCreativeMode, float velocity, float inaccuracy,
			float projectileAngle) {
		
		if (!world.isRemote) {
			
			boolean isProjectile = projectile.getItem() == Items.FIREWORK_ROCKET;
			ProjectileEntity projectileEntity;
			
			if (isProjectile) {
				
				projectileEntity = new FireworkRocketEntity(world, projectile, shooter, shooter.getPosX(),
						shooter.getPosYEye() - (double) 0.15F, shooter.getPosZ(), true);
				
			} else {
				
				projectileEntity = createArrow(world, shooter, crossbow, projectile);
				
				if (isCreativeMode || projectileAngle != 0.0F) {
					
					((AbstractArrowEntity) projectileEntity).pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
					
				}
				
			}

			if (shooter instanceof ICrossbowUser) {
				
				ICrossbowUser icrossbowuser = (ICrossbowUser) shooter;
				icrossbowuser.func_230284_a_(icrossbowuser.getAttackTarget(), crossbow, projectileEntity, projectileAngle);
				
			} else {
				
				Vector3d vector3d1 = shooter.getUpVector(1.0F);
				Quaternion quaternion = new Quaternion(new Vector3f(vector3d1), projectileAngle, true);
				Vector3d vector3d = shooter.getLook(1.0F);
				Vector3f vector3f = new Vector3f(vector3d);
				vector3f.transform(quaternion);
				projectileEntity.shoot((double) vector3f.getX(), (double) vector3f.getY(), (double) vector3f.getZ(),
						velocity, inaccuracy);
				
			}

			crossbow.damageItem(isProjectile ? 3 : 1, shooter, (p_220017_1_) -> {
				
				p_220017_1_.sendBreakAnimation(handIn);
				
			});
			
			world.addEntity(projectileEntity);
			world.playSound((PlayerEntity) null, shooter.getPosX(), shooter.getPosY(), shooter.getPosZ(),
					SoundEvents.ITEM_CROSSBOW_SHOOT, SoundCategory.PLAYERS, 1.0F, soundPitch);
			
		}
		
	}

	private AbstractArrowEntity createArrow(World world, LivingEntity shooter, ItemStack crossbow, ItemStack ammo) {
		
		ArrowItem arrowItem = (ArrowItem) (ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
		AbstractArrowEntity arrowEntity = arrowItem.createArrow(world, ammo, shooter);
		
		if (shooter instanceof PlayerEntity) {
			
			arrowEntity.setIsCritical(true);
			
		}

		arrowEntity.setHitSound(SoundEvents.ITEM_CROSSBOW_HIT);
		arrowEntity.setShotFromCrossbow(true);
		
		double enchPower = getArrowDamage(crossbow);
		arrowEntity.setDamage(2 + enchPower);
		
		int enchPiercing = getArrowPierce(crossbow);
		arrowEntity.setPierceLevel((byte) enchPiercing);
		
		arrowEntity.setFire(getArrowFlameTime(crossbow));

		return arrowEntity;
		
	}

	public void fireProjectiles(World world, LivingEntity shooter, Hand hand, ItemStack stack, float velocity, float inaccuracy) {
		
		List<ItemStack> list = getChargedProjectiles(stack);
		float[] afloat = getRandomSoundPitches(shooter.getRNG());
		int enchMultishot = EnchantmentHelper.getEnchantmentLevel(Enchantments.MULTISHOT, stack);

		for (int i = 0; i < list.size(); ++i) {
			
			ItemStack itemstack = list.get(i);
			boolean isCreative = shooter instanceof PlayerEntity && ((PlayerEntity) shooter).abilities.isCreativeMode;
			
			if (!itemstack.isEmpty()) {
				
				if (enchMultishot == 0) {
					
					if (i == 0) {
						
						fireProjectile(world, shooter, hand, stack, itemstack, afloat[i], isCreative, velocity, inaccuracy, 0.0F);
						
					}
					
				} else if (enchMultishot == 1) {
					
					if (i == 0) {

						fireProjectile(world, shooter, hand, stack, itemstack, afloat[i], isCreative, velocity, inaccuracy, 0.0F);

					} else if (i == 1) {

						fireProjectile(world, shooter, hand, stack, itemstack, afloat[i], isCreative, velocity, inaccuracy, -10.0F);

					} else if (i == 2) {

						fireProjectile(world, shooter, hand, stack, itemstack, afloat[i], isCreative, velocity, inaccuracy, 10.0F);

					}
					
				} else if (enchMultishot == 2) {
					
					if (i == 0) {

						fireProjectile(world, shooter, hand, stack, itemstack, afloat[i], isCreative, velocity, inaccuracy, 0.0F);

					} else if (i == 1) {

						fireProjectile(world, shooter, hand, stack, itemstack, afloat[i], isCreative, velocity, inaccuracy, -10.0F);
						fireProjectile(world, shooter, hand, stack, itemstack, afloat[i], isCreative, velocity, inaccuracy, -20.0F);

					} else if (i == 2) {

						fireProjectile(world, shooter, hand, stack, itemstack, afloat[i], isCreative, velocity, inaccuracy, 10.0F);
						fireProjectile(world, shooter, hand, stack, itemstack, afloat[i], isCreative, velocity, inaccuracy, 20.0F);

					}
					
				}
				
			}
			
		}

		fireProjectilesAfter(world, shooter, stack);
		
	}

	private static float[] getRandomSoundPitches(Random rand) {
		
		boolean rng = rand.nextBoolean();
		
		return new float[] { 1.0F, getRandomSoundPitch(rng), getRandomSoundPitch(!rng) };
		
	}

	private static float getRandomSoundPitch(boolean flag) {
		
		float f = flag ? 0.63F : 0.43F;
		return 1.0F / (random.nextFloat() * 0.5F + 1.8F) + f;
		
	}

	private static void fireProjectilesAfter(World world, LivingEntity shooter, ItemStack stack) {
		
		if (shooter instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) shooter;
			
			if (!world.isRemote) {
				
				CriteriaTriggers.SHOT_CROSSBOW.test(serverplayerentity, stack);
				
			}

			serverplayerentity.addStat(Stats.ITEM_USED.get(stack.getItem()));
			
		}

		clearProjectiles(stack);
		
	}

	@Override
	public void onUse(World world, LivingEntity livingEntity, ItemStack stack, int count) {
		
		if (!world.isRemote) {
			
			int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
			SoundEvent soundevent = this.getSoundEvent(i);
			SoundEvent soundevent1 = i == 0 ? SoundEvents.ITEM_CROSSBOW_LOADING_MIDDLE : null;
			float f = (float) (stack.getUseDuration() - count) / (float) getChargeTime(stack);
			
			if (f < 0.2F) {
				
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
				
			}

			if (f >= 0.2F && !this.isLoadingStart) {
				
				this.isLoadingStart = true;
				world.playSound((PlayerEntity) null, livingEntity.getPosX(), livingEntity.getPosY(),
						livingEntity.getPosZ(), soundevent, SoundCategory.PLAYERS, 0.5F, 1.0F);
				
			}

			if (f >= 0.5F && soundevent1 != null && !this.isLoadingMiddle) {
				
				this.isLoadingMiddle = true;
				world.playSound((PlayerEntity) null, livingEntity.getPosX(), livingEntity.getPosY(),
						livingEntity.getPosZ(), soundevent1, SoundCategory.PLAYERS, 0.5F, 1.0F);
				
			}
			
		}

	}

	public int getUseDuration(ItemStack stack) {
		
		return getChargeTime(stack) + 3;
		
	}

	public static int getChargeTime(ItemStack stack) {
		
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
		return i == 0 ? 25 : 25 - 5 * i;
		
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		
		return UseAction.CROSSBOW;
		
	}

	private SoundEvent getSoundEvent(int enchantmentLevel) {
		
		switch (enchantmentLevel) {
		case 1:
			return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_1;
		case 2:
			return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_2;
		case 3:
			return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_3;
		default:
			return SoundEvents.ITEM_CROSSBOW_LOADING_START;
		}
		
	}

	public float getCharge(int useTime, ItemStack stack) {
		
		float f = (float) useTime / (float) getChargeTime(stack);
		
		if (f > 1.0F) {
			
			f = 1.0F;
			
		}

		return f;
		
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		
		List<ItemStack> projectiles = getChargedProjectiles(stack);
		
		if (isCharged(stack) && !projectiles.isEmpty()) {
			
			ItemStack itemstack = projectiles.get(0);
			tooltip.add((new TranslationTextComponent("item.minecraft.crossbow.projectile")).appendString(" ").append(itemstack.getTextComponent()));
			
			if (flag.isAdvanced() && itemstack.getItem() == Items.FIREWORK_ROCKET) {
				
				List<ITextComponent> list1 = Lists.newArrayList();
				Items.FIREWORK_ROCKET.addInformation(itemstack, world, list1, flag);
				
				if (!list1.isEmpty()) {
					
					for (int i = 0; i < list1.size(); ++i) {
						
						list1.set(i, (new StringTextComponent("  ")).append(list1.get(i)).mergeStyle(TextFormatting.GRAY));
						
					}

					tooltip.addAll(list1);
					
				}
				
			}

		}
		
	}

	private static float isChargedCrossbow(ItemStack item) {
		
		return item.getItem() == Items.CROSSBOW && hasChargedProjectile(item, Items.FIREWORK_ROCKET)? 1.6F : 3.15F;
		
	}

	public int func_230305_d_() {
		
		return 8;
		
	}
	
	public int getArrowPierce(ItemStack stack) {
		
		int enchPiercing = EnchantmentHelper.getEnchantmentLevel(Enchantments.PIERCING, stack);
		
		return enchPiercing;
		
	}
	
	public double getArrowDamage(ItemStack stack) {
		
		int enchPower = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
		
		return enchPower * 0.5D + 0.5D;
		
	}
	
	public int getArrowFlameTime(ItemStack stack) {
		
		int enchFlame = EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack);
		
		return enchFlame * 100;
		
	}
	
}
