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
 * AttrSet utilset class.
 *
 */
public class TypedAttrUtil {

    private TypedAttrUtil() {
        //doNothing
    }
    /**
     * To fetch the Color from String.
     *
     * @param attrs AttrSet
     * @param attrName String Value to be validated
     * @param defValue Default Value
     * @return Custom Color Value as return
     */
    public static int getIntColor(AttrSet attrs, String attrName, int defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getColorValue().getValue();
        } else {
            return defValue;
        }
    }

    /**
     * To get the Integer Value of Color type.
     *
     * @param attrs AttrSet
     * @param attrName attrName
     * @param defValue Default Value
     * @return Custom Color Int Value as return
     */
    public static int getColor(AttrSet attrs, String attrName, Color defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getColorValue().getValue();
        } else {
            return defValue.getValue();
        }
    }

    /**
     * To validate the Boolean field.
     *
     * @param attrs AttrSet
     * @param attrName attrName
     * @param defValue Default Value
     * @return returns the boolean value
     */
    public static boolean getBoolean(AttrSet attrs, String attrName, boolean defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getBoolValue();
        } else {
            return defValue;
        }
    }

    /**
     * To fetch the string field.
     *
     * @param attrs AttrSet
     * @param attrName attrName
     * @param defValue Default Value
     * @return returns the string value of the field
     */
    public static String getString(AttrSet attrs, String attrName, String defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getStringValue();
        } else {
            return defValue;
        }
    }

    /**
     * Validate the customized dimension value in integer pixel values.
     *
     * @param attrs AttrSet
     * @param attrName attrName
     * @param defValue Default Value
     * @return Returns the customized int value
     */
    public static int getDimensionPixelSize(AttrSet attrs, String attrName, int defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getDimensionValue();
        } else {
            return defValue;
        }
    }

    /**
     * Validate the customized Integer value.
     *
     * @param attrs AttrSet
     * @param attrName attrName
     * @param defValue Default Value
     * @return Returns the customized Integer value
     */
    public static int getInteger(AttrSet attrs, String attrName, int defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getIntegerValue();
        } else {
            return defValue;
        }
    }

    /**
     * Validate the customized Floating value.
     *
     * @param attrs AttrSet
     * @param attrName attrName
     * @param defValue Default Value
     * @return Returns the customized float value
     */
    public static float getFloat(AttrSet attrs, String attrName, float defValue) {
        if (attrs.getAttr(attrName) != null && attrs.getAttr(attrName).isPresent()) {
            return attrs.getAttr(attrName).get().getFloatValue();
        } else {
            return defValue;
        }
    }
}