package com.nik.tutorial.scala

import scala.math.Ordering

abstract class  Node [T] {
  var links:Links[T] = Links(null,null,null)
  var left:Node[T]=null
  var right:Node[T] = null
  var parent:Node[T] = null
  def add(x:T, parent:Node[T], direction:Int)(implicit  order:Ordering[T]):Node[T]
  def contains(x:T)(implicit  order:Ordering[T]):Boolean
  def getElement():T = {
    null.asInstanceOf[T]
  }

  def remove(x:T)(implicit  order:Ordering[T]):Node[T] = {
    null
  }

  def getNodeByValue(x:T)(implicit  order:Ordering[T]):Node[T] = {
    return null
  }
  def isLeafNode():Boolean = {
    true
  }
}

case class Links[T](var parent:Node[T],var left:Node[T],var right:Node[T])

class NonEmptyNode [T] (element:T,  var parent1:Node[T],  var left1:Node[T],  var right1:Node[T],f:(T,T)=>Boolean) extends Node[T] {
  links.left = left
  links.right = right1
  this.left=left1
  this.right=right1
  this.parent=parent1

  if(parent==null) {
    links.parent = parent1
    this.parent = parent1
  }
  else {
    links.parent = parent1
    this.parent = parent1
  }

  def add(x: T,node:Node[T],direction:Int)(implicit  order:Ordering[T]): Node[T] = {
    println("executing NonEmptyNode")
    if(order.compare(x,element)<1 || order.compare(x,element)==0) {
      if(this.left.isInstanceOf[EmptyNode[T]]) {
        val newNode = new NonEmptyNode[T](x,node,new EmptyNode(f),new EmptyNode(f),f)
        this.left = newNode
        this
      }
      else add(x,this.left,1)
    }
    else {
      if(node.right.isInstanceOf[EmptyNode[T]]) {
        val newNode = new NonEmptyNode[T](x,node,new EmptyNode(f),new EmptyNode(f),f)
        this.right = newNode
        this
      }
      else add(x,this.right,2)
    }
    // if(f(element,x))
    //if (x < element) {
    /*if(order.compare(element,x)>0) {
      new NonEmptyNode(element,parent, left.add(x,parent,1), right,f)
    }
    else if(order.compare(element,x)<0) {
      println("executing else if")
      new NonEmptyNode(x, parent, left, right.add(x,parent,2),f)
    }
    else {
      println("executing null")
      null
    }*/
  }

  def contains(x:T)(implicit  order:Ordering[T]) : Boolean = {
    if(order.compare(element,x)>0) {
      left.contains(x)
    }
    else if(order.compare(element,x)<0) {
      right.contains(x)
    }
    else {
      true
    }
  }

  override def getNodeByValue(x:T)(implicit  order:Ordering[T]):Node[T] = {
    if(order.compare(element,x)>0) {
      left.getNodeByValue(x)
    } else if(order.compare(element,x)<0)
      right.getNodeByValue(x)
    else this
  }

  override def isLeafNode():Boolean = {
    this.left.links.left==null && this.right.links.right==null
  }

  override def getElement(): T = {
    element
  }

  override def remove(x:T)(implicit  order:Ordering[T]) : Node[T] = {
    val nodeToRemove = getNodeByValue(x)
    if(nodeToRemove.isLeafNode()) {
      if(nodeToRemove.parent!=null) {
        if(nodeToRemove.parent.left==nodeToRemove) {
          nodeToRemove.parent.left=new EmptyNode[T](null)
        }
      }
      else {
        nodeToRemove.links.parent.links.right=null
      }
    }
    this
  }

  override def toString: String = {
    "Element Value is "+element+" Left value is " + left.toString + " Right value is"+ right.toString
  }
}

class EmptyNode[T] (f:(T,T)=>Boolean) extends Node [T] {
  def add(x:T,parent:Node[T],direction:Int) (implicit  order:Ordering[T]):Node[T] = {
    val node = new NonEmptyNode[T](x,parent,new EmptyNode(f),new EmptyNode(f),f)
    println("Node is"+node.getElement())
    if(direction==1) {
      parent.links.left = node
      parent.left=node
    }
    else {
      parent.links.right = node
      parent.right = node
    }
    println("Node parent is - "+parent)
    node
  }

  def contains(x:T)(implicit  order:Ordering[T]):Boolean = {
    false
  }

  override def toString: String = {
    " Empty"
  }
}

object BinaryTreeDemo {
  def main(args:Array[String]): Unit = {
    println("hehehe popat")
    val f = (x:String,y:String)=> {
      if(x>=y) true
      else false
    }

    var tree = new NonEmptyNode[String]("B",null,new EmptyNode[String](f), new EmptyNode[String](f),f)
    var tree1 = tree.add("A",tree,1)
    println(tree1.toString)
    println(tree1.contains("B"))
    var success = tree1.remove("A")
   // println(success.toString)
    println(success)
    println(success.hashCode())

  }
}
