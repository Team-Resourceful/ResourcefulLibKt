package com.teamresourceful.resourcefullibkt.common

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive

fun JsonElement.isString(): Boolean = this is JsonPrimitive && isString
fun JsonElement.isNumber(): Boolean = this is JsonPrimitive && isNumber
fun JsonElement.isBoolean(): Boolean = this is JsonPrimitive && isBoolean