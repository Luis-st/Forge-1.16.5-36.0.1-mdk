package net.luis.cave.events.fml;

import net.luis.cave.Cave;
import net.luis.cave.client.render.EnderiteElytraLayer;
import net.luis.cave.client.render.NightElytraLayer;
import net.luis.cave.init.items.ModTools;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreatItemProperties {
	
	@SubscribeEvent
	public static void doClientSetup(FMLClientSetupEvent event) {
		
		for (PlayerRenderer playerRenderer : Minecraft.getInstance().getRenderManager().getSkinMap().values()) {
			
			playerRenderer.addLayer(new EnderiteElytraLayer<>(playerRenderer));
			
		}
		
		for (PlayerRenderer playerRenderer : Minecraft.getInstance().getRenderManager().getSkinMap().values()) {
			
			playerRenderer.addLayer(new NightElytraLayer<>(playerRenderer));
			
		}
		
		itemPropertieShield(ModTools.IRON_SHIELD.get());
		itemPropertieShield(ModTools.GOLDEN_SHIELD.get());
		itemPropertieShield(ModTools.DIAMOND_SHIELD.get());
		itemPropertieShield(ModTools.NETHERITE_SHIELD.get());
		itemPropertieShield(ModTools.ENDERITE_SHIELD.get());
		itemPropertieShield(ModTools.NIGHT_SHIELD.get());
		
		itemPropertieCrossbow(ModTools.NETHERITE_CROSSBOW.get());
		itemPropertieCrossbow(ModTools.ENDERITE_CROSSBOW.get());
		itemPropertieCrossbow(ModTools.NIGHT_CROSSBOW.get());
		
		itemPropertieBow(ModTools.NETHERITE_BOW.get());
		itemPropertieBow(ModTools.ENDERITE_BOW.get());
		itemPropertieBow(ModTools.NIGHT_BOW.get());
		
	}
	
	private static void itemPropertieShield(Item item) {
		
    	ItemModelsProperties.registerProperty(item, new ResourceLocation("blocking"), (p_239421_0_, p_239421_1_, p_239421_2_) -> {
			
			return p_239421_2_ != null && p_239421_2_.isHandActive() && p_239421_2_.getActiveItemStack() == p_239421_0_ ? 1.0F : 0.0F;
			
		});
		
	}
	
	private static void itemPropertieCrossbow(Item item) {
		
    	ItemModelsProperties.registerProperty(item, new ResourceLocation("pull"), (p_239427_0_, p_239427_1_, p_239427_2_) -> {
	    	  
			if (p_239427_2_ == null) {
	        	  
				return 0.0F;
	             
			} else {
	        	  
				return CrossbowItem.isCharged(p_239427_0_) ? 0.0F : (float)(p_239427_0_.getUseDuration() 
						- p_239427_2_.getItemInUseCount()) / (float)CrossbowItem.getChargeTime(p_239427_0_);
	             
			}
	          
		});
		
    	ItemModelsProperties.registerProperty(item, new ResourceLocation("pulling"), (p_239426_0_, p_239426_1_, p_239426_2_) -> {
	    	   
			return p_239426_2_ != null && p_239426_2_.isHandActive() && p_239426_2_.getActiveItemStack() == 
					p_239426_0_ && !CrossbowItem.isCharged(p_239426_0_) ? 1.0F : 0.0F;
	          
		});
	       
    	ItemModelsProperties.registerProperty(item, new ResourceLocation("charged"), (p_239425_0_, p_239425_1_, p_239425_2_) -> {
	    	   
			return p_239425_2_ != null && CrossbowItem.isCharged(p_239425_0_) ? 1.0F : 0.0F;
	          
		});
	       
    	ItemModelsProperties.registerProperty(item, new ResourceLocation("firework"), (p_239424_0_, p_239424_1_, p_239424_2_) -> {
	    	   
			return p_239424_2_ != null && CrossbowItem.isCharged(p_239424_0_) && CrossbowItem.hasChargedProjectile(p_239424_0_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
	          
		});
		
	}
	
	private static void itemPropertieBow(Item item) {
		
    	ItemModelsProperties.registerProperty(item, new ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> {
			
			return p_239428_2_ != null && p_239428_2_.isHandActive() && p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
			
		});
		
    	ItemModelsProperties.registerProperty(item, new ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> {
	
			if (p_239429_2_ == null) {
	
				return 0.0F;

			} else {
	
				return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F : (float)(p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;

			}

		});
		
	}

}