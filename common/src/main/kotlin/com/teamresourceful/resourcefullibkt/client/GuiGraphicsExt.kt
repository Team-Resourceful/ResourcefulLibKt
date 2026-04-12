package com.teamresourceful.resourcefullibkt.client

import net.minecraft.client.gui.GuiGraphicsExtractor
import org.joml.Matrix3x2fStack

inline fun GuiGraphicsExtractor.scissor(x: Int, y: Int, width: Int, height: Int, action: () -> Unit) {
    this.enableScissor(x, y, x + width, y + height)
    action()
    this.disableScissor()
}

inline fun GuiGraphicsExtractor.pushPop(action: Matrix3x2fStack.() -> Unit) {
    this.pose().pushPop(action)
}