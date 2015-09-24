package com.nerdery.jmullin

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch}
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d._

class Duke(world: World) {
  lazy val sprite = new Sprite(new Texture("duke.png"))

  val screenPosition = new Vector2()

  val bodyDef = new BodyDef
  bodyDef.`type` = BodyDef.BodyType.DynamicBody

  val body = world.createBody(bodyDef)

  val shape = new CircleShape()
  shape.setRadius(2)

  val fixtureDef = new FixtureDef
  fixtureDef.shape = shape
  fixtureDef.density = 1f

  val fixture = body.createFixture(fixtureDef)

  shape.dispose()

  def create(): Unit = {
    sprite.setScale(0.4f)
  }

  def draw(batch: SpriteBatch): Unit = {
    screenPosition.set(body.getPosition.mul(World.worldTransform))
    sprite.setPosition(screenPosition.x-sprite.getWidth/2f, screenPosition.y-sprite.getHeight/2f)
    sprite.setRotation(body.getTransform.getRotation)
    sprite.draw(batch)
  }
}
