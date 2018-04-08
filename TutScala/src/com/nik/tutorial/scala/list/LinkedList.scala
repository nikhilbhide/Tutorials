package com.nik.tutorial.scala.list

class LinkedList (val value:Int,val next:LinkedList) extends Node {
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
	def getValue():Int = {
			value
	}

	/** retrieves rest of the list*/
	def getNext():LinkedList = {
			next
	}

	override def toString():String = {
			if(next!=null && !next.isEmpty())
				value.toString() + "-" + next
				else 
					value.toString()
	}
}