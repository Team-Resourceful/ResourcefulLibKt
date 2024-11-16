package com.teamresourceful.resourcefullibkt.common

import net.minecraft.core.Holder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState

val Block.id: ResourceLocation
    get() = BuiltInRegistries.BLOCK.getKey(this)

val BlockState.id: ResourceLocation
    get() = this.block.id

val Block.holder: Holder.Reference<Block>
    get() = this.builtInRegistryHolder()

operator fun TagKey<Block>.contains(block: Block): Boolean = block.holder.`is`(this)
operator fun TagKey<Block>.contains(state: BlockState): Boolean = state.block in this

fun blockProperties(invoker: BlockBehaviour.Properties.() -> Unit): BlockBehaviour.Properties {
    return BlockBehaviour.Properties.of().apply { invoker(this) }
}

@Deprecated(
    message = "Too ambiguous with item properties",
    replaceWith = ReplaceWith("blockProperties(invoker)")
)
fun properties(invoker: BlockBehaviour.Properties.() -> Unit): BlockBehaviour.Properties {
    return BlockBehaviour.Properties.of().apply { invoker(this) }
}