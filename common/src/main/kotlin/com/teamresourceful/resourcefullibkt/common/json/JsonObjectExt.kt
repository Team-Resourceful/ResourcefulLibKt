package com.teamresourceful.resourcefullibkt.common.json

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.teamresourceful.resourcefullibkt.common.isBoolean
import com.teamresourceful.resourcefullibkt.common.isNumber
import com.teamresourceful.resourcefullibkt.common.isString

operator fun JsonObject.contains(key: String): Boolean = has(key)
operator fun JsonObject.set(key: String, element: JsonElement) = add(key, element)
operator fun JsonObject.set(key: String, value: String) = addProperty(key, value)
operator fun JsonObject.set(key: String, value: Number) = addProperty(key, value)
operator fun JsonObject.set(key: String, value: Boolean) = addProperty(key, value)

fun JsonObject.isString(key: String): Boolean = has(key) && get(key).isString()
fun JsonObject.isNumber(key: String): Boolean = has(key) && get(key).isNumber()
fun JsonObject.isBoolean(key: String): Boolean = has(key) && get(key).isBoolean()

fun JsonObject.isArray(key: String): Boolean = has(key) && get(key).isJsonArray
fun JsonObject.isObject(key: String): Boolean = has(key) && get(key).isJsonObject
fun JsonObject.isPrimitive(key: String): Boolean = has(key) && get(key).isJsonPrimitive

fun JsonObject.getAsString(key: String, default: String?) = getAsOrElse(key, default, JsonElement::isJsonPrimitive) { asString }
fun JsonObject.getAsBoolean(key: String, default: Boolean?) = getAsOrElse(key, default, JsonElement::isJsonPrimitive) { asBoolean }

fun JsonObject.getAsByte(key: String, default: Byte?) = getAsOrElse(key, default, JsonElement::isNumber) { asByte }
fun JsonObject.getAsShort(key: String, default: Short?) = getAsOrElse(key, default, JsonElement::isNumber) { asShort }
fun JsonObject.getAsInt(key: String, default: Int?) = getAsOrElse(key, default, JsonElement::isNumber) { asInt }
fun JsonObject.getAsLong(key: String, default: Long?) = getAsOrElse(key, default, JsonElement::isNumber) { asLong }
fun JsonObject.getAsFloat(key: String, default: Float?) = getAsOrElse(key, default, JsonElement::isNumber) { asFloat }
fun JsonObject.getAsDouble(key: String, default: Double?) = getAsOrElse(key, default, JsonElement::isNumber) { asDouble }

private fun <T> JsonObject.getAsOrElse(key: String, default: T?, check: JsonElement.() -> Boolean, block: JsonElement.() -> T): T {
    val value = get(key)
    if (value != null && value.check()) {
        return block(value)
    } else {
        require(default != null) { "Key $key not found and no default value provided" }
        return default
    }
}