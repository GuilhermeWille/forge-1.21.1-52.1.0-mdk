package com.atlas.orcsswordemagic.item;

import com.atlas.orcsswordemagic.OrcsSeMMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OrcsSeMMod.MOD_ID);

    public static final RegistryObject<Item> TEST = ITEMS.register("test", () -> new Item(new Item.Properties()));
    public static final RegistryObject<SwordItem> ORK_SWORD = ITEMS.register("ork_sword", () -> new SwordItem(
            Tiers.DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(
                    Tiers.DIAMOND, 18, -2.4F
    ))
    ));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
