/*
 * Copyright (c) bdew, 2013 - 2014
 * https://github.com/bdew/gendustry
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.gendustry.machines.apiary

import net.bdew.gendustry.Gendustry
import net.bdew.gendustry.gui.Textures
import net.bdew.lib.Misc
import net.bdew.lib.data.DataSlotFloat
import net.bdew.lib.gui.widgets.Widget
import net.bdew.lib.gui.{Point, Rect}

import scala.collection.mutable

class WidgetApiaryProgress(val rect: Rect, breeding: DataSlotFloat, progress: DataSlotFloat) extends Widget {
  val texture = Textures.whiteProgress(rect.w)

  override def handleTooltip(p: Point, tip: mutable.MutableList[String]) {
    if (breeding.value > 0) {
      tip += "%s - %.0f%%".format(Misc.toLocal(Gendustry.modId + ".label.breeding"), breeding.value * 100)
    } else if (progress.value > 0) {
      tip += "%s - %.0f%%".format(Misc.toLocal(Gendustry.modId + ".label.working"), progress.value * 100)
    }
  }

  override def draw(mouse: Point) {
    if (breeding.value > 0) {
      parent.drawTextureInterpolate(rect, texture, 0, 0, breeding.value, 1)
    } else if (progress.value > 0) {
      parent.drawTextureInterpolate(rect, texture, 0, 0, progress.value, 1)
    }
  }
}
