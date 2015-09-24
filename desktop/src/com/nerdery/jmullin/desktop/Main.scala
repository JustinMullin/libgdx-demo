package com.nerdery.jmullin.desktop

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}
import com.nerdery.jmullin.Application

object Main extends App {
  val config = new LwjglApplicationConfiguration
  new LwjglApplication(new Application, config)
}