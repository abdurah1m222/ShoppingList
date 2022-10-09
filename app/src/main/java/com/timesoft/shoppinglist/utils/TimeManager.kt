package com.timesoft.shoppinglist.utils

import android.icu.text.SimpleDateFormat
import android.os.Build
import java.util.*

object TimeManager {

    fun getCurrentTime(): String {
        val formatter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            SimpleDateFormat("hh:mm:ss - yyyy/MM/dd", Locale.getDefault())
        } else TODO("VERSION.SDK_INT < N")
        return formatter.format(Calendar.getInstance().time)
    }
}