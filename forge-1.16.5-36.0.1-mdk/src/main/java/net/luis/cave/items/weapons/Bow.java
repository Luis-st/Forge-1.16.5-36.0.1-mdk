package net.luis.cave.items.weapons;

import java.util.function.Predicate;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
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
			ItemStack itemstack = player.findAmmo(stack);
			int duration = this.getUseDuration(stack) - timeLeft;
			duration = ForgeEventFactory.onArrowLoose(stack, world, player, duration, !itemstack.isEmpty() || isCreative);
			
			if (duration < 0) {
				
				return;
				
			}

			if (!itemstack.isEmpty() || isCreative) {
				
				if (itemstack.isEmpty()) {
					
					itemstack = new ItemStack(Items.ARROW);
					
				}

				float velocity = getArrowVelocity(duration);
				
				if (!( velocity < 0.1f)) {
					
					boolean isCreativeOrInfinity = player.abilities.isCreativeMode || (itemstack.getItem() instanceof ArrowItem 
							&& ((ArrowItem) itemstack.getItem()).isInfinite(itemstack, stack, player));
					
					if (!world.isRemote) {
						
						ArrowItem arrowItem = (ArrowItem) (itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
						AbstractArrowEntity arrowEntity = arrowItem.createArrow(world, itemstack, player);
						arrowEntity = customArrow(arrowEntity);
						arrowEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0F, velocity * 3.0F, 1.0F);
						
						if (velocity >= 1.0F) {
							
							arrowEntity.setIsCritical(true);
							
						}
						
						double enchPower = getArrowDamage(stack);
						arrowEntity.setDamage(enchPower > 0 ? enchPower : arrowEntity.getDamage());
						
						int enchPunch = getArrowKnockback(stack);
						arrowEntity.setKnockbackStrength(enchPunch > 0 ? enchPunch : 0);
						
						arrowEntity.setFire(getArrowFlameTime(stack));

						stack.damageItem(1, player, item -> {
							
							item.sendBreakAnimation(player.getActiveHand());
							
						});
						
						if (isCreativeOrInfinity || player.abilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || 
								itemstack.getItem() == Items.TIPPED_ARROW)) {
							
							arrowEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
							
						}

						world.addEntity(arrowEntity);
						
					}

					world.playSound((PlayerEntity) null, player.getPosX(), 
							player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
							1.0F / (random.nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);
					
					if (!isCreativeOrInfinity && !player.abilities.isCreativeMode) {
						
						itemstack.shrink(1);
						
						if (itemstack.isEmpty()) {
							
							player.inventory.deleteStack(itemstack);
							
						}
						
					}

					player.addStat(Stats.ITEM_USED.get(this));
					
				}
				
			}
			
		}
		
	}

	public float getArrowVelocity(int charge) {
		
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		
		if (f > 1.0F) {
			
			f = 1.0F;
			
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

		ActionResult<ItemStack> ret = ForgeEventFactory.onArrowNock(itemstack, world, player, hand, hasAmmo);
		
		if (ret != null) {
			
			return ret;
			
		}
			
		if (!player.abilities.isCreativeMode && !hasAmmo) {
			
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
