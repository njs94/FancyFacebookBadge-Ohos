/*
 * Copyright (C) 2021 Huawei Device Co., Ltd.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shashank.sony.fancyfacebookbadgelib;

import ohos.agp.components.AttrSet;
import ohos.agp.utils.Color;

/**
 * For fetching xml data
 */
public class TypedAttrUtil {

    private TypedAttrUtil() {
        //doNothing
    }

    public static int getIntColor(AttrSet attrs, String attrName, int defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getColorValue().getValue();
        } else {
            return defValue;
        }
    }

    public static int getColor(AttrSet attrs, String attrName, Color defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getColorValue().getValue();
        } else {
            return defValue.getValue();
        }
    }

    public static boolean getBoolean(AttrSet attrs, String attrName, boolean defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getBoolValue();
        } else {
            return defValue;
        }
    }

    public static String getString(AttrSet attrs, String attrName, String defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getStringValue();
        } else {
            return defValue;
        }
    }

    public static int getDimensionPixelSize(AttrSet attrs, String attrName, int defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getDimensionValue();
        } else {
            return defValue;
        }
    }

    public static int getInteger(AttrSet attrs, String attrName, int defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getIntegerValue();
        } else {
            return defValue;
        }
    }

    public static float getFloat(AttrSet attrs, String attrName, float defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getFloatValue();
        } else {
            return defValue;
        }
    }
}