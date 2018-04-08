package com.nik.tutorial.scala.generics.list

class LinkedList[T] (val value:T,val next:LinkedList[T]) extends Node[T] {
	/**Always returns false as list is non empty*/
	override def isEmpty():Boolean = {
			false
	}

	/** returns true if value is not null otherwise false*/
	override def contains():Boolean = {
			if(value!=null)
				true
				else 
					false
	}

	/** retrieves the value from node */
	def getValue():T = {
			value
	}

	/** retrieves rest of the list*/
	def getNext():LinkedList[T] = {
			next
	}

	override def toString():String = {
			if(next!=null && !next.isEmpty())
				value.toString() + "-" + next
				else 
					value.toString()
	}
}