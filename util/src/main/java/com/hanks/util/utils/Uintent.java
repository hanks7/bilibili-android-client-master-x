package com.hanks.util.utils;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hanks.util.R;


/**
 * intent请求工具，提供了默认的进出动画及自定义动画等
 */
public class Uintent {

    /**
     * IntentUtil默认的跳转动画 使用前需要预先设置
     */
    public static int INTENT_DEFAULT_ENTER_ANIM = R.anim.push_right_in;
    public static int INTENT_DEFAULT_EXIT_ANIM = R.anim.push_left_out;
    private static Intent intent;

    /**
     * 设置返回键触发时的动画效果 使用前需要预先设置
     */
    public static int FINISH_DEFAULT_ENTER_ANIM = R.anim.push_left_in;
    public static int FINISH_DEFAULT_EXIT_ANIM = R.anim.push_right_out;

    /**
     * 从下到上跳转动画
     */
    public static int INTENT_BOTTOM_TO_TOP = R.anim.push_bottom_in;
    public static int INTENT_TOP_TO_BOTTOM = R.anim.push_top_out;
    public static int INTENT_TOP_TO_BOTTOM_OUT = R.anim.push_top_in;
    public static int INTENT_BOTTOM_TO_TOP_OUT = R.anim.push_bottom_out;


    /**
     * 自定义动画 使用 DEFAULT_ENTER_ANIM 和 DEFAULT_EXIT_ANIM 作为动画效果
     *
     * @param activity Activity
     * @param classes  目标类
     */
    public static void intentDIYLeftToRight(Activity activity, Class<?> classes) {
        intentDIYLeftToRight(activity, classes, null);
    }

    /**
     * 自定义动画 使用 DEFAULT_ENTER_ANIM 和 DEFAULT_EXIT_ANIM 作为动画效果
     *
     * @param activity Activity
     * @param classes  目标类
     */
    public static void intentDIYLeftToRight(Activity activity, Class<?> classes, Bundle bundle) {
        intentDIYLeftToRight(activity, classes, bundle, INTENT_DEFAULT_ENTER_ANIM, INTENT_DEFAULT_EXIT_ANIM);
    }

    /**
     * 自定义动画
     *
     * @param activity  Activity
     * @param classes   目标类
     * @param enterAnim enter资源ID
     * @param exitAnim  exit资源ID
     */
    public static void intentDIYLeftToRight(Activity activity, Class<?> classes, int enterAnim, int exitAnim) {
        intentDIYLeftToRight(activity, classes, null, enterAnim, exitAnim);
    }

    /**
     * 自定义动画
     *
     * @param activity  Activity
     * @param classes   目标类
     * @param enterAnim enter资源ID
     * @param exitAnim  exit资源ID
     */
    public static void intentDIYLeftToRight(final Activity activity, final Class<?> classes, final Bundle bundle, final int enterAnim,
                                            final int exitAnim) {
        Intent intent = new Intent(activity, classes);
        organize(intent, bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }

    public static void intentResultDIY(Activity activity, Class<?> classes, int requestCode) {
        intentResultDIY(activity, classes, requestCode, null, INTENT_DEFAULT_ENTER_ANIM, INTENT_DEFAULT_EXIT_ANIM);
    }

    public static void intentResultDIY(Activity activity, Class<?> classes, Bundle bundle, int requestCode) {
        intentResultDIY(activity, classes, requestCode, bundle, INTENT_DEFAULT_ENTER_ANIM, INTENT_DEFAULT_EXIT_ANIM);
    }

    public static void intentResultDIY(Activity activity, Class<?> classes, int requestCode, int enterAnim, int exitAnim) {
        intentResultDIY(activity, classes, requestCode, null, enterAnim, enterAnim);
    }

    public static void intentResultDIY(final Activity activity, final Class<?> classes, final int requestCode, final Bundle bundle, final int enterAnim, final int exitAnim) {
        Intent intent = new Intent(activity, classes);
        organize(intent, bundle);
        activity.startActivityForResult(intent, requestCode);
        if (enterAnim != 0 && exitAnim != 0) {
            activity.overridePendingTransition(enterAnim, exitAnim);
        }
    }

    /**
     * 从下向上滑入
     *
     * @param activity
     * @param cls
     */
    public static void intentDIYBottomToTop(final Activity activity, final Class<?> cls) {
        intentDIYBottomToTop(activity, cls, null);
    }

    public static void intentDIYBottomToTop(Activity activity, Class<?> classes, Bundle bundle) {
        intentDIYBottomToTop(activity, classes, bundle, INTENT_BOTTOM_TO_TOP, INTENT_TOP_TO_BOTTOM);
    }

    public static void intentDIYBottomToTop(final Activity activity, final Class<?> classes, final Bundle bundle, final int enterAnim,
                                            final int exitAnim) {
        Intent intent = new Intent(activity, classes);
        organize(intent, bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }


    /**
     * 关闭Activity时产生的动画,从右从左退出
     *
     * @param activity Activity
     */
    public static void finishDIYLeftToRight(final Activity activity) {
        activity.finish();
        activity.overridePendingTransition(FINISH_DEFAULT_ENTER_ANIM, FINISH_DEFAULT_EXIT_ANIM);
    }

    public static void finishDIYBottomToTop(final Activity activity) {
        activity.finish();
        activity.overridePendingTransition(INTENT_TOP_TO_BOTTOM_OUT, INTENT_BOTTOM_TO_TOP_OUT);
    }

    /**
     * 关闭Activity时产生的动画
     *
     * @param activity  Activity
     * @param enterAnim 进入动画
     * @param exitAnim  退出动画
     */
    public static void finishDIY(final Activity activity, final int enterAnim, final int exitAnim) {
        activity.finish();
        activity.overridePendingTransition(enterAnim, exitAnim);
    }
    /**
     * 关闭Activity时产生的动画
     *
     * @param activity Activity
     */
    public static void finishDIY(final Activity activity) {
        finishDIY(activity, FINISH_DEFAULT_ENTER_ANIM, FINISH_DEFAULT_EXIT_ANIM);
    }


    /**
     * 自定义动画 使用 DEFAULT_ENTER_ANIM 和 DEFAULT_EXIT_ANIM 作为动画效果
     *
     * @param activity Activity
     * @param classes  目标类
     */
    public static void intentDIY(Activity activity, Class<?> classes) {
        intentDIY(activity, classes, null);
    }

    /**
     * 自定义动画 使用 DEFAULT_ENTER_ANIM 和 DEFAULT_EXIT_ANIM 作为动画效果
     *
     * @param activity Activity
     * @param classes  目标类
     */
    public static void intentDIY(Activity activity, Class<?> classes, Bundle bundle) {
        intentDIY(activity, classes, bundle, INTENT_DEFAULT_ENTER_ANIM, INTENT_DEFAULT_EXIT_ANIM);
    }
    /**
     * 自定义动画
     *
     * @param activity  Activity
     * @param classes   目标类
     * @param enterAnim enter资源ID
     * @param exitAnim  exit资源ID
     */
    public static void intentDIY(final Activity activity, final Class<?> classes, final Bundle bundle, final int enterAnim,
                                 final int exitAnim) {
        intent = new Intent(activity, classes);
        organize(intent, bundle);
        start(activity);
        if (enterAnim != 0 && exitAnim != 0) {
            activity.overridePendingTransition(enterAnim, exitAnim);
        }
    }
    private static void start(final Activity activity) {
        activity.startActivity(intent);
    }
    /**
     * 系统默认
     *
     * @param activity Activity
     * @param classes  目标
     */
    public static void intentSysDefault(final Activity activity, final Class<?> classes, final Bundle bundle) {
        Intent intent = new Intent(activity, classes);
        organize(intent, bundle);
        activity.startActivity(intent);
    }

    /**
     * 整理参数
     *
     * @param intent Intent
     */
    private static void organize(final Intent intent, final Bundle bundle) {
        if (bundle == null)
            return;
        intent.putExtras(bundle);
    }
}
