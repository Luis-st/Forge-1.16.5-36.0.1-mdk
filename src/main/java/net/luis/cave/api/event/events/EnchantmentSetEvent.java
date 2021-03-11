package net.luis.cave.api.event.events;

import java.util.List;

import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.Event;

public class EnchantmentSetEvent extends Event {
	
	private final World world;
	private final PlayerEntity player;
	private final BlockPos pos;
	private final ItemStack stack;
	private final int enchantRow;
	private final int level;
	private final List<EnchantmentData> originalDataList;
	private List<EnchantmentData> dataList;
	
	public EnchantmentSetEvent(World world, PlayerEntity player, BlockPos pos, ItemStack stack, List<EnchantmentData> datalist, int enchantRow, int level) {
		
		this.world = world;
		this.player = player;
		this.pos = pos;
		this.stack = stack;
		this.enchantRow = enchantRow;
		this.level = level;
		this.originalDataList = datalist;
		this.dataList = originalDataList;
		
	}

	public World getWorld() {
		
		return world;
		
	}

	public PlayerEntity getPlayer() {
		
		return player;
		
	}

	public BlockPos getPos() {
		
		return pos;
		
	}

	public ItemStack getStack() {
		
		return stack;
		
	}
	
	public int getEnchantRow() {
		
		return enchantRow;
		
	}

	public int getLevel() {
		
		return level;
		
	}

	public List<EnchantmentData> getOriginalDataList() {
		
		return originalDataList;
		
	}

	public List<EnchantmentData> getDataList() {
		
		return dataList;
		
	}

	public void setDataList(List<EnchantmentData> dataList) {
		
		this.dataList = dataList;
		
	}

}
