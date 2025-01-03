/*
 * Copyright (C) 2022 The PixelExperience Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.pixelexperience.systemui.columbus;

import android.os.SystemProperties;

public class ColumbusCompatibilityHelper {
    static {
        configureApSensor();
    }

    private static void configureApSensor() {
        boolean isPixelDevice = SystemProperties.get("ro.soc.manufacturer").equalsIgnoreCase("Google");
        String model = SystemProperties.get("ro.product.model");
        if (isPixelDevice && model != null) {
            boolean isPixel4aOrNewer = model.matches("Pixel [4-9][a-zA-Z ]*");
            if (isPixel4aOrNewer) {
                try {
                    SystemProperties.set("persist.columbus.use_ap_sensor", Boolean.toString(false));
                } catch (RuntimeException e) {
                    android.util.Log.e("ColumbusCompatibilityHelper", "Failed to set system property", e);
                }
            }
        }
    }

    public static boolean useApSensor() {
        return SystemProperties.getBoolean("persist.columbus.use_ap_sensor", true);
    }

    public static String getModelFileName() {
        return SystemProperties.get("persist.columbus.model", "quickTapBaseModel.tflite");
    }

    public static Long apSensorThrottleMs() {
        return SystemProperties.getLong("persist.columbus.ap_sensor.throttle_ms", 500);
    }
}
