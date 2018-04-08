package com.nik.tutorial.scala.list

class Empty extends Node {
  /**Always returns false as list is empty*/
  override def isEmpty():Boolean = {
    true
  }
  
  /**Always returns false as list is empty*/
  override def contains():Boolean = {
    return false
  }
}