package net.luis.cave.events.entity;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.init.CaveTools;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityAttack {

	@SubscribeEvent
	public static void EntityAttack(LivingAttackEvent event) {
		
		LivingEntity target = event.getEntityLiving();
		Entity entity = event.getSource().getTrueSource();
		World world = target.getEntityWorld();
		
		if (entity instanceof PlayerEntity) {
			
			if (target instanceof LivingEntity) {
				
				PlayerEntity player = (PlayerEntity) entity;
				
				int enchPoison = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.POISON_ASPECT.get(), player.getHeldItemMainhand());
				int enchFrost = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.FROST_ASPECT.get(), player.getHeldItemMainhand());
				int enchThunderbolt = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.THUNDERBOLT.get(), player.getHeldItemMainhand());
				int enchDoubleShot = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.DOUBLE_SHOT.get(), player.getHeldItemMainhand());
				int enchCuresHarming = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.CURSE_OF_HARMING.get(), player.getHeldItemMainhand());
				
				if (enchPoison > 0) {
					
					target.addPotionEffect(new EffectInstance(Effects.POISON, 50 * (enchPoison + 2), 0 + (enchPoison + 1)));
					
				}
				
				if (enchFrost > 0) {
					
					target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100 * (enchFrost + 1), 2 + (enchFrost + 1)));
					
				}
				
				if (player.getHeldItemMainhand().getItem() == CaveTools.BLAZING_SWORD.get()) {
					
					target.setFire(world.rand.nextInt(15));
					
				}
				
				if (enchCuresHarming > 0) {
					
					float backAmount = event.getAmount() / 2;
					player.attackEntityFrom(new DamageSource("curse"), backAmount);
					
				}
				
				if (enchThunderbolt > 0) {
					
					LightningBoltEntity lightning = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
					lightning.setLocationAndAngles(target.getPosX(), target.getPosY(), target.getPosZ(), world.rand.nextFloat() * 360, 0);
					world.addEntity(lightning);
					
					if (!world.isRemote) {
						
						((ServerWorld) world).func_241113_a_(0, world.rand.nextInt(1000), true, true);
						
					}
					
					player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 30, 4, false, false));
					
				}
				
				if (enchDoubleShot > 0) {
					
					target.hurtResistantTime = 0;
					
				}
				
			}
			
		}

	}

}
