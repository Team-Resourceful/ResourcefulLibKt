package com.teamresourceful.resourcefullibkt.common

import net.minecraft.core.BlockPos

operator fun BlockPos.component1(): Int = this.x
operator fun BlockPos.component2(): Int = this.y
operator fun BlockPos.component3(): Int = this.z

operator fun BlockPos.times(multiplier: Int): BlockPos =
    this.offset(this.x * multiplier, this.y * multiplier, this.z * multiplier)

operator fun BlockPos.div(divisor: Int): BlockPos =
    this.offset(this.x / divisor, this.y / divisor, this.z / divisor)

operator fun BlockPos.plus(other: BlockPos): BlockPos =
    this.offset(other.x, other.y, other.z)

operator fun BlockPos.minus(other: BlockPos): BlockPos =
    this.offset(-other.x, -other.y, -other.z)

fun BlockPos.toLong(): Long = BlockPos.asLong(this.x, this.y, this.z)

fun Long.toBlockPos(): BlockPos = BlockPos(BlockPos.getX(this), BlockPos.getY(this), BlockPos.getZ(this))


