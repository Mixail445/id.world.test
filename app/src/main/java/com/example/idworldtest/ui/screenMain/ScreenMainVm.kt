package com.example.idworldtest.ui.screenMain

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.idworldtest.domain.ClientResourceProvider
import com.example.idworldtest.domain.SelectMobileServiceType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ScreenMainVm @Inject constructor(
    private val mobRep: SelectMobileServiceType,
    private val clientResourceProvider: ClientResourceProvider
) : ViewModel() {
    private val _uiState = MutableStateFlow(ScreenMainView.Model())
    val uiState: StateFlow<ScreenMainView.Model> = _uiState.asStateFlow()


    suspend fun getData() {
        _uiState.update {
            it.copy(
                operatorText = clientResourceProvider.getClientName(),
                operatorColor = clientResourceProvider.getClientColor()
            )
        }
        withContext(Dispatchers.IO) {
            mobRep(SelectMobileServiceType.Case.Location).onSuccess { serviceT ->
                Log.d("ServiceT", serviceT.toString())
            }
        }

    }
}