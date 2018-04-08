package com.nik.tutorial.scala.generics.list

class Empty[T] extends Node[T] {
  /**Always returns false as list is empty*/
  override def isEmpty():Boolean = {
    true
  }
  
  /**Always returns false as list is empty*/
  override def contains():Boolean = {
    return false
  }
}