package net.luis.cave.api.item.weapon;

import java.util.function.Predicate;

import net.luis.cave.api.lib.ItemManager;
import net.luis.cave.common.item.entity.DiamondArrowItem;
import net.luis.cave.common.item.entity.JadeArrowItem;
import net.luis.cave.common.item.entity.NetheriteArrowItem;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.items.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class Bow extends ShootableItem implements IVanishable {

	public Bow(Item.Properties builder) {
		
		super(builder);
		
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity entityLiving, int timeLeft) {
		
		if (entityLiving instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entityLiving;
			boolean isCreative = player.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack ammo = player.findAmmo(stack);
			int duration = this.getUseDuration(stack) - timeLeft;
			duration = ForgeEventFactory.onArrowLoose(stack, world, player, duration, !ammo.isEmpty() || isCreative);
			int enchThrowEnd = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.THROW_OF_THE_END.get(), stack);
			
			if (duration < 0) {
				
				return;
				
			}
			
			if (!ammo.isEmpty() || isCreative || enchThrowEnd > 0) {
				
				if (ammo.isEmpty()) {
					
					ammo = new ItemStack(Items.ARROW);
					
				}

				float velocityArrow = getArrowVelocity(duration);
				
				if (!(velocityArrow < 0.1f)) {
					
					boolean isCreativeOrInfinity = player.abilities.isCreativeMode || (ammo.getItem() instanceof ArrowItem 
							&& ((ArrowItem) ammo.getItem()).isInfinite(ammo, stack, player));
					
					if (!world.isRemote) {
						
						int enchDoubleShot = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.DOUBLE_SHOT.get(), stack);
						
						if (enchThrowEnd > 0) {
							
							float velocityEnderPearl = getEnderPearlVelocity(duration);
							
							EnderPearlEntity enderPearlEntity = creatEnderPearlEntity(world, player, velocityEnderPearl);
							world.addEntity(enderPearlEntity);
							world.playSound((PlayerEntity)null, player.getPosX(), 
									player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 
									0.4F / (random.nextFloat() * 0.4F + 0.8F));
							
							ItemManager.damageItem(stack, 2, player, e -> {
								
								e.sendBreakAnimation(EquipmentSlotType.MAINHAND);
								
							}, false);
							
						} else {
							
							AbstractArrowEntity arrowEntity = creatArrowEntity(stack, ammo, world, player, velocityArrow);
							AbstractArrowEntity doubleShotArrow = creatArrowEntity(stack, ammo, world, player, velocityArrow);
							boolean isSpecial = ammo.getItem() == Items.SPECTRAL_ARROW || 
									ammo.getItem() == Items.TIPPED_ARROW || 
									ammo.getItem() == ModItems.NETHERITE_ARROW_ITEM.get();
							
							if (isCreativeOrInfinity || player.abilities.isCreativeMode && isSpecial) {
								
								arrowEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
								
							}
							
							world.addEntity(arrowEntity);

							if (enchDoubleShot > 0) {
								
								world.addEntity(doubleShotArrow);
								
							}
							
							world.playSound((PlayerEntity) null, player.getPosX(), 
									player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
									1.0F / (random.nextFloat() * 0.4F + 1.2F) + velocityArrow * 0.5F);
							
						}

						stack.damageItem(1, player, item -> {
							
							item.sendBreakAnimation(player.getActiveHand());
							
						});
						

						
					}

					if (!isCreativeOrInfinity && !player.abilities.isCreativeMode) {
						
						ammo.shrink(1);
						
						if (ammo.isEmpty()) {
							
							player.inventory.deleteStack(ammo);
							
						}
						
					}

					player.addStat(Stats.ITEM_USED.get(this));
					
				}
				
			}
			
		}
		
	}
	
	private EnderPearlEntity creatEnderPearlEntity(World world, PlayerEntity player, float velocity) {
		
        EnderPearlEntity enderPearlEntity = new EnderPearlEntity(world, player);
        enderPearlEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0F, velocity, 1.0F);
		
		return enderPearlEntity;
		
	}
	
	private AbstractArrowEntity creatArrowEntity(ItemStack stack, ItemStack ammo, World world, PlayerEntity player, float velocity) {
		
		ArrowItem arrowItem = (ArrowItem) (ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
		AbstractArrowEntity arrowEntity = arrowItem.createArrow(world, ammo, player);
		arrowEntity = customArrow(arrowEntity);
		arrowEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0F, velocity * 3.0F, 1.0F);
		
		if (velocity >= 1.0F) {
			
			arrowEntity.setIsCritical(true);
			
		}
		
		double enchPower = getArrowDamage(stack);
		arrowEntity.setDamage(getArrowBaseDamage(ammo) + enchPower);
		
		int enchPunch = getArrowKnockback(stack);
		if (enchPunch > 0) {
			arrowEntity.setKnockbackStrength(enchPunch);	
		}
		
		int enchPiercing = getArrowPierce(stack);
		arrowEntity.setPierceLevel((byte) enchPiercing);

		arrowEntity.setFire(getArrowFlameTime(stack));
		
		return arrowEntity;
		
	}
	
	public int getArrowBaseDamage(ItemStack ammo) {
		
		if (ammo.getItem() instanceof JadeArrowItem) {
			
			return 3;
			
		} else if (ammo.getItem() instanceof DiamondArrowItem) {
			
			return 5;
			
		} else if (ammo.getItem() instanceof NetheriteArrowItem) {
			
			return 7;
			
		}
		
		return 2;
		
	}

	public float getArrowVelocity(int charge) {
		
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		
		if (f > 1.5F) {
			
			f = 1.5F;
			
		}

		return f;
		
	}
	
	public float getEnderPearlVelocity(int charge) {
		
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 4.0F;

		if (f > 2.5F) {
			
			f = 2.5F;
			
		}
		
		if (f < 1.5F) {
			
			f = 1.5F;
			
		}
		
		return f;
		
	}
	
	public double getArrowDamage(ItemStack stack) {
		
		int enchPower = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
		
		return enchPower * 0.5D + 0.5D;
		
	}
	
	public int getArrowKnockback(ItemStack stack) {
		
		int enchPunch = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
		
		return enchPunch;
		
	}
	
	public int getArrowFlameTime(ItemStack stack) {
		
		int enchFlame = EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack);
		
		return enchFlame * 100;
		
	}
	
	public int getArrowPierce(ItemStack stack) {
		
		int enchPiercing = EnchantmentHelper.getEnchantmentLevel(Enchantments.PIERCING, stack);
		
		return enchPiercing;
		
	}
	
	@Override
	public int getUseDuration(ItemStack stack) {
		
		return 72000;
		
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		
		return UseAction.BOW;
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		ItemStack itemstack = player.getHeldItem(hand);
		boolean hasAmmo = !player.findAmmo(itemstack).isEmpty();
		int enchThrowEnd = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.THROW_OF_THE_END.get(), player.getHeldItemMainhand());

		ActionResult<ItemStack> ret = ForgeEventFactory.onArrowNock(itemstack, world, player, hand, hasAmmo);
		
		if (ret != null) {
			
			return ret;
			
		}
			
		if (!player.abilities.isCreativeMode && !hasAmmo && enchThrowEnd <= 0) {
			
			return ActionResult.resultFail(itemstack);
			
		} else {
			
			player.setActiveHand(hand);
			return ActionResult.resultConsume(itemstack);
			
		}
		
	}

	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		
		return ARROWS;
		
	}

	public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
		
		return arrow;
		
	}

	public int func_230305_d_() {
		
		return 15;
		
	}
	
}
