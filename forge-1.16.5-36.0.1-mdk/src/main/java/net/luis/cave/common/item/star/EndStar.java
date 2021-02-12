package net.luis.cave.common.item.star;

import net.luis.cave.Cave;
import net.luis.cave.api.item.Star;
import net.luis.cave.common.enums.StarType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class EndStar extends Star {

	public EndStar() {
		
		super(new Item.Properties().group(Cave.MISC), StarType.END);
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		Vector3d lookVec = player.getLookVec();
		Vector3d motion = player.getMotion();
		double v0 = 0.4; 
		double v1 = 1.8; 
		double v2 = 1.0;
		
		if (player.isElytraFlying()) {
			
			player.setMotion(motion.add(lookVec.x * v0 + (lookVec.x * v1 - motion.x) * v2, 
										lookVec.y * v0 + (lookVec.y * v1 - motion.y) * v2, 
										lookVec.z * v0 + (lookVec.z * v1 - motion.z) * v2));
			player.getCooldownTracker().setCooldown(this, 80);
			return ActionResult.func_233538_a_(player.getHeldItem(hand), world.isRemote());
			
		}
		
		return ActionResult.resultPass(player.getHeldItem(hand));
		
	}
	
}