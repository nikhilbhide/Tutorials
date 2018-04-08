package com.nik.tutorial.scala.generics.list

object TestList {
  def main(args:Array[String]) {
    val l1 = new LinkedList[String]("10",null)
    val l2 = new LinkedList[String]("20",l1)
    val l3 = new LinkedList[String](" false",l2)
    val l4 = new LinkedList[String]("2050",l3)

    println(l4)
  }  
}