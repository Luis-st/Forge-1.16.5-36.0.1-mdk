package net.luis.cave.events.world.block.destroy;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.world.CaveGameRules;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnBlasting {
	
	@SubscribeEvent
	public static void Blasting(BlockEvent.BreakEvent event) {
		
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		double x = event.getPos().getX();
		double y = event.getPos().getY();
		double z = event.getPos().getZ();
		int enchBlasting = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.BLASTING.get(), player.getHeldItemMainhand());
		int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());

		if (player instanceof PlayerEntity) {
			
			if (enchBlasting > 0) {
				
				world.createExplosion(player, x, y, z, 2.0f * (enchBlasting + 1), enchTelekinesis == 0 ? Explosion.Mode.BREAK : Explosion.Mode.NONE);
				
				if (world.getGameRules().getBoolean(CaveGameRules.ENABLE_BLASTING_DAMAGE.getRule())) {
					
					player.attackEntityFrom(DamageSource.causeExplosionDamage(player), enchBlasting + 2);
				
				}
				
			}
			
		}
		
	}
	
}
