package com.ardyyy.dev.androidmvvm.utils

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

fun createCircularProgress(context: Context): CircularProgressDrawable {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    return circularProgressDrawable
}