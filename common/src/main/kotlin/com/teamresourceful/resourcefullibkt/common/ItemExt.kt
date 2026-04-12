package com.teamresourceful.resourcefullibkt.common

import net.minecraft.core.Holder
import net.minecraft.core.component.DataComponentType
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack

val Item.id: Identifier
    get() = BuiltInRegistries.ITEM.getKey(this)

val ItemStack.id: Identifier
    get() = this.item.id

val Item.holder: Holder.Reference<Item>
    get() = this.builtInRegistryHolder()

operator fun TagKey<Item>.contains(item: Item): Boolean = item.holder.`is`(this)
operator fun TagKey<Item>.contains(stack: ItemStack): Boolean = stack.item in this

fun itemProperties(invoker: Item.Properties.() -> Unit): Item.Properties {
    return Item.Properties().apply { invoker(this) }
}

operator fun <T : Any> ItemStack.get(type: DataComponentType<T>): T? = this.get(type)
operator fun <T : Any> ItemStack.set(type: DataComponentType<T>, value: T): T? = this.set(type, value)