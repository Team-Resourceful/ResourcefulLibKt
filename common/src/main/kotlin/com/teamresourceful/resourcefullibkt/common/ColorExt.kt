@file:OptIn(ExperimentalStdlibApi::class)

package com.teamresourceful.resourcefullibkt.common

import com.teamresourceful.resourcefullib.common.color.Color

fun Color.toHex() = "#${value.toHexString(HexFormat.UpperCase)}"

operator fun Color.component1(): Int = this.intRed
operator fun Color.component2(): Int = this.intGreen
operator fun Color.component3(): Int = this.intBlue
operator fun Color.component4(): Int = this.intAlpha

fun Int.toColor() = Color(this)
fun UInt.toColor() = Color(this.toInt())