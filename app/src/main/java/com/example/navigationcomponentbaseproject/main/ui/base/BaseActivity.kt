package com.example.navigationcomponentbaseproject.main.ui.base

import android.graphics.Rect
import android.view.MotionEvent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationcomponentbaseproject.main.extensions.hideKeyboard

abstract class BaseActivity : AppCompatActivity() {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (view is EditText) {
                val outRect = Rect()
                view.getGlobalVisibleRect(outRect)
                if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
                    view.clearFocus()
                    view.hideKeyboard()
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}
