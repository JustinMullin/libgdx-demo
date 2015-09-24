package com.nerdery.jmullin

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.{ApplicationAdapter, Gdx}

class Application extends ApplicationAdapter {
  lazy val batch = new SpriteBatch()

  val world = new World(new Vector2(0, -6), true)
  val duke = new Duke(world)

  override def create(): Unit = {
    duke.create()

    new Barrier(world,
      new Vector2(0, 0).mul(World.screenToWorld),
      new Vector2(Gdx.graphics.getWidth, 0).mul(World.screenToWorld))
  }

  override def render(): Unit = {
    world.step(Gdx.graphics.getDeltaTime, 6, 2)

    Gdx.gl.glClearColor(1f, 1f, 1f, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    batch.begin()

    duke.draw(batch)

    batch.end()
  }

  override def dispose(): Unit = {
    world.dispose()
  }
}
