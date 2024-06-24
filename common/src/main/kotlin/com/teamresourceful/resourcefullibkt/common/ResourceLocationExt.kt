package com.teamresourceful.resourcefullibkt.common

import net.minecraft.resources.ResourceLocation

fun String.toResourceLocation() = ResourceLocation.tryParse(this)

fun ResourceLocation(namespace: String, path: String) = ResourceLocation.fromNamespaceAndPath(namespace, path)

operator fun ResourceLocation.component1(): String = namespace
operator fun ResourceLocation.component2(): String = path