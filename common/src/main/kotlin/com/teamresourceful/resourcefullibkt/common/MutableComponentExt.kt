package com.teamresourceful.resourcefullibkt.common

import net.minecraft.network.chat.ClickEvent
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.HoverEvent
import net.minecraft.network.chat.MutableComponent

var MutableComponent.url: String?
    get() = clickEventOrNull(ClickEvent.Action.OPEN_URL)
    set(value) {
        this.withStyle {
            it.withClickEvent(value?.let { v -> ClickEvent(ClickEvent.Action.OPEN_URL, v) })
        }
    }

var MutableComponent.file: String?
    get() = clickEventOrNull(ClickEvent.Action.OPEN_FILE)
    set(value) {
        this.withStyle {
            it.withClickEvent(value?.let { v -> ClickEvent(ClickEvent.Action.OPEN_FILE, v) })
        }
    }

var MutableComponent.command: String?
    get() = clickEventOrNull(ClickEvent.Action.RUN_COMMAND)
    set(value) {
        this.withStyle {
            it.withClickEvent(value?.let { v -> ClickEvent(ClickEvent.Action.RUN_COMMAND, v) })
        }
    }

var MutableComponent.suggest: String?
    get() = clickEventOrNull(ClickEvent.Action.SUGGEST_COMMAND)
    set(value) {
        this.withStyle {
            it.withClickEvent(value?.let { v -> ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, v) })
        }
    }

var MutableComponent.page: String?
    get() = clickEventOrNull(ClickEvent.Action.CHANGE_PAGE)
    set(value) {
        this.withStyle {
            it.withClickEvent(value?.let { v -> ClickEvent(ClickEvent.Action.CHANGE_PAGE, v) })
        }
    }

var MutableComponent.clipboard: String?
    get() = clickEventOrNull(ClickEvent.Action.COPY_TO_CLIPBOARD)
    set(value) {
        this.withStyle {
            it.withClickEvent(value?.let { v -> ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, v) })
        }
    }

var MutableComponent.hover: Component?
    get() = hoverEventOrNull(HoverEvent.Action.SHOW_TEXT)
    set(value) {
        this.withStyle {
            it.withHoverEvent(value?.let { v -> HoverEvent(HoverEvent.Action.SHOW_TEXT, v) })
        }
    }

private fun <T> MutableComponent.hoverEventOrNull(action: HoverEvent.Action<T>): T? {
    return this.style.hoverEvent?.takeIf { it.action == action }?.getValue(action)
}

private fun MutableComponent.clickEventOrNull(action: ClickEvent.Action): String? {
    return this.style.clickEvent?.takeIf { it.action == action }?.value
}