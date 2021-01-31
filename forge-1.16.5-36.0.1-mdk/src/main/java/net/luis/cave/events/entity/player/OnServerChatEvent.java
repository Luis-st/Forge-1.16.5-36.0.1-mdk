package net.luis.cave.events.entity.player;

import net.luis.cave.Cave;
import net.luis.cave.util.lib.WorldManager;
import net.luis.cave.world.CaveGameRules;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnServerChatEvent {
	
	@SubscribeEvent
	public static void ServerChat(ServerChatEvent event) {
		
		String msg = event.getMessage();
		ServerPlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();
		
		if (world.getGameRules().getBoolean(CaveGameRules.ENABLE_SLIMECHUNK_INFO.getRule())) {
			
			if (msg.equalsIgnoreCase("?slime")) {
				
				event.setCanceled(true);
				
				if (WorldManager.isSlimeChunk(world, player)) {
					
					player.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe current chunk is a slime chunk!"), player.getUniqueID());
					
				} else {
					
					player.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe current chunk is not a slime chunk!"), player.getUniqueID());
					
				}
				
			}
			
		}
		
		if (world.getGameRules().getBoolean(CaveGameRules.ENABLE_SEED_INFO.getRule())) {
			
			if (msg.equalsIgnoreCase("?seed")) {
				
				event.setCanceled(true);
				
				if (!world.isRemote) {
					
					ServerWorld serverWorld = (ServerWorld) world;
					long seed = serverWorld.getSeed();
					
					ITextComponent iTextComponent = TextComponentUtils.wrapWithSquareBrackets(
							(new StringTextComponent(String.valueOf(seed))).modifyStyle((p_211752_2_) -> {
								return p_211752_2_.setFormatting(TextFormatting.GREEN)
										.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(seed)))
										.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new TranslationTextComponent("chat.copy.click")))
										.setInsertion(String.valueOf(seed));
								}));
					
					player.sendMessage(new TranslationTextComponent("commands.seed.success", iTextComponent), player.getUniqueID());
					
				}
				
			}
			
		}
		
	}
	
}
