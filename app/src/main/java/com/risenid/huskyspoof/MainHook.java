/*
 * WearableSpoof
 * Copyright (C) 2023 Simon1511
 * HuskySpoof
 * Copyright (C) 2023 RisenID
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.risenid.huskyspoof;

import android.os.Build;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {        
        XposedBridge.log("HuskySpoof: Hooking into: " + lpparam.packageName);

        // ro.product.manufacturer
        XposedHelpers.setStaticObjectField(Build.class, "MANUFACTURER", "Google");

        // ro.product.brand
        XposedHelpers.setStaticObjectField(Build.class, "BRAND", "samsung");

        // ro.product.device
        XposedHelpers.setStaticObjectField(Build.class, "DEVICE", "e3q");

        // ro.build.tags
        XposedHelpers.setStaticObjectField(Build.class, "TAGS", "release-keys");

        // ro.build.type
        XposedHelpers.setStaticObjectField(Build.class, "TYPE", "user");

        // ro.product.product
        XposedHelpers.setStaticObjectField(Build.class, "PRODUCT", "e3q");

        // ro.product.name
        XposedHelpers.setStaticObjectField(Build.class, "name", "e3q");

        // ro.system_ext.model
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM_EXT.MODEL", "SM-S928B");

        // ro.product.model
        XposedHelpers.setStaticObjectField(Build.class, "PRODUCT.MODEL", "SM-S928B");

        // ro.vendor.model
        XposedHelpers.setStaticObjectField(Build.class, "VENDOR.MODEL", "SM-S928B");

        // ro.odm.model
        XposedHelpers.setStaticObjectField(Build.class, "ODM.MODEL", "SM-S928B");

        // ro.system.model
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM.MODEL", "SM-S928B");

        // ro.product.flavor
        XposedHelpers.setStaticObjectField(Build.class, "FLAVOUR", "husky-user");

        // ro.soc.model
        XposedHelpers.setStaticObjectField(Build.class, "SOC.MODEL", "SM8650-AC");

        // ro.product.board
        XposedHelpers.setStaticObjectField(Build.class, "BOARD", "e3q");

        // ro.build.id
        XposedHelpers.setStaticObjectField(Build.class, "ID", "UP1A.231005.007");

        // ro.build.fingerprint
        XposedHelpers.setStaticObjectField(Build.class, "FINGERPRINT",
                "samsung/e3q/e3q:14/UP1A.231005.007/S928BXXS3AXI7:user/release-keys");
    }
}
