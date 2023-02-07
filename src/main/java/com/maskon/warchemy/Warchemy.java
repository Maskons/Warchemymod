package com.maskon.warchemy;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Warchemy implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Warchemy");

	public static final Item WARCHEMY_POWDER = Registry.register(Registries.ITEM,
			new Identifier("warchemy","warchemy_powder"), new Item(new FabricItemSettings()));

	public static final IceHeart ICE_HEART = new IceHeart(new FabricItemSettings());

	public static final Block WARCHEMY_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool());
	public static final Block WARCHEMY_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool());
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("warchemy", "warchemy_materials"))
			.icon(() -> new ItemStack(WARCHEMY_POWDER))
			.build();

	@Override
	public void onInitialize(ModContainer mod) {
		//LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
			content.addItem(WARCHEMY_POWDER);
		});
		Registry.register(Registries.ITEM,new Identifier("warchemy","ice_heart"), ICE_HEART);
		Registry.register(Registries.BLOCK, new Identifier("warchemy", "warchemy_ore"), WARCHEMY_ORE);
		Registry.register(Registries.ITEM, new Identifier("warchemy","warchemy_ore"), new BlockItem(WARCHEMY_ORE, new FabricItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier("warchemy", "warchemy_bricks"), WARCHEMY_BRICKS);
		Registry.register(Registries.ITEM, new Identifier("warchemy","warchemy_bricks"), new BlockItem(WARCHEMY_BRICKS, new FabricItemSettings()));
	}
}
