package com.teamresourceful.resourcefullibkt.neoforge

import com.mojang.serialization.Codec
import net.neoforged.neoforge.attachment.AttachmentType

typealias AttachmentSupplier <T> = () -> T

fun <T> attachment(supplier: AttachmentSupplier<T>, builder: AttachmentType.Builder<T>.() -> Unit): AttachmentType<T> {
    return AttachmentType.builder(supplier).apply(builder).build()
}

var <T> AttachmentType.Builder<T>.codec: Codec<T>
    get() = error("No getter for codec")
    set(value) {
        this.serialize(value)
    }