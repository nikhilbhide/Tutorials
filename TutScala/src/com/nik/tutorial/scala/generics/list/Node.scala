package com.nik.tutorial.scala.generics.list

/** A simple node trait*/
trait Node[T] {
  def contains():Boolean
  def isEmpty(): Boolean
}