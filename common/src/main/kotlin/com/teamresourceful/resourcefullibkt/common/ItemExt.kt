package com.teamresourceful.resourcefullibkt.common

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack

val Item.id: ResourceLocation
    get() = BuiltInRegistries.ITEM.getKey(this)

val ItemStack.id: ResourceLocation
    get() = this.item.id

fun properties(invoker: Item.Properties.() -> Unit): Item.Properties {
    return Item.Properties().apply { invoker(this) }
}

