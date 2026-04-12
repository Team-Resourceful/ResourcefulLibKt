package com.teamresourceful.resourcefullibkt.common

import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ListTag
import kotlin.jvm.optionals.getOrNull

fun CompoundTag.getStringOrNull(key: String): String? = this.getString(key).getOrNull()
fun CompoundTag.getByteOrNull(key: String): Byte? = this.getByte(key).getOrNull()
fun CompoundTag.getShortOrNull(key: String): Short? = this.getShort(key).getOrNull()
fun CompoundTag.getIntOrNull(key: String): Int? = this.getInt(key).getOrNull()
fun CompoundTag.getLongOrNull(key: String): Long? = this.getLong(key).getOrNull()
fun CompoundTag.getFloatOrNull(key: String): Float? = this.getFloat(key).getOrNull()
fun CompoundTag.getDoubleOrNull(key: String): Double? = this.getDouble(key).getOrNull()
fun CompoundTag.getBooleanOrNull(key: String): Boolean? = this.getBoolean(key).getOrNull()
fun CompoundTag.getCompoundOrNull(key: String): CompoundTag? = this.getCompound(key).getOrNull()
fun CompoundTag.getListOrNull(key: String): ListTag? = this.getList(key).getOrNull()
fun CompoundTag.getIntArrayOrNull(key: String): IntArray? = this.getIntArray(key).getOrNull()
fun CompoundTag.getLongArrayOrNull(key: String): LongArray? = this.getLongArray(key).getOrNull()
fun CompoundTag.getByteArrayOrNull(key: String): ByteArray? = this.getByteArray(key).getOrNull()