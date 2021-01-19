package net.luis.cave.blocks;

import net.luis.cave.init.CaveItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class PowderSnow extends Block {

	public PowderSnow() {
		
		super(Block.Properties.create(Material.SNOW_BLOCK, MaterialColor.SNOW)
				.zeroHardnessAndResistance()
				.sound(SoundType.SNOW)
				.harvestLevel(0)
				.harvestTool(ToolType.SHOVEL)
				.notSolid());
		
	}
	
	@Override
	public float getSpeedFactor() {
		
		return 0.8f;
		
	}
	
	@Override
	public float getJumpFactor() {
		
		return 0.85f;
		
	}
	
	@Override
	public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance) {
		
		entity.fallDistance = 0f;
		
	}
	
	@Override
	public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, MobEntity entity) {
		
		return PathNodeType.WALKABLE;
		
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		Entity entity = context.getEntity();
		
		if (entity != null) {
			
			if (entity instanceof PlayerEntity) {
				
				PlayerEntity player = (PlayerEntity) entity;
				
				if (player.inventory.armorItemInSlot(0).getItem() == Items.LEATHER_BOOTS) {
					
					return VoxelShapes.fullCube();
					
				} else {
					
					return VoxelShapes.empty();
					
				}
				
			} else if (entity instanceof ItemEntity) {
				
				return VoxelShapes.empty();
				
			} else {
				
				return VoxelShapes.empty();
				
			}
			
		} else {
			
			return VoxelShapes.empty();
			
		}
			
	}
	
	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		
		if (entity.getMotion().getY() <= 0) {
			
			if (entity.isSneaking()) {
				
				entity.setMotion(entity.getMotion().getX(), -0.01, entity.getMotion().getZ());
				
			} else {
				
				entity.setMotion(entity.getMotion().getX(), -0.00001, entity.getMotion().getZ());
				
			}
		
			entity.fallDistance = 0f;
			
		}
		
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		
		ItemStack item = new ItemStack(CaveItems.POWDER_SNOW_BUCKET.get(), 1);
		
		if (player.getHeldItemMainhand().getItem() == Items.BUCKET) {
			
			player.setHeldItem(hand, item);
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
			
			return ActionResultType.SUCCESS;
			
		}
		
		
		return ActionResultType.PASS;
		
	}

}
