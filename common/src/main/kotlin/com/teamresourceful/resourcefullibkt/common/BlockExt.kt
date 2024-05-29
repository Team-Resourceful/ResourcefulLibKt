package com.teamresourceful.resourcefullibkt.common

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState

val Block.id: ResourceLocation
    get() = BuiltInRegistries.BLOCK.getKey(this)

val BlockState.id: ResourceLocation
    get() = this.block.id

fun properties(invoker: BlockBehaviour.Properties.() -> Unit): BlockBehaviour.Properties {
    return BlockBehaviour.Properties.of().apply { invoker(this) }
}