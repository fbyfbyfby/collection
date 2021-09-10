package com.fby.codecollection.util

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.res.Resources
import android.util.TypedValue

/**

 * 作者：YS010051USR on 2021/9/3 09:49

 * 邮箱：fengboyang0412@gmail.com

 */
fun getActivities(context: Context): ArrayList<ActivityInfo> {
    var activities = ArrayList<ActivityInfo>()
    val packageInfo =
        context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_ACTIVITIES)
    for (info: ActivityInfo in packageInfo.activities) {
        activities.add(info)
    }
    return activities
}

val Float.px
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )
val Float.dp
    get() = this / Resources.getSystem().displayMetrics.density + 0.5f
val Int.dp
    get() = this.toFloat().dp