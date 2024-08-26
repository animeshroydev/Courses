package com.appmakerszone.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Courses(

    @StringRes
    val stringResourceId: Int,

    val num: Int,

    @DrawableRes
    val imgResourceId: Int,



)
