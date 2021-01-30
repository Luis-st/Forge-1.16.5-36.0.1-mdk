package net.luis.cave.items;

import net.luis.cave.Cave;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		Vector3d vector3d = player.getLookVec();
		Vector3d vector3d1 = player.getMotion();
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
			
		}
		
		return ActionResult.resultPass(player.getHeldItem(hand));
		
	}
	
}