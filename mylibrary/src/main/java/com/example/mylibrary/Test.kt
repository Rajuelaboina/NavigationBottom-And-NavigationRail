package com.example.mylibrary

class Test {

}
fun main(){
    caluclator2(10,20){x,y-> x+y}
    evenNum(2){x-> if (x%2==0) println("this is even") else println("add") }
    val sum:(Int,Int)->Unit = {x,y -> x+y}
    sum(10,20){x,y -> x+y}
}
fun evenNum(x:Int, operation: (Int) -> Unit){
            operation(x)
}
fun caluclator2(x:Int,y:Int,operation:(Int,Int)->Int){
    operation(x,y)
}