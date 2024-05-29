package com.teamresourceful.resourcefullibkt.common

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry
import net.minecraft.core.Registry
import kotlin.reflect.KProperty

fun <T> Registry<T>.createRegistry(modid: String): ResourcefulRegistry<T> =
    ResourcefulRegistries.create(this, modid)

operator fun <T> RegistryEntry<T>.getValue(test: Any, property: KProperty<*>): T = this.get()

