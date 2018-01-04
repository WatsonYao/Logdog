package watson.love.mathilda.logdog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mathilda.love.watson.logdog.core.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logi("test i")
        logd("test d")
        logv("test v")
        logw("test w")
        loge("test e")
        loge(NullPointerException("test exception"))

        Inner()

        JavaTestLog().test()
    }

    class Inner {
        init {
            logi("test inner")
        }
    }

}
