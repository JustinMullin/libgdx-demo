package com.nerdery.jmullin

import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch}
import com.badlogic.gdx.graphics.{GL20, Texture}
import com.badlogic.gdx.{ApplicationAdapter, Gdx}

class Application extends ApplicationAdapter {
  lazy val batch = new SpriteBatch()
  lazy val duke = new Sprite(new Texture("duke.png"))

  override def create(): Unit = {

  }

  override def render(): Unit = {
    Gdx.gl.glClearColor(1f, 1f, 1f, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    batch.begin()

    duke.draw(batch)

    batch.end()
  }
}
