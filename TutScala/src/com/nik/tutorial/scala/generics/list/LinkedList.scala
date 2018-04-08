package com.nik.tutorial.scala.generics.list

class LinkedList[T] (val head:T,val tail:LinkedList[T]) extends List[T] {
	/**Always returns false as list is non empty*/
	override def isEmpty():Boolean = {
			false
	}

	/** returns true if value is not null otherwise false*/
	override def contains():Boolean = {
			if(head!=null)
				true
				else 
					false
	}

	/** retrieves the value from node */
	def getValue():T = {
			head
	}

	/** retrieves rest of the list*/
	def getTail():LinkedList[T] = {
			tail
	}

	override def toString():String = {
			if(tail!=null && !tail.isEmpty())
				head.toString() + "-" + tail
				else 
					head.toString()
	}	
}