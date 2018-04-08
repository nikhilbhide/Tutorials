package com.nik.tutorial.scala.list

object TestList {
  def main(args:Array[String]) {
    val l1:LinkedList = new LinkedList(10,null)
    val l2:LinkedList = new LinkedList(20,l1)
    val l3:LinkedList = new LinkedList(2000,l2)
    val l4:LinkedList = new LinkedList(2050,l3)

    println(l4)
  }  
}