package com.example.praktikum9.view.route

import com.example.praktikum9.R

object DestinasiEdit : DestinasiNavigasi{
    override val route = "item_edit"
    override val titleRes =  R.string.edit_siswa

    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}