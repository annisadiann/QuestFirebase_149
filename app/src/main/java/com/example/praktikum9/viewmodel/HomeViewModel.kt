package com.example.praktikum9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.praktikum9.modeldata.DetailSiswa
import com.example.praktikum9.modeldata.UIStateSiswa
import com.example.praktikum9.modeldata.toDataSiswa
import com.example.praktikum9.repositori.RepositorySiswa

class EntryVieModel(private val repositorySiswa: RepositorySiswa): ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean
    {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, inEntryValid = validasiInput(
                detailSiswa
            ))
    }

    suspend fun addSiswa() {
        if (validasiInput()) {
            repositorySiswa.postDataSiswa(uiStateSiswa.detailSiswa.toDataSiswa())
        }
    }
}