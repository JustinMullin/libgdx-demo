package com.nerdery.jmullin

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Matrix3

object World {
  lazy val worldToScreen = new Matrix3()
    .translate(Gdx.graphics.getWidth/2f, Gdx.graphics.getHeight/2f)
    .scale(20f, 20f)
  
  lazy val screenToWorld = new Matrix3(worldToScreen).inv()
}
