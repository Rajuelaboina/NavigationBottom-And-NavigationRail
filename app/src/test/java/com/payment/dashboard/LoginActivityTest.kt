package com.payment.dashboard

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LoginActivityTest{
    lateinit var loginActivity: LoginActivity

    @Before
    fun setUp(){
        loginActivity = LoginActivity()
    }
    @Test
    fun testValidUsername(){
      /*  val result = loginActivity.isValidUserName("")


        println("is User not username>>> :  $result")*/
    }


}