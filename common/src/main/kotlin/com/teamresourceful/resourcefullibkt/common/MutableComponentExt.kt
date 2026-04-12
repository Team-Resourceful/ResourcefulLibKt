package com.teamresourceful.resourcefullibkt.common

import net.minecraft.core.Holder
import net.minecraft.network.chat.ClickEvent
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.HoverEvent
import net.minecraft.network.chat.MutableComponent
import net.minecraft.server.dialog.Dialog
import java.io.File
import java.net.URI
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private inline fun <reified Event : ClickEvent, Argument> createClickEventDelegate(
    crossinline getter: Event.() -> Argument,
    crossinline factory: (Argument) -> Event
): ReadWriteProperty<MutableComponent, Argument?> {
    return object : ReadWriteProperty<MutableComponent, Argument?> {
        override fun getValue(thisRef: MutableComponent, property: KProperty<*>): Argument? {
            return (thisRef.style.clickEvent as? Event)?.getter()
        }

        override fun setValue(thisRef: MutableComponent, property: KProperty<*>, value: Argument?) {
            thisRef.withStyle {
                it.withClickEvent(value?.let(factory))
            }
        }
    }
}

var MutableComponent.url: URI? by createClickEventDelegate(ClickEvent.OpenUrl::uri, ClickEvent::OpenUrl)
var MutableComponent.file: File? by createClickEventDelegate(ClickEvent.OpenFile::file, ClickEvent::OpenFile)
var MutableComponent.command: String? by createClickEventDelegate(ClickEvent.RunCommand::command, ClickEvent::RunCommand)
var MutableComponent.suggest: String? by createClickEventDelegate(ClickEvent.SuggestCommand::command, ClickEvent::SuggestCommand)
var MutableComponent.page: Int? by createClickEventDelegate(ClickEvent.ChangePage::page, ClickEvent::ChangePage)
var MutableComponent.clipboard: String? by createClickEventDelegate(ClickEvent.CopyToClipboard::value, ClickEvent::CopyToClipboard)
var MutableComponent.dialog: Holder<Dialog>? by createClickEventDelegate(ClickEvent.ShowDialog::dialog, ClickEvent::ShowDialog)

private inline fun <reified Event : HoverEvent, Argument> createHoverEventDelegate(
    crossinline getter: Event.() -> Argument,
    crossinline factory: (Argument) -> Event
): ReadWriteProperty<MutableComponent, Argument?> {
    return object : ReadWriteProperty<MutableComponent, Argument?> {
        override fun getValue(thisRef: MutableComponent, property: KProperty<*>): Argument? {
            return (thisRef.style.hoverEvent as? Event)?.getter()
        }

        override fun setValue(thisRef: MutableComponent, property: KProperty<*>, value: Argument?) {
            thisRef.withStyle {
                it.withHoverEvent(value?.let(factory))
            }
        }
    }
}

var MutableComponent.hover: Component? by createHoverEventDelegate(HoverEvent.ShowText::value, HoverEvent::ShowText)