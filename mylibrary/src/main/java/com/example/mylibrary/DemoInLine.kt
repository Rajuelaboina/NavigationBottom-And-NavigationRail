package com.example.mylibrary

class DemoInLine {
}
fun main(){
      // userInLine(){ println("calling inline functions") }
    foo()
}
inline fun ordinaryFunction(black:()-> Unit){
    println("hi")
}
fun foo(){
    ordinaryFunction(){
        return
    }
}
/*inline fun userInLine(userCourse:()-> Unit) {
    userCourse()
    print("code inside inline function")
}*/


