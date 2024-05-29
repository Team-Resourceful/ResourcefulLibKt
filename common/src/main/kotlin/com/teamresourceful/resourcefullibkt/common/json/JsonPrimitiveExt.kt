package com.teamresourceful.resourcefullibkt.common.json

import com.google.gson.JsonPrimitive

fun JsonPrimitive.asStringOrNull(): String? = takeIf { isString }?.asString
fun JsonPrimitive.asNumberOrNull(): Number? = takeIf { isNumber }?.asNumber
fun JsonPrimitive.asBooleanOrNull(): Boolean? = takeIf { isBoolean }?.asBoolean