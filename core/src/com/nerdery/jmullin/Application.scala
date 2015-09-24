package com.nerdery.jmullin

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.utils.Timer
import com.badlogic.gdx.{ApplicationAdapter, Gdx}

import scala.util.Random

class Application extends ApplicationAdapter {
  val random = new Random

  lazy val batch = new SpriteBatch()

  val world = new World(new Vector2(0, -10), true)

  val dukes = collection.mutable.Buffer[Duke]()

  override def create(): Unit = {
    Timer.schedule(new Timer.Task {
      override def run(): Unit = createDuke()
    }, 0.5f, 0.5f)

    new Barrier(world,
      new Vector2(0, 0).mul(World.screenToWorld),
      new Vector2(Gdx.graphics.getWidth, 0).mul(World.screenToWorld))
  }

  def createDuke(): Unit = {
    val duke = new Duke(world, new Vector2(random.nextFloat()*12f-6f, 14))
    duke.create()
    dukes.append(duke)
  }

  override def render(): Unit = {
    world.step(Gdx.graphics.getDeltaTime, 6, 2)

    Gdx.gl.glClearColor(1f, 1f, 1f, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    batch.begin()

    dukes.foreach(_.draw(batch))

    batch.end()
  }

  override def dispose(): Unit = {
    world.dispose()
  }
}
