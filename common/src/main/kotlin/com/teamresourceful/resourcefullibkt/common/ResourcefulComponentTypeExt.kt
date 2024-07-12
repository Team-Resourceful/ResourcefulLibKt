package com.teamresourceful.resourcefullibkt.common

import com.mojang.serialization.Codec
import com.teamresourceful.bytecodecs.base.ByteCodec
import com.teamresourceful.resourcefullib.common.item.ResourcefulComponentType
import net.minecraft.core.component.DataComponentType

fun <T> component(builder: ResourcefulComponentType<T>.() -> Unit): DataComponentType<T> {
    return ResourcefulComponentType<T>().apply(builder).build()
}

var <T> ResourcefulComponentType<T>.persistent: Codec<T>
    get() = throw UnsupportedOperationException("This property should not be accessed")
    set(value) {
        this.persistent(value)
    }

var <T> ResourcefulComponentType<T>.synced: ByteCodec<T>
    get() = throw UnsupportedOperationException("This property should not be accessed")
    set(value) {
        this.networkSynchronized(value)
    }