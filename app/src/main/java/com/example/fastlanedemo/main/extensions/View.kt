package com.example.fastlanedemo.main.extensions

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.fastlanedemo.R

fun View.navigate(
    @IdRes resId: Int,
    args: Bundle? = null
) {
    val navOptions = NavOptions.Builder().apply {
        setEnterAnim(R.anim.slide_in)
        setExitAnim(R.anim.fade_out)
        setPopEnterAnim(R.anim.fade_in)
        setPopExitAnim(R.anim.slide_out)
    }.build()
    findNavController().navigate(resId, args, navOptions)
}
