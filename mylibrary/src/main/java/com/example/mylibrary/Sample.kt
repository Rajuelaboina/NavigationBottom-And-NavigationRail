package com.example.mylibrary

class Sample {
}
fun main(args:Array<String>){
         sum(10,20) { x, y -> println( x + y )}
        sub(6,8){x,y -> x-y}
       caluclator(10,20,::doSomething)
}

inline fun sub(x: Int, y: Int, ope: (Int,Int)->Int) {
            ope(x,y)
}

fun sum(x:Int,y:Int,operation:(Int,Int)->Unit){
          operation(x,y)
}
fun doSomething(x:Int,y:Int){
    println("this is dosomething add of ${x+y}")
}
fun caluclator(x: Int, y: Int, ope: (Int,Int) -> Unit){
        ope(x,y)
}