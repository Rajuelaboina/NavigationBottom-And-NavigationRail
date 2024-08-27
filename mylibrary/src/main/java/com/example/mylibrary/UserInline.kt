package com.example.mylibrary

class UserInline {
}
fun main(){

   someHighOrderFunction{
       println(it)
   }
}
inline fun someHighOrderFunction(crossinline orderFUn:(String)-> Unit){

    anotherHigherOrderFunction{
        orderFUn("")
    }
}
fun anotherHigherOrderFunction (anotherLambda:()-> Unit){
     anotherLambda()
}