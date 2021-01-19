package net.luis.cave.items;

import net.luis.cave.Cave;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class EndStar extends Item {

	public EndStar() {
		
		super(new Item.Properties()
					.group(Cave.MISC)
					.maxStackSize(1)
					.rarity(Rarity.UNCOMMON));
		
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {

		return true;
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		Vector3d vector3d = player.getLookVec();
		Vector3d vector3d1 = player.getMotion();
		BlockPos pos = new BlockPos(player.getPosX(), player.getPosY(), player.getPosZ());
		//Default d0 = 0.1, d1 = 1.5, d2 = 0.5
		double v0 = 0.4; 
		double v1 = 1.8; 
		double v2 = 1.0;
		
		if (player.isElytraFlying()) {
			
			player.setMotion(vector3d1.add(vector3d.x * v0 + (vector3d.x * v1 - vector3d1.x) * v2, 
										   vector3d.y * v0 + (vector3d.y * v1 - vector3d1.y) * v2, 
										   vector3d.z * v0 + (vector3d.z * v1 - vector3d1.z) * v2));
			player.getCooldownTracker().setCooldown(this, 80);
			return ActionResult.func_233538_a_(player.getHeldItem(hand), world.isRemote());
			
		} else {
			
			if (player.isSneaking()) {
				
				
				
			} else {
				
				if (!world.isRemote) {
					
					if (world.getBiome(pos).equals(new ResourceLocation("end_barrens")) |
						world.getBiome(pos).equals(new ResourceLocation("end_highlands")) |
						world.getBiome(pos).equals(new ResourceLocation("end_midlands")) |
						world.getBiome(pos).equals(new ResourceLocation("small_end_islands")) |
						world.getBiome(pos).equals(new ResourceLocation("the_end"))) {
						
						double lx = player.getLook(1f).x * 25;
						double ly = player.getLook(1f).y * 25;
						double lz = player.getLook(1f).z * 25;
						
						double tx = player.world.rayTraceBlocks(new RayTraceContext(player.getEyePosition(1f), 
																					player.getEyePosition(1f).add(lx, ly, lz), 
																					RayTraceContext.BlockMode.OUTLINE, 
																					RayTraceContext.FluidMode.NONE, player)).getPos().getX();
						double ty = player.world.rayTraceBlocks(new RayTraceContext(player.getEyePosition(1f), 
																					player.getEyePosition(1f).add(lx, ly, lz), 
																					RayTraceContext.BlockMode.OUTLINE, 
																					RayTraceContext.FluidMode.NONE, player)).getPos().getY();
						double tz = player.world.rayTraceBlocks(new RayTraceContext(player.getEyePosition(1f), 
																					player.getEyePosition(1f).add(lx, ly, lz), 
																					RayTraceContext.BlockMode.OUTLINE, 
																					RayTraceContext.FluidMode.NONE, player)).getPos().getZ();
						
						player.setPositionAndUpdate(tx, ty, tz);
						
						player.getCooldownTracker().setCooldown(this, 10);
					
					} else {
						
						double lx = player.getLook(1f).x * 10;
						double ly = player.getLook(1f).y * 10;
						double lz = player.getLook(1f).z * 10;
						
						double tx = player.world.rayTraceBlocks(new RayTraceContext(player.getEyePosition(1f), 
																					player.getEyePosition(1f).add(lx, ly, lz), 
																					RayTraceContext.BlockMode.OUTLINE, 
																					RayTraceContext.FluidMode.NONE, player)).getPos().getX();
						double ty = player.world.rayTraceBlocks(new RayTraceContext(player.getEyePosition(1f), 
																					player.getEyePosition(1f).add(lx, ly, lz), 
																					RayTraceContext.BlockMode.OUTLINE, 
																					RayTraceContext.FluidMode.NONE, player)).getPos().getY();
						double tz = player.world.rayTraceBlocks(new RayTraceContext(player.getEyePosition(1f), 
																					player.getEyePosition(1f).add(lx, ly, lz), 
																					RayTraceContext.BlockMode.OUTLINE, 
																					RayTraceContext.FluidMode.NONE, player)).getPos().getZ();
						
						player.setPositionAndUpdate(tx, ty, tz);
					
						player.getCooldownTracker().setCooldown(this, 80);
						
					}
					
				}
				
				return ActionResult.func_233538_a_(player.getHeldItem(hand), world.isRemote());
				
			}
			
		}
		
		return ActionResult.resultPass(player.getHeldItem(hand));
		
	}
	
}