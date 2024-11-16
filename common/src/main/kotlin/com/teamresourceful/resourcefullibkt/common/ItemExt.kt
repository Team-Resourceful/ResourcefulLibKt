package com.teamresourceful.resourcefullibkt.common

import net.minecraft.core.Holder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack

val Item.id: ResourceLocation
    get() = BuiltInRegistries.ITEM.getKey(this)

val ItemStack.id: ResourceLocation
    get() = this.item.id

val Item.holder: Holder.Reference<Item>
    get() = this.builtInRegistryHolder()

operator fun TagKey<Item>.contains(item: Item): Boolean = item.holder.`is`(this)
operator fun TagKey<Item>.contains(stack: ItemStack): Boolean = stack.item in this

fun itemProperties(invoker: Item.Properties.() -> Unit): Item.Properties {
    return Item.Properties().apply { invoker(this) }
}

@Deprecated(
    message = "Too ambiguous with block properties",
    replaceWith = ReplaceWith("itemProperties(invoker)")
)
fun properties(invoker: Item.Properties.() -> Unit): Item.Properties {
    return Item.Properties().apply { invoker(this) }
}