package com.payment.dashboard

import androidx.navigation.NavController
import com.payment.dashboard.AllDestinations.EMAILS
import com.payment.dashboard.AllDestinations.HOME
import com.payment.dashboard.AllDestinations.MESSAGES

object  AllDestinations {
    const val HOME = "Home"
    const val EMAILS = "Emails"
    const val MESSAGES = "Messages"

}
class AppNavigationActions(val navController: NavController){
   fun navigateToHome(){
       navController.navigate(HOME){
           popUpTo(HOME)
       }
   }
    fun navigateToEmails(){
        navController.navigate(EMAILS){
            popUpTo(EMAILS)
        }
    }
    fun navigateToMessages(){
        navController.navigate(MESSAGES){
            popUpTo(MESSAGES)
        }
    }
}