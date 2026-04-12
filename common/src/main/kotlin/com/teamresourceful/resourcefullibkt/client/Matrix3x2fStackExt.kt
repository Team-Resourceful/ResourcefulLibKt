package com.teamresourceful.resourcefullibkt.client

import org.joml.Matrix3x2fStack

inline fun Matrix3x2fStack.pushPop(action: Matrix3x2fStack.() -> Unit) {
    this.pushMatrix()
    this.action()
    this.popMatrix()
}

inline fun Matrix3x2fStack.translated(x: Int, y: Int, action: Matrix3x2fStack.() -> Unit) {
    this.pushMatrix()
    this.translate(x.toFloat(), y.toFloat())
    this.action()
    this.popMatrix()
}

inline fun Matrix3x2fStack.scaled(x: Float, y: Float, action: Matrix3x2fStack.() -> Unit) {
    this.pushMatrix()
    this.scale(x, y)
    this.action()
    this.popMatrix()
}