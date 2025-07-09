package com.atlas.orcsswordemagic.block;

import com.atlas.orcsswordemagic.OrcsSeMMod;
import com.atlas.orcsswordemagic.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OrcsSeMMod.MOD_ID);

    public static final RegistryObject<Block> PURPERIUM_ORE = registryBlock("purperium_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4),BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops()
            .strength(2f)
            .isViewBlocking((state, level, pos) -> true)
            .isSuffocating((State, Level, Pos) -> true)
            .explosionResistance(20.0F)
            .sound(SoundType.DRIPSTONE_BLOCK)
    ));
    public static final RegistryObject<Block> PURPERIUM_DEEPSLATE_ORE = registryBlock("purperium_deepslate_ore", () -> new DropExperienceBlock(UniformInt.of(3, 5),BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops()
            .strength(4f)
            .isViewBlocking((state, level, pos) -> true)
            .isSuffocating((State, Level, Pos) -> true)
            .explosionResistance(20.0F)
            .sound(SoundType.DEEPSLATE)
    ));


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
