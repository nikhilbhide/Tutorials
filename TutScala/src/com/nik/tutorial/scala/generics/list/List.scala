package com.nik.tutorial.scala.generics.list

/** A simple node trait*/
trait List[T] {
  def contains():Boolean
  def isEmpty(): Boolean
}