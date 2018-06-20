package com.nik.tutorial.scala.sort

import math.Ordering
/*
General merge sort algorithm implementation
 */
object MergeSort {
  def sort[T] (list:List[T], begin:Int,end:Int)(implicit  order:Ordering[T]):List[T] = {
    if(list.size==1 || list.isEmpty) {
      return list
    }
    else {
      val middle = list.size/2
      val listLeft:List[T] = sort(list.slice(begin,middle), 0, middle)
      val listRight:List[T] = sort(list.slice(middle,list.size), 0, end)
      var i,j:Int = 0
      var mergedList = List[T]()

      while(i<listLeft.size && j<listRight.size) {
        val leftValue = listLeft(i)
        val rightValue = listRight(j)
        if(order.compare(leftValue,rightValue) > 0) {
          mergedList = mergedList.:+(rightValue)
          j = j.+(1)
        }
        else {
          mergedList = mergedList.:+(leftValue)
          i =i.+(1)
        }
      }

      while (i<listLeft.size) {
        val leftValue = listLeft(i)
        i = i.+(1)
        mergedList = mergedList.:+(leftValue)
      }

      while (j<listRight.size) {
        val rightValue = listRight(j)
        mergedList = mergedList.:+(rightValue)
        j =j.+(1)
      }

      return mergedList
      }
  }

  def mergeSort[T](xs:List[T])(lt:(T,T)=>Boolean):List[T] = {
    val n = xs.length/2
    if(n==0) xs
    else {
      def merge(leftList: List[T], rightList: List[T]): List[T] =
        (leftList, rightList) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs, y :: ys) => {
            if (lt(x, y)) {
              x :: merge(xs, rightList)
            }
            else {
              y :: merge(leftList, ys)
            }
          }
        }
        val (fst, lst) = xs.splitAt(n)
        merge(mergeSort(fst)(lt),mergeSort(lst)(lt))
       }
  }

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) =
        xs span (y=>y.equals(x))
         first :: pack(rest)
       }

  def packEqual[T](xs: List[T]): List[List[T]] = {
    if(xs.size==0) Nil
    else {
      val x = xs.head
      val equalElementList = xs.filter(y=>y.equals(x))
      equalElementList::packEqual(xs.filterNot(y=>y.equals(x)))
    }
  }

  def main(args:Array[String]) {
    println("This is string")
    //val list = List(10,2,3,-40,50)
    //val list:List[Int] = List(10,2,3,-40,50,-90,-102,204,607)

    //println("List is -> " +sort(list,0,list.size-1))
    //println("Sorted List Is -> "+mergeSort(list)((x:Int,y:Int):Boolean = {return x<y}))
    val xs = packEqual(List("a", "a", "a", "b", "b","c", "c", "a","c"))
    println(xs)
  }
}
