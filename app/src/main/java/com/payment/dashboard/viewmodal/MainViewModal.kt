package com.payment.dashboard.viewmodal

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.payment.dashboard.apiservice.RetrofitInstance
import com.payment.dashboard.modal.ResidentCompleteSearchItem
import com.payment.dashboard.modal.StatesItem
import kotlinx.coroutines.launch

class MainViewModal : ViewModel() {
    private val apiService = RetrofitInstance.api
    val stateListResponse = mutableStateListOf<StatesItem>()
    fun getAllStates(){
       // stateListResponse.clear()
        stateListResponse.add(StatesItem("All"))
        viewModelScope.launch {
            val locationList = apiService.getStates()
            //stateListResponse = locationList
            stateListResponse.addAll(locationList)
        }
       // Log.e("stateListResponse","stateListResponse: ${stateListResponse.size}")
    }

    // Complete search --------------------------
    var residentCompleteSearchListResponse: List<ResidentCompleteSearchItem> by mutableStateOf(listOf())


    fun getResidentCompleteSearch(resident: String,location: String,pgy: String){
       // Log.e("View Size","residentCompleteSearchListResponse: {$resident $location  $pgy}")
        viewModelScope.launch {
            val completeList = apiService.getResidentCompleteSearch(resident,location,pgy)
            residentCompleteSearchListResponse = completeList
        }
       //Log.e("View Size","residentCompleteSearchListResponse: =: "+residentCompleteSearchListResponse.size)
    }

    val _completeResidentsList = MutableLiveData<List<ResidentCompleteSearchItem>> ()
    val list : LiveData<List<ResidentCompleteSearchItem>> = _completeResidentsList
    fun getResidentCompleteSearch2(resident: String,location: String,pgy: String){
        viewModelScope.launch {
            try {
               val completeList = apiService.getResidentCompleteSearch(resident,location,pgy)
                _completeResidentsList.value = completeList
            }catch (e: Exception){
               Log.e("Exception ><<<<<<<<<<<<<<<",e.message.toString())
            }
        }
       // Log.e("Exception ><<<<<<<<<<<<<<<",""+list.value?.size)
    }
}

/*
https://www.pdfgear.com/add-pages-to-pdf/
https://www.dochub.com/en/functionalities/insert-pages-into-a-pdf*/
