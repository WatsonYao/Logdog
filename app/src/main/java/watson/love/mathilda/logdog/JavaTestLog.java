package watson.love.mathilda.logdog;

import mathilda.love.watson.logdog_core.Logdog;
import mathilda.love.watson.logdog_core.LogdogKt;

/** Created by Administrator on 12/15 0015. */
public class JavaTestLog {
  public void test() {
    LogdogKt.logi(this, "test in java1");
    Logdog.INSTANCE.i("test in java2", this);
  }
}
