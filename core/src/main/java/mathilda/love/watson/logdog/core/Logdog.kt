package mathilda.love.watson.logdog.core

/**
 * Created by watsonyao .
 */
import android.util.Log

/**
 *
 */
object Logdog {

    var enable = true
    var tag = "appTag"

    /**
     *
     */
    inline fun i(msg: Any, className: Any) {
        if (enable) Log.i(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    inline fun d(msg: Any, className: Any) {
        if (enable) Log.d(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    inline fun v(msg: Any, className: Any) {
        if (enable) Log.v(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    inline fun w(msg: Any, className: Any) {
        if (enable) Log.w(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    inline fun e(msg: Any, className: Any) {
        if (enable) Log.e(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    inline fun e(exception: Exception, className: Any) {
        exception.printStackTrace()
        Log.e(tag, getFunName(className), exception)
    }
}

/**
 *
 */
inline fun getFunName(name: Any): String {
    val ste = Throwable().stackTrace[1]
    var traceInfo = "(" + ste.fileName + ":"
    traceInfo += ste.lineNumber.toString() + "):"
    traceInfo += ste.methodName
//    android.util.Log.i("appTag", traceInfo + traceInfo)
    return "[ ${Thread.currentThread().name}:$traceInfo] - "
}


/**
 *
 */
fun Any.logi(msg: Any) {
    Logdog.i(msg, this)
}

/**
 *
 */
fun Any.logd(msg: Any) {
    Logdog.d(msg, this)
}

/**
 *
 */
fun Any.logv(msg: Any) {
    Logdog.v(msg, this)
}

/**
 *
 */
fun Any.logw(msg: Any) {
    Logdog.w(msg, this)
}

/**
 *
 */
fun Any.loge(msg: Any) {
    Logdog.e(msg, this)
}

/**
 *
 */
fun Any.loge(exception: Exception) {
    Logdog.e(exception, this)
}
