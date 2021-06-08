package net.luis.cave.common.block;

import java.util.Random;

import net.luis.cave.init.ModEnchantment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CrackedLava extends Block {
	
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;

	public CrackedLava() {
		
		super(Block.Properties.create(Material.LAVA)
				.tickRandomly()
				.setRequiresTool()
				.noDrops()
				.harvestLevel(2)
				.hardnessAndResistance(1.5f, 100.0f)
				.sound(SoundType.LODESTONE));
		
	}
	
	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		
		if (!entity.isImmuneToFire() && entity instanceof LivingEntity) {
			
			LivingEntity livingEntity = (LivingEntity) entity;
			ItemStack boots = livingEntity.getItemStackFromSlot(EquipmentSlotType.FEET);
			int enchFrostWalker = EnchantmentHelper.getEnchantmentLevel(Enchantments.FROST_WALKER, boots);
			int enchLavaWalker = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.LAVA_WALKER.get(), boots);
			
			if (enchFrostWalker == 0 && enchLavaWalker == 0) {
				
				livingEntity.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0f);
				
			}
			
		}
		
	}
	
	public static IntegerProperty getAge() {
		
		return AGE;
		
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		
		return 15;
		
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		
		this.tick(state, world, pos, random);
		
	}
	
	@Override
	public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		
		this.turnIntoLava(state, world, pos);
		
	}
	
	@Override
	public void onPlayerDestroy(IWorld world, BlockPos pos, BlockState state) {
		
		this.turnIntoLava(state, (World) world, pos);
		
	}
	
	@Override
	public void onExplosionDestroy(World world, BlockPos pos, Explosion explosionIn) {
		
		this.turnIntoLava(world.getBlockState(pos), world, pos);
		
	}
	
	@Override
	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		
		if ((rand.nextInt(3) == 0 || this.shouldLiquid(world, pos, 4)) && this.slightlyLiquid(state, world, pos)) {
			
			BlockPos.Mutable mutablePos = new BlockPos.Mutable();

			for (Direction direction : Direction.values()) {
				
				mutablePos.setAndMove(pos, direction);
				BlockState blockState = world.getBlockState(mutablePos);
				
				if (blockState.isIn(this) && !this.slightlyLiquid(blockState, world, mutablePos)) {
					
					world.getPendingBlockTicks().scheduleTick(mutablePos, this, MathHelper.nextInt(rand, 20, 40));
					
				}
				
			}

		} else {
			
			world.getPendingBlockTicks().scheduleTick(pos, this, MathHelper.nextInt(rand, 20, 40));
			
		}
		
	}
	
	private boolean slightlyLiquid(BlockState state, World world, BlockPos pos) {
		
		int i = state.get(AGE);
		
		if (i < 3) {
			
			world.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
			return false;
			
		} else {
			
			this.turnIntoLava(state, world, pos);
			return true;
			
		}
		
	}
	
	private boolean shouldLiquid(IBlockReader world, BlockPos pos, int neighborsRequired) {
		
		int i = 0;
		BlockPos.Mutable mutablePos = new BlockPos.Mutable();

		for (Direction direction : Direction.values()) {
			
			mutablePos.setAndMove(pos, direction);
			
			if (world.getBlockState(mutablePos).getBlock() instanceof CrackedLava) {
				
				++i;
				
				if (i >= neighborsRequired) {
					
					return false;
					
				}
				
			}
			
		}

		return true;
		
	}
	
	protected void turnIntoLava(BlockState state, World world, BlockPos pos) {
		
		world.setBlockState(pos, Blocks.LAVA.getDefaultState());
		world.neighborChanged(pos, Blocks.LAVA, pos);
		
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		
		builder.add(AGE);
		
	}
	
	@Override
	public ItemStack getItem(IBlockReader world, BlockPos pos, BlockState state) {
		
		return ItemStack.EMPTY;
		
	}

}
