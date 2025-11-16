/*
 * GalaxyS25-Spoof - LSPosed Module
 * For Samsung Galaxy S25 Ultra (SM-S938N)
 * 
 * Optimized for PUBG Mobile and other games that detect device capabilities
 * GPU: Qualcomm Adreno 830 (1100 MHz) | RAM: LPDDR5X 5333MHz | Storage: UFS 4.0
 * 
 * Copyright (C) 2023 Simon1511 / HuskySpoof
 * Copyright (C) 2023 RisenID
 * Copyright (C) 2025 denny4-user
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */

package com.risenid.huskyspoof;

import android.os.Build;
import android.os.SystemProperties;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {        
        XposedBridge.log("GalaxyS25Spoof: Hooking into: " + lpparam.packageName);

        // Hook SystemProperties.get() method - THIS IS THE KEY FOR PUBG MOBILE & AIDA64
        XposedHelpers.findAndHookMethod(SystemProperties.class, "get", String.class, String.class,
                new XposedHelpers.MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        String propName = (String) param.args[0];
                        String defaultValue = (String) param.args[1];

                        // ============ DEVICE PROPERTIES ============
                        if (propName.equals("ro.product.manufacturer")) {
                            param.setResult("samsung");
                        } else if (propName.equals("ro.product.brand")) {
                            param.setResult("samsung");
                        } else if (propName.equals("ro.product.device")) {
                            param.setResult("pa3q");
                        } else if (propName.equals("ro.product.model")) {
                            param.setResult("SM-S938N");
                        } else if (propName.equals("ro.product.name")) {
                            param.setResult("pa3q");

                        // ============ PROCESSOR & CHIPSET ============
                        } else if (propName.equals("ro.soc.model")) {
                            param.setResult("SM8750");
                        } else if (propName.equals("ro.hardware")) {
                            param.setResult("qcom");
                        } else if (propName.equals("ro.board.platform")) {
                            param.setResult("msmnile");

                        // ============ GPU & GRAPHICS (CRITICAL FOR PUBG MOBILE & AIDA64) ============
                        } else if (propName.equals("ro.hardware.egl")) {
                            param.setResult("adreno");
                        } else if (propName.equals("ro.hardware.gpu")) {
                            param.setResult("adreno830");
                        } else if (propName.equals("ro.board.gpu")) {
                            param.setResult("Adreno 830");
                        } else if (propName.equals("ro.opengles.version")) {
                            param.setResult("196610"); // OpenGL ES 3.2
                        } else if (propName.equals("ro.gpu.renderer")) {
                            param.setResult("Adreno 830");
                        } else if (propName.equals("ro.gpu.version")) {
                            param.setResult("1100");
                        } else if (propName.equals("ro.gpu.api_version")) {
                            param.setResult("3.2");

                        // ============ MEMORY CONFIGURATION ============
                        } else if (propName.equals("ro.memory.device")) {
                            param.setResult("lpddr5x");
                        } else if (propName.equals("ro.memory.dram")) {
                            param.setResult("5333");
                        } else if (propName.equals("ro.storage.impl")) {
                            param.setResult("ufs40");

                        // ============ DISPLAY ============
                        } else if (propName.equals("ro.display.lcd_density")) {
                            param.setResult("498");
                        } else if (propName.equals("ro.display.resolution")) {
                            param.setResult("1440x3120");
                        } else if (propName.equals("ro.display.refresh_rate")) {
                            param.setResult("120");

                        // ============ ANDROID VERSION ============
                        } else if (propName.equals("ro.build.version.release")) {
                            param.setResult("15");
                        } else if (propName.equals("ro.build.version.sdk")) {
                            param.setResult("35");
                        } else if (propName.equals("ro.build.version.security_patch")) {
                            param.setResult("2025-01-01");

                        // ============ BUILD INFO ============
                        } else if (propName.equals("ro.build.id")) {
                            param.setResult("AP38.245");
                        } else if (propName.equals("ro.build.fingerprint")) {
                            param.setResult("samsung/pa3q/pa3q:15/AP38.245/S938NKSU1AYF6:user/release-keys");
                        } else if (propName.equals("ro.build.type")) {
                            param.setResult("user");
                        } else if (propName.equals("ro.build.tags")) {
                            param.setResult("release-keys");
                        }
                    }
                });

        // Also hook Build class for compatibility
        XposedHelpers.setStaticObjectField(Build.class, "MANUFACTURER", "samsung");
        XposedHelpers.setStaticObjectField(Build.class, "BRAND", "samsung");
        XposedHelpers.setStaticObjectField(Build.class, "DEVICE", "pa3q");
        XposedHelpers.setStaticObjectField(Build.class, "MODEL", "SM-S938N");
        XposedHelpers.setStaticObjectField(Build.class, "PRODUCT", "pa3q");
        XposedHelpers.setStaticObjectField(Build.class, "SOC.MODEL", "SM8750");
        XposedHelpers.setStaticObjectField(Build.class, "FINGERPRINT",
                "samsung/pa3q/pa3q:15/AP38.245/S938NKSU1AYF6:user/release-keys");

        XposedBridge.log("GalaxyS25Spoof: Device spoofed to Samsung Galaxy S25 Ultra ✓");
        XposedBridge.log("GalaxyS25Spoof: GPU spoofed to Adreno 830 (1100MHz) ✓");
    }
}
