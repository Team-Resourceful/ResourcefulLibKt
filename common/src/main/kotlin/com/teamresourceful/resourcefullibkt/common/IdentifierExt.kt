package com.teamresourceful.resourcefullibkt.common

import net.minecraft.resources.Identifier

fun String.toIdentifier() = Identifier.tryParse(this)

fun Identifier(namespace: String, path: String) = Identifier.fromNamespaceAndPath(namespace, path)

operator fun Identifier.component1(): String = namespace
operator fun Identifier.component2(): String = path