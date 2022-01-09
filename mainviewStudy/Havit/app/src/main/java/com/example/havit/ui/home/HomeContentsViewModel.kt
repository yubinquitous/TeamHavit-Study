package com.example.havit.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeContentsViewModel : ViewModel() {

    private val _contentsList = MutableLiveData<List<HomeContentsData>>()
    val contentsList: LiveData<List<HomeContentsData>> = _contentsList

    fun requestContentsTaken() {
        val list = listOf(
            HomeContentsData("카테고리 이름1", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
            HomeContentsData("카테고리 이름2", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
            HomeContentsData("카테고리 이름3", "헤더입니다", "2021.11.24"),
            HomeContentsData("카테고리 이름4", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
            HomeContentsData("카테고리 이름5", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
            HomeContentsData("카테고리 이름6", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
            HomeContentsData("카테고리 이름7", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
            HomeContentsData("카테고리 이름8", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24")
        )
        _contentsList.value = list

//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                // 더미데이터
//                val list = listOf(
//                    HomeContentsData("카테고리 이름1", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                    HomeContentsData("카테고리 이름2", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                    HomeContentsData("카테고리 이름3", "헤더입니다", "2021.11.24"),
//                    HomeContentsData("카테고리 이름4", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                    HomeContentsData("카테고리 이름5", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                    HomeContentsData("카테고리 이름6", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                    HomeContentsData("카테고리 이름7", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                    HomeContentsData("카테고리 이름8", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24")
//                )
//                Log.d("homecontentsvm try", "homecontentsvm try")
//                _contentsList.postValue(list)
//                Log.d("postValue(list)", "${list}")
//            } catch (e: HttpException) {
//                Log.d("homecontentsvm error", "homecontentsvm error")
//            }
//        }
    }
}