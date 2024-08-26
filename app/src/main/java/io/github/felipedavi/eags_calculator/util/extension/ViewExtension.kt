package io.github.felipedavi.eags_calculator.util.extension

import android.os.Build
import android.view.View
import android.view.WindowInsets
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
fun View.hideKeyboard(view: View) {
    windowInsetsController?.hide(WindowInsets.Type.ime())
    view.clearFocus()
}

@RequiresApi(Build.VERSION_CODES.R)
fun View.showKeyboard(view: View) {
    windowInsetsController?.show(WindowInsets.Type.ime())
    view.requestFocus()
}
