package com.fby.codecollection.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button

/**

 * 作者：YS010051USR on 2021/9/3 14:28

 * 邮箱：fengboyang0412@gmail.com

 */
class FunctionClickView : androidx.appcompat.widget.AppCompatButton {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setOnClickFunctionListener(f: (View) -> Unit) {
        val clickListener = OnClickListener { view -> f.invoke(view) }
        setOnClickListener(clickListener)
    }
}