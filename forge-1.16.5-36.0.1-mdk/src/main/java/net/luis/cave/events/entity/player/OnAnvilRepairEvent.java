package net.luis.cave.events.entity.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.luis.cave.Cave;
import net.luis.cave.init.blocks.ModBlocks;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnAnvilRepairEvent {

	@SubscribeEvent
	public static void AnvilRepair(AnvilRepairEvent event) {
		
		ItemStack inputLeft = event.getItemInput();
		ItemStack inputBack = inputLeft.copy();
		ItemStack inputRight = event.getIngredientInput();
		ItemStack output = event.getItemResult();
		PlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();
		BlockPos pos = new BlockPos(player.getLookVec());
		
		if (world.getBlockState(pos).getBlock() == ModBlocks.INFINITE_ANVIL.get()) {
			
			event.setBreakChance(0f);
			
		} else {
			
			event.setBreakChance(0.06f);
			
		}
		
		if (world.getGameRules().getBoolean(ModGameRule.ENABLE_ENCHANTMENT_TRANSFER.getRule())) {
			
			if (inputLeft.isEnchanted()) {
				
				if (inputRight.getItem() instanceof BookItem) {
					
					if (!inputRight.isEnchanted()) {
						
						Map<Enchantment, Integer> enchantmentsInput = EnchantmentHelper.getEnchantments(inputLeft);
						Map<Enchantment, Integer> enchantmentsOutput = EnchantmentHelper.getEnchantments(output);
						
						List<Enchantment> enchantmenList = new ArrayList<Enchantment>(enchantmentsOutput.keySet());
						
						if (!enchantmenList.isEmpty()) {
							
							Enchantment Ench = enchantmenList.get(0);
							
							if (enchantmentsOutput.size() >= 1) {
								
								enchantmentsInput.remove(Ench);
								EnchantmentHelper.setEnchantments(enchantmentsInput, inputBack);
								inputBack.setRepairCost(0);
								ItemHandlerHelper.giveItemToPlayer(player, inputBack);
								
							} else {
								
								ItemHandlerHelper.giveItemToPlayer(player, inputBack);
								
							}
							
						} else {
							
							ItemHandlerHelper.giveItemToPlayer(player, inputBack);
							
						}
						
					}
					
				}
				
			}
			
		}
		
		output.setRepairCost(output.getRepairCost() / 2);
		
	}

}
