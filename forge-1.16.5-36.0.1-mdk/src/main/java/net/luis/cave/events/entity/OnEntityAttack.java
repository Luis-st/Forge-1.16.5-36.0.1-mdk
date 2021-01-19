package net.luis.cave.events.entity;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.init.CaveTools;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityAttack {

	@SubscribeEvent
	public static void EntityAttack(LivingAttackEvent event) {
		
		Entity target = event.getEntityLiving();
		Entity entity = event.getSource().getTrueSource();
		World world = target.getEntityWorld();
		
		if (entity instanceof PlayerEntity) {
			
			if (target instanceof LivingEntity) {
				
				LivingEntity livingTarget = (LivingEntity) target;
				PlayerEntity player = (PlayerEntity) entity;
				
				int enchPoison = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.POISON_ASPECT.get(), player.getHeldItemMainhand());
				int enchFrost = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.FROST_ASPECT.get(), player.getHeldItemMainhand());
				int enchCurseHarming = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.CURSE_OF_HARMING.get(), player.getHeldItemMainhand());
				
				if (enchPoison > 0) {
					
					livingTarget.addPotionEffect(new EffectInstance(Effects.POISON, 50 * (enchPoison + 2), 0 + (enchPoison + 1)));
					
					
				}
				
				if (enchFrost > 0) {
					
					livingTarget.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100 * (enchFrost + 1), 2 + (enchFrost + 1)));
					
				}
				
				if (player.getHeldItemMainhand().getItem() == CaveTools.BLAZING_SWORD.get()) {
					
					target.setFire(world.rand.nextInt(15));
					
				}
				
				if (enchCurseHarming == 1) {
					
					float backAmount = event.getAmount() / 2;
					player.attackEntityFrom(new DamageSource("curse"), backAmount);
					
				}
				
			}
			
		}

	}

}
