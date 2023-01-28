package com.rtech.sportapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rtech.sportapp.model.MatchDetailsModel
import com.rtech.sportapp.model.api_two_model.TeamDetailsModel
import kotlinx.coroutines.launch

class SportsViewModel : ViewModel() {
    private var service: SportApiService = RetrofitClient.sportService
    private var repo: SportRepository = SportRepository(service)

    private var _matchDataLiveData = MutableLiveData<MatchDetailsModel>()
    val matchDataLiveData: LiveData<MatchDetailsModel> = _matchDataLiveData

    private var _teamDataLiveData = MutableLiveData<TeamDetailsModel>()
    val teamDataLiveData: LiveData<TeamDetailsModel> = _teamDataLiveData

    // calling from View/Fragment/Activity
    fun callMatchApi() {
        viewModelScope.launch {
            val data = repo.getMatchDetails()
            _matchDataLiveData.value = data
        }
    }

    fun callTeamApi() {
        viewModelScope.launch {
            val data = repo.getTeamsDetails()
            _teamDataLiveData.value = data
        }
    }
}