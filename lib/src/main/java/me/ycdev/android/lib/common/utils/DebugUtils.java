package me.ycdev.android.lib.common.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;

public class DebugUtils {
    /**
     * Should only be invoked in debug version. Never invoke this method in release version!
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void enableStrictMode() {
        if (AndroidVersionUtils.hasGingerbread()) {
            // thread policy
            StrictMode.ThreadPolicy.Builder threadPolicyBuilder =
                    new StrictMode.ThreadPolicy.Builder()
                            .detectAll()
                            .penaltyLog()
                            .penaltyDeathOnNetwork();
            if (AndroidVersionUtils.hasHoneycomb()) {
                threadPolicyBuilder.penaltyFlashScreen();
            }
            StrictMode.setThreadPolicy(threadPolicyBuilder.build());

            // VM policy
            StrictMode.VmPolicy.Builder vmPolicyBuilder =
                    new StrictMode.VmPolicy.Builder()
                            .detectAll()
                            .penaltyLog()
                            .penaltyDeath();
            StrictMode.setVmPolicy(vmPolicyBuilder.build());
        }
    }
}
