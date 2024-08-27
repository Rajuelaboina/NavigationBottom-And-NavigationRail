package com.example.mylibrary

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

class UserKotlin {
}
fun main() {
 /*   val timeInMills = measureTimeMillis {
        exampleCoroutineScope()
    }
    println("Time : $timeInMills")*/
   //  ----        Remove duplicates from array
    /*  ----   distinct()
                toSet()
               toMutableSet()
               toHashSet()            */

   /* val items = arrayOf("Android","java","Android","java",1,2,1,2,1)
    val dis = items.distinct()
    dis.forEach {
        print(" "+it)
    }
    println()

    dis.forEach {
        print(" "+ it)
    }*/
    val str = "android"
    val str1 = "android"
    val str2 = String().plus("android")
  //  println(str==str1)

  //  println(str===str1)
   // println(str==str2)
   // println(str===str2)
     val some:(Int,Int)->Int = {a,b -> a+b}
     val some1:(a:Int,b:Int)->Unit = {x,y -> x+y}

    someSquare(10,20,{a:Int,b:Int-> a+b})
    someSquare(10,20){a,b-> print(a*b)}
}
fun someSquare(a:Int,b:Int,ope:(Int,Int)->Unit){
    ope(a,b)
}
fun addSomething(abc:()-> Unit){
    abc()
}
fun abc(a:Int,b:Int):Int{
     return a+b
}
/*
fun exampleCoroutineScope() = runBlocking {
    (1..10).forEach {
        launch(Dispatchers.Default) {
            coroutineScope {
                println("Coroutine $it started on thread: ${Thread.currentThread().name}")
                delay(500)
                println("Coroutine $it completed on thread: ${Thread.currentThread().name}")
            }
        }
    }
}*/
/*
fun exampleRunBlocking() = runBlocking {
    (1..10).forEach {
        launch(context) {
            runBlocking {
                println("runBlocking $it started on ${Thread.currentThread().name}")
                delay(500)
                println("runBlocking $it ended on ${Thread.currentThread().name}")
            }
        }
    }
}*/
