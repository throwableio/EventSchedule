package io.throwable.eventschedule

import android.app.Activity
import android.arch.lifecycle.*
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import io.throwable.eventschedule.di.Injector

val Activity.app: App get() = application as App

fun AppCompatActivity.getAppInjector(): Injector = (app).injector

fun toast(message: String, context: Context) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View = LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun ProgressBar.showProgress(){
    visibility = View.VISIBLE
}

fun ProgressBar.hideProgress(){
    visibility = View.GONE
}

/**
 * util method to convert the view to a bitmap to be used on the map
 * @param string - value to be used
 * @return
 */
fun View.toMarkerBitmap(string: String):Bitmap{
    val venueTextview = this.findViewById<TextView>(R.id.textView_venue_name)
    venueTextview.text = string
    measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
    layout(0, 0, this.measuredWidth, this.measuredHeight)
    val returnedBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight,
            Bitmap.Config.ARGB_8888)
    val canvas = Canvas(returnedBitmap)
    canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN)
    val drawable = background

    drawable?.draw(canvas)
    draw(canvas)
    return returnedBitmap
}

fun Drawable.toBitmapDescriptor():BitmapDescriptor {
   setBounds(0, 0, intrinsicWidth, intrinsicHeight)
    val bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bitmap)
}


inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.withViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}