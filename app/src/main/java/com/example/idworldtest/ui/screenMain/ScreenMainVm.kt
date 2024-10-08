package com.example.idworldtest.ui.screenMain

import androidx.lifecycle.ViewModel
import com.example.idworldtest.domain.ClientResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ScreenMainVm @Inject constructor(
    private val clientResourceProvider: ClientResourceProvider
) : ViewModel() {
    private val _uiState = MutableStateFlow(ScreenMainView.Model())
    val uiState: StateFlow<ScreenMainView.Model> = _uiState.asStateFlow()


    fun getData() {
        _uiState.update {
            it.copy(
                operatorText = clientResourceProvider.getClientName(),
                operatorColor = clientResourceProvider.getClientColor()
            )
        }
    }

}