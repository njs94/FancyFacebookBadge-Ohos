/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shashank.sony.fancyfacebookbadgelibrary.demo.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import com.shashank.sony.fancyfacebookbadgelib.Emoji;
import com.shashank.sony.fancyfacebookbadgelib.FacebookNotificationBadge;
import com.shashank.sony.fancyfacebookbadgelibrary.demo.ResourceTable;

/**
 * MainAbility Slice first class to be invoked.
 */
public class MainAbilitySlice extends AbilitySlice implements Component.ClickedListener {

    private int hahaCount = 0;
    private int sadCount = 0;
    private int loveCount = 0;
    private int wowCount = 0;
    private int angryCount = 0;
    private int likeCount = 0;

    private FacebookNotificationBadge hahaBadge = null;
    private FacebookNotificationBadge sadBadge = null;
    private FacebookNotificationBadge angryBadge = null;
    private FacebookNotificationBadge wowBadge = null;
    private FacebookNotificationBadge loveBadge = null;
    private FacebookNotificationBadge likeBadge = null;

    private Button hahaButton;
    private Button sadButton;
    private Button angryButton;
    private Button likeButton;
    private Button loveButton;
    private Button wowButton;
    private Button resetButton;


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        buttonInit();
        buttonListeners();

        hahaBadge = (FacebookNotificationBadge) findComponentById(ResourceTable.Id_hahabadge);
        sadBadge = (FacebookNotificationBadge) findComponentById(ResourceTable.Id_sadbadge);
        angryBadge = (FacebookNotificationBadge) findComponentById(ResourceTable.Id_angrybadge);
        wowBadge = (FacebookNotificationBadge) findComponentById(ResourceTable.Id_wowbadge);
        loveBadge = (FacebookNotificationBadge) findComponentById(ResourceTable.Id_lovebadge);
        likeBadge = (FacebookNotificationBadge) findComponentById(ResourceTable.Id_likebadge);
        hahaBadge.setEmoji(Emoji.HAHA);
        likeBadge.setEmoji(Emoji.LIKE);
        loveBadge.setEmoji(Emoji.LOVE);
        wowBadge.setEmoji(Emoji.WOW);
        sadBadge.setEmoji(Emoji.SAD);
        angryBadge.setEmoji(Emoji.ANGRY);

    }

    private void buttonInit() {
        hahaButton = (Button) findComponentById(ResourceTable.Id_reacthaha);
        sadButton = (Button) findComponentById(ResourceTable.Id_reactsad);
        angryButton = (Button) findComponentById(ResourceTable.Id_reactangry);
        loveButton = (Button) findComponentById(ResourceTable.Id_reactlove);
        likeButton = (Button) findComponentById(ResourceTable.Id_reactlike);
        wowButton = (Button) findComponentById(ResourceTable.Id_reactwow);
        resetButton = (Button) findComponentById(ResourceTable.Id_reset);
    }

    private void buttonListeners() {
        hahaButton.setClickedListener(this);
        sadButton.setClickedListener(this);
        angryButton.setClickedListener(this);
        loveButton.setClickedListener(this);
        likeButton.setClickedListener(this);
        wowButton.setClickedListener(this);
        resetButton.setClickedListener(this);

    }

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_hahabadge:
                hahaCount++;
                hahaBadge.setNumber(hahaCount);
                break;
            case ResourceTable.Id_sadbadge:
                sadCount++;
                sadBadge.setNumber(sadCount);
                break;
            case ResourceTable.Id_angrybadge:
                angryCount++;
                angryBadge.setNumber(angryCount);
                break;
            case ResourceTable.Id_wowbadge:
                wowCount++;
                wowBadge.setNumber(wowCount);
                break;
            case ResourceTable.Id_likebadge:
                likeCount++;
                likeBadge.setNumber(likeCount);
                break;
            case ResourceTable.Id_lovebadge:
                loveCount++;
                loveBadge.setNumber(loveCount);
                break;
            case ResourceTable.Id_reset:
                hahaCount = likeCount = angryCount = loveCount = wowCount = sadCount = 0;
                hahaBadge.setNumber(hahaCount);
                loveBadge.setNumber(loveCount);
                likeBadge.setNumber(likeCount);
                wowBadge.setNumber(wowCount);
                sadBadge.setNumber(sadCount);
                hahaBadge.setNumber(hahaCount);
                break;
        }
    }
}
