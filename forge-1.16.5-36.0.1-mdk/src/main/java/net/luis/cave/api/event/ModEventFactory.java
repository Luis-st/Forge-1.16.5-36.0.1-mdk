package net.luis.cave.api.event;

import java.util.List;

import net.luis.cave.api.event.events.EnchantmentSetEvent;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ModEventFactory {
	
	public static List<EnchantmentData> onEnchantmentSet(PlayerEntity player, BlockPos pos, ItemStack stack, List<EnchantmentData> dataList, int enchantRow, int level) {
		
		World world = player.getEntityWorld();
		EnchantmentSetEvent event = new EnchantmentSetEvent(world, player, pos, stack, dataList, enchantRow, level);
		List<EnchantmentData> enchantmentDataList = event.getDataList();
		MinecraftForge.EVENT_BUS.post(event);
		return enchantmentDataList;
		
	}

}
