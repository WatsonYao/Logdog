package mathilda.love.watson.logdog.lib;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.HashMap;

/**
 * 调试日志，发布正式版本时，请将IS_SHOW置位成false;
 *
 * @author Administrator
 */
public class LogDog {
    private final static boolean IS_SHOW = true;
    public final static String TAG = "ranshao";
    private final static int LEVEL = Log.VERBOSE;
    private static HashMap<String, MyLogger> LOG_TABLE = new HashMap<>();
    private static MyLogger INSTANCE;
    private String className;

    private MyLogger(String name) {
        className = name;
    }

    /**
     * @param otherTag
     * @return
     */
    @SuppressWarnings("unused")
    private static MyLogger log(String otherTag) {
        MyLogger classLogger = LOG_TABLE.get(otherTag);
        if (classLogger == null) {
            classLogger = new MyLogger(otherTag);
            LOG_TABLE.put(otherTag, classLogger);
        }
        return classLogger;
    }

    /**
     * Purpose:Mark user two
     *
     * @return
     */
    public static MyLogger log() {
        if (INSTANCE == null) {
            INSTANCE = new MyLogger("");
        }
        return INSTANCE;
    }

    /**
     * Get The Current Function Name
     *
     * @return
     */
    private String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }
        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(this.getClass().getName())) {
                continue;
            }
            return className + "[ " + Thread.currentThread().getName() + ": " + st.getFileName() + ":" + st.getLineNumber() + " " + st.getMethodName() + " ]";
        }
        return null;
    }

    /**
     * The Log Level:i
     *
     * @param str
     */
    public void i(Object str) {
        if (IS_SHOW) {
            if (LEVEL <= Log.INFO) {
                String name = getFunctionName();
                if (name != null) {
                    Log.i(TAG, name + " - " + str);
                } else {
                    Log.i(TAG, str.toString());
                }
            }
        }

    }

    public void i(Context context, Object str) {
        if (IS_SHOW) {
            if (LEVEL <= Log.INFO) {
                String name = getFunctionName();
                if (name != null) {
                    Log.i(TAG, name + " - " + str);
                    context.sendBroadcast(new Intent().setAction("w.m.data").putExtra("data", name + " - " + str));
                } else {
                    Log.i(TAG, str.toString());
                    context.sendBroadcast(new Intent().setAction("w.m.data").putExtra("data", str.toString()));
                }
            }
        }

    }

    /**
     * The Log Level:d
     *
     * @param str
     */
    public void d(Object str) {
        if (IS_SHOW) {
            if (LEVEL <= Log.DEBUG) {
                String name = getFunctionName();
                if (name != null) {
                    Log.d(TAG, name + " - " + str);
                } else {
                    Log.d(TAG, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:V
     *
     * @param str
     */
    public void v(Object str) {
        if (IS_SHOW) {
            if (LEVEL <= Log.VERBOSE) {
                String name = getFunctionName();
                if (name != null) {
                    Log.v(TAG, name + " - " + str);
                } else {
                    Log.v(TAG, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:w
     *
     * @param str
     */
    public void w(Object str) {
        if (IS_SHOW) {
            if (LEVEL <= Log.WARN) {
                String name = getFunctionName();
                if (name != null) {
                    Log.w(TAG, name + " - " + str);
                } else {
                    Log.w(TAG, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     *
     * @param str
     */
    public void e(Object str) {
        if (IS_SHOW) {
            if (LEVEL <= Log.ERROR) {
                String name = getFunctionName();
                if (name != null) {
                    Log.e(TAG, name + " - " + str);
                } else {
                    Log.e(TAG, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     *
     * @param ex
     */
    public void e(Exception ex) {
        if (IS_SHOW) {
            if (LEVEL <= Log.ERROR) {
                Log.e(TAG, "error", ex);
            }
        }
    }

    /**
     * The Log Level:e
     *
     * @param log
     * @param tr
     */
    public void e(String log, Throwable tr) {
        if (IS_SHOW) {
            String line = getFunctionName();
            Log.e(TAG, "{Thread:" + Thread.currentThread().getName() + "}" + "[" + className + line + ":] " + log + "\n", tr);
        }
    }
}
