package net.thebashguy.peppebrescia;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeppeBrescia implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("peppebrescia");

	public static final Block PEPPEBRESCIA_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());
	public static final Block PEPPEBRESCIA_STAIRS = new BresciaStairs(PEPPEBRESCIA_BLOCK.getDefaultState(), AbstractBlock.Settings.of(Material.METAL).strength(6f).requiresTool());
	private static final ItemGroup PEPPEBRESCIA_GROUP = FabricItemGroup.builder(new Identifier("peppebrescia", "peppe_brescia"))
			.icon(() -> new ItemStack(PEPPEBRESCIA_BLOCK))
			.displayName(Text.literal("Peppe Brescia"))
			.build();

	@Override
	public void onInitialize() {
		LOGGER.info("PIACERE PEPPE BRESCIA");
		Registry.register(Registries.BLOCK, new Identifier("peppebrescia", "block"), PEPPEBRESCIA_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("peppebrescia", "block"), new BlockItem(PEPPEBRESCIA_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.BLOCK, new Identifier("peppebrescia", "stairs"), PEPPEBRESCIA_STAIRS);
		Registry.register(Registries.ITEM, new Identifier("peppebrescia", "stairs"), new BlockItem(PEPPEBRESCIA_STAIRS, new FabricItemSettings()));
		ItemGroupEvents.modifyEntriesEvent(PEPPEBRESCIA_GROUP).register(content -> content.add(PEPPEBRESCIA_BLOCK));
		ItemGroupEvents.modifyEntriesEvent(PEPPEBRESCIA_GROUP).register(content -> content.add(PEPPEBRESCIA_STAIRS));
	}
}