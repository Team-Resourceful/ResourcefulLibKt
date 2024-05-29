package com.teamresourceful.resourcefullibkt.client

import com.mojang.blaze3d.vertex.PoseStack

inline fun PoseStack.pushPop(action: PoseStack.() -> Unit) {
    this.pushPose()
    this.action()
    this.popPose()
}