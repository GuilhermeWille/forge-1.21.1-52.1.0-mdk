package com.atlas.orcsswordemagic.item;

import com.atlas.orcsswordemagic.OrcsSeMMod;
import com.atlas.orcsswordemagic.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OrcsSeMMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OSEM =
            CREATIVE_MODE_TABS.register("osem_item_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.PURPERIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.osem.osem_item_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PURPERIUM_INGOT.get());
                        pOutput.accept(ModItems.ORK_SWORD.get());
                        pOutput.accept(ModBlocks.ORC_WOOD.get());
                        pOutput.accept(ModBlocks.PURPERIUM_ORE.get());
                        pOutput.accept(ModBlocks.PURPERIUM_DEEPSLATE_ORE.get());
                    })

                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
