package com.nerdery.jmullin

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.{World, FixtureDef, EdgeShape, BodyDef}

class Barrier(world: World, a: Vector2, b: Vector2) {
  val bodyDef = new BodyDef
  bodyDef.`type` = BodyDef.BodyType.StaticBody

  val shape = new EdgeShape()
  shape.set(a, b)

  val body = world.createBody(bodyDef)

  val fixtureDef = new FixtureDef
  fixtureDef.shape = shape

  body.createFixture(fixtureDef)

  shape.dispose()
}
