package com.atlas.orcsswordemagic.block;

import com.atlas.orcsswordemagic.OrcsSeMMod;
import com.atlas.orcsswordemagic.item.ModItems;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OrcsSeMMod.MOD_ID);

    public static final RegistryObject<Block> ORC_WOOD = registryBlock("orc_wood", () -> new Block(BlockBehaviour.Properties.of()
            .isRedstoneConductor((state, level, pos) ->true)
            .isViewBlocking((state, level, pos) -> true)
            .isSuffocating((state, level, pos) -> true)
            .explosionResistance(15.0F)
            .sound(SoundType.NETHER_WOOD)
            ));

    private static<T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
