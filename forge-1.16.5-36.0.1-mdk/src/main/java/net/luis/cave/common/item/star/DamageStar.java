package net.luis.cave.common.item.star;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.api.item.api.Star;
import net.luis.cave.common.enums.StarType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class DamageStar extends Star {
	
	private final String tag = this.getTagName();
	private final String maxTag = "max";

	public DamageStar() {
		
		super(new Item.Properties().group(Cave.MISC), StarType.DAMAGE);
		
	}
	
	@Override
	public void starTick(ItemStack stack, World world, PlayerEntity player) {
		
		if (stack.getOrCreateChildTag(this.getTagName()).getDouble(this.getTagName()) >= stack.getOrCreateChildTag(this.getMaxTag()).getInt(this.getMaxTag())
				) {
			
			stack.getOrCreateChildTag(this.getTagName()).putDouble(this.getTagName(), 0);
			stack.getOrCreateChildTag(this.getMaxTag()).putInt(this.getMaxTag(), stack.getOrCreateChildTag(this.getMaxTag()).getInt(this.getMaxTag()) + 1);
			
		}
		
	}
	
	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		
		int tagValue = (int) stack.getOrCreateChildTag(this.getTagName()).getDouble(this.getTagName());
		int maxTag = stack.getOrCreateChildTag(this.getMaxTag()).getInt(this.getMaxTag());
		tooltip.add(new StringTextComponent("Maximum Bonus Damage: ")
				.mergeStyle(TextFormatting.BLUE).append(new StringTextComponent("" + maxTag)));
		tooltip.add(new StringTextComponent("Bonus Damage: ")
					.mergeStyle(TextFormatting.BLUE).append(new StringTextComponent("" + tagValue)));
		
	}

	public String getMaxTag() {
		
		return maxTag;
		
	}
	
	@Override
	public String getTagName() {
		
		return this.tag;
		
	}

}
