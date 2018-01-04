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
    fun i(msg: Any, className: Any) {
        if (enable) Log.i(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    fun d(msg: Any, className: Any) {
        if (enable) Log.d(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    fun v(msg: Any, className: Any) {
        if (enable) Log.v(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    fun w(msg: Any, className: Any) {
        if (enable) Log.w(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    fun e(msg: Any, className: Any) {
        if (enable) Log.e(tag, getFunName(className) + msg)
    }

    /**
     *
     */
    fun e(exception: Exception, className: Any) {
        exception.printStackTrace()
        Log.e(tag, getFunName(className), exception)
    }
}

/**
 *
 */
private fun getFunName(name: Any): String {
    val sts = Thread.currentThread().stackTrace ?: return ""
    sts.filter {
        !it.isNativeMethod
                && it.className != Thread::class.java.getName()
                && it.className == name.javaClass.getName()
    }.forEach {
        return " [ ${Thread.currentThread().name}:(${it.fileName}:${it.lineNumber}) ${it.methodName} ] - "
    }
    return ""
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
