package com.nerdery.jmullin

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch}
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d._

class Duke(world: World, startPosition: Vector2) {
  lazy val sprite = new Sprite(new Texture("duke.png"))

  val screenPosition = new Vector2()

  val bodyDef = new BodyDef
  bodyDef.`type` = BodyDef.BodyType.DynamicBody
  bodyDef.position.set(startPosition)

  val body = world.createBody(bodyDef)

  val shape = new PolygonShape()
  shape.set(Array(
    new Vector2(-1.2f, -1.5f),
    new Vector2(1.2f, -1.5f),
    new Vector2(1.2f, 0),
    new Vector2(0, 1.5f),
    new Vector2(-1.2f, 0)
  ))

  val fixtureDef = new FixtureDef
  fixtureDef.shape = shape
  fixtureDef.density = 1f

  val fixture = body.createFixture(fixtureDef)

  shape.dispose()

  def create(): Unit = {
    sprite.setScale(0.4f)
  }

  def draw(batch: SpriteBatch): Unit = {
    screenPosition.set(body.getPosition.mul(World.worldToScreen))
    sprite.setPosition(screenPosition.x-sprite.getWidth/2f, screenPosition.y-sprite.getHeight/2f)
    sprite.setRotation(body.getAngle*180f/Math.PI.toFloat)
    sprite.draw(batch)
  }
}
