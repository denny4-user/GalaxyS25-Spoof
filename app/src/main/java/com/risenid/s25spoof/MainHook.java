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

package com.risenid.s25spoof;

import android.os.Build;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {        
        XposedBridge.log("s25 Spoof: Hooking into: " + lpparam.packageName);

        // ============ DEVICE IDENTIFICATION ============
        
        // ro.product.manufacturer
        XposedHelpers.setStaticObjectField(Build.class, "MANUFACTURER", "samsung");

        // ro.product.brand
        XposedHelpers.setStaticObjectField(Build.class, "BRAND", "samsung");

        // ro.product.device (codename)
        XposedHelpers.setStaticObjectField(Build.class, "DEVICE", "pa3q");

        // ro.product.product
        XposedHelpers.setStaticObjectField(Build.class, "PRODUCT", "pa3q");

        // ro.product.name
        XposedHelpers.setStaticObjectField(Build.class, "name", "pa3q");

        // ============ MODEL VARIANTS ============
        
        // ro.system_ext.model
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM_EXT.MODEL", "SM-S938N");

        // ro.product.model
        XposedHelpers.setStaticObjectField(Build.class, "PRODUCT.MODEL", "SM-S938N");

        // ro.vendor.model
        XposedHelpers.setStaticObjectField(Build.class, "VENDOR.MODEL", "SM-S938N");

        // ro.odm.model
        XposedHelpers.setStaticObjectField(Build.class, "ODM.MODEL", "SM-S938N");

        // ro.system.model
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM.MODEL", "SM-S938N");

        // ro.product.model (primary)
        XposedHelpers.setStaticObjectField(Build.class, "MODEL", "SM-S938N");

        // ============ BUILD INFORMATION ============
        
        // ro.product.flavor
        XposedHelpers.setStaticObjectField(Build.class, "FLAVOUR", "pa3q-user");

        // ro.build.type
        XposedHelpers.setStaticObjectField(Build.class, "TYPE", "user");

        // ro.build.tags
        XposedHelpers.setStaticObjectField(Build.class, "TAGS", "release-keys");

        // ro.build.id
        XposedHelpers.setStaticObjectField(Build.class, "ID", "AP38.245");

        // ro.build.version.incremental
        XposedHelpers.setStaticObjectField(Build.class, "VERSION_INCREMENTAL", "S938NKSU1AYF6");

        // ro.build.fingerprint
        XposedHelpers.setStaticObjectField(Build.class, "FINGERPRINT",
                "samsung/pa3q/pa3q:15/AP38.245/S938NKSU1AYF6:user/release-keys");

        // ============ PROCESSOR & CHIPSET ============
        
        // ro.soc.model (Snapdragon 8 Elite for Galaxy)
        XposedHelpers.setStaticObjectField(Build.class, "SOC.MODEL", "SM8750");

        // ro.board (device board)
        XposedHelpers.setStaticObjectField(Build.class, "BOARD", "pa3q");

        // ro.hardware
        XposedHelpers.setStaticObjectField(Build.class, "HARDWARE", "qcom");

        // ro.hardware.platform
        XposedHelpers.setStaticObjectField(Build.class, "HARDWARE_PLATFORM", "msmnile");

        // ============ GPU & GRAPHICS (PUBG Mobile Detection) ============
        
        // ro.hardware.egl (EGL implementation)
        XposedHelpers.setStaticObjectField(Build.class, "HARDWARE_EGL", "adreno");

        // ro.hardware.gpu (GPU model)
        XposedHelpers.setStaticObjectField(Build.class, "HARDWARE_GPU", "adreno830");

        // ro.board.gpu (GPU board designation)
        XposedHelpers.setStaticObjectField(Build.class, "BOARD_GPU", "Adreno 830");

        // ro.board.platform (for GPU clock info)
        XposedHelpers.setStaticObjectField(Build.class, "BOARD_PLATFORM", "msmnile");

        // ============ MEMORY CONFIGURATION ============
        
        // ro.memory.device (LPDDR5X RAM indicator for PUBG)
        XposedHelpers.setStaticObjectField(Build.class, "MEMORY_DEVICE", "lpddr5x");

        // ro.memory.dram (RAM speed indicator)
        XposedHelpers.setStaticObjectField(Build.class, "MEMORY_DRAM", "5333MHz");

        // ro.storage.impl (UFS 4.0 storage)
        XposedHelpers.setStaticObjectField(Build.class, "STORAGE_IMPL", "ufs40");

        // ============ ANDROID VERSION & FRAMEWORK ============
        
        // ro.build.version.release
        XposedHelpers.setStaticObjectField(Build.class, "VERSION_RELEASE", "15");

        // ro.build.version.sdk_int
        XposedHelpers.setStaticObjectField(Build.class, "VERSION_SDK_INT", "35");

        // ro.build.version.security_patch
        XposedHelpers.setStaticObjectField(Build.class, "VERSION_SECURITY_PATCH", "2025-01-01");

        // ro.system.ext.version (One UI version indicator)
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM_EXT_VERSION", "OneUI_7.0");

        // ============ DISPLAY CONFIGURATION ============
        
        // ro.display.lcd_density (for resolution detection)
        XposedHelpers.setStaticObjectField(Build.class, "DISPLAY_LCD_DENSITY", "498");

        // ro.display.resolution (1440x3120)
        XposedHelpers.setStaticObjectField(Build.class, "DISPLAY_RESOLUTION", "1440x3120");

        // ro.display.refresh_rate (120Hz support)
        XposedHelpers.setStaticObjectField(Build.class, "DISPLAY_REFRESH_RATE", "120");

        // ============ GRAPHICS API & RENDERING ============
        
        // ro.graphics.opengl_version
        XposedHelpers.setStaticObjectField(Build.class, "GRAPHICS_OPENGL_VERSION", "3.2");

        // ro.graphics.vulkan_version
        XposedHelpers.setStaticObjectField(Build.class, "GRAPHICS_VULKAN_VERSION", "1.3");

        // ro.graphics.rendering_engine (for PUBG graphics detection)
        XposedHelpers.setStaticObjectField(Build.class, "GRAPHICS_RENDERING", "Adreno 830 1100MHz");

        // ============ BATTERY & THERMAL ============
        
        // ro.battery.capacity
        XposedHelpers.setStaticObjectField(Build.class, "BATTERY_CAPACITY", "5000");

        // ro.battery.type
        XposedHelpers.setStaticObjectField(Build.class, "BATTERY_TYPE", "Li-Ion");

        // ro.product.supports_high_performance_mode
        XposedHelpers.setStaticObjectField(Build.class, "SUPPORTS_HIGH_PERF", "true");

        // ============ SAMSUNG-SPECIFIC PROPERTIES ============
        
        // ro.vendor.extension_library (Samsung specific)
        XposedHelpers.setStaticObjectField(Build.class, "VENDOR_EXTENSION", "/vendor/lib/libqti-perfd-client.so");

        // ro.vendor.qti.sys.usb.config
        XposedHelpers.setStaticObjectField(Build.class, "VENDOR_USB_CONFIG", "adb");

        // ro.opengles.version (for OpenGL detection in PUBG)
        XposedHelpers.setStaticObjectField(Build.class, "OPENGLES_VERSION", "196610");

        XposedBridge.log("s25 Spoof: Device spoofed to Samsung Galaxy S25 Ultra ✓");
    }
}
