package net.luis.cave.common.block;

import net.luis.cave.api.entity.EntityManager;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.ForgeEventFactory;

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
	@SuppressWarnings("deprecation")
	public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
		
		return adjacentBlockState.isIn(this) ? true : super.isSideInvisible(state, adjacentBlockState, side);
		
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
				
				if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == Items.LEATHER_BOOTS) {
					
					return VoxelShapes.fullCube();
					
				} else {
					
					return VoxelShapes.empty();
					
				}
				
			} else {
				
				return VoxelShapes.empty();
				
			}
			
		} else {
			
			return VoxelShapes.empty();
			
		}
			
	}
	
	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		
		StrayEntity strayEntity = new StrayEntity(EntityType.STRAY, world);
		
		if (entity instanceof SkeletonEntity) {
			
			if (!world.isRemote) {
				
				strayEntity.setPositionAndRotation(entity.getPosX(), entity.getPosY(), entity.getPosZ(), entity.getPitchYaw().x, entity.getPitchYaw().y);
				strayEntity.onInitialSpawn((IServerWorld) world, world.getDifficultyForLocation(pos), SpawnReason.MOB_SUMMONED, null, null);
				entity.remove();
				world.addEntity(strayEntity);
				
				ForgeEventFactory.onLivingConvert((LivingEntity) entity, strayEntity);
				
			}
			
		}
		
		if (entity instanceof LivingEntity) {
			
			LivingEntity livingEntity = (LivingEntity) entity;
			ItemStack stack = livingEntity.getItemStackFromSlot(EquipmentSlotType.FEET);
			int enchLavaWalker = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.LAVA_WALKER.get(), stack);
			int enchFrostWalker = EnchantmentHelper.getEnchantmentLevel(Enchantments.FROST_WALKER, stack);
			
			if (!(livingEntity instanceof SkeletonEntity) && !EntityManager.isFrozenType(livingEntity)) {
				
				if (livingEntity instanceof PlayerEntity) {
					
					if (enchFrostWalker == 0 && enchLavaWalker == 0) {
						
						entity.attackEntityFrom(new DamageSource("freezing"), 1.0f);
						
					}
					
				} else if (EntityManager.isLavaType(livingEntity)) {
					
					entity.attackEntityFrom(new DamageSource("freezing"), 4.0f);
					
				} else {
					
					entity.attackEntityFrom(new DamageSource("freezing"), 1.0f);
					
				}
				
			}
			
		}
		
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
		
		ItemStack item = new ItemStack(ModItems.POWDER_SNOW_BUCKET.get(), 1);
		
		if (player.getHeldItemMainhand().getItem() == Items.BUCKET) {
			
			if (!player.abilities.isCreativeMode) {
				
				player.setHeldItem(hand, item);
				
			}
			
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
			ForgeEventFactory.onBucketUse(player, world, item, hit);
			
			return ActionResultType.SUCCESS;
			
		}
		
		
		return ActionResultType.PASS;
		
	}
	
	@Override
	public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
		
		return new ItemStack(ModItems.POWDER_SNOW_BUCKET.get());
		
	}

}
