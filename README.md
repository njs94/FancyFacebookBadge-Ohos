# FancyFacebookBadge-Ohos

FancyFacebookBadge library for Ohos makes you add badges to the text or image.

# Usage

First of all, need add FacebookBadge to your xml layout.

```xml
    <com.shashank.sony.fancyfacebookbadgelib.FacebookNotificationBadge
        ohos:height="match_content"
        ohos:width="match_content"
        ohos:id="$+id:badge"
        ohos:bottom_padding="20fp"/>
```

Second of all, interact with code in java.
```java
FacebookNotificationBadge mBadge = (FacebookNotificationBadge) findComponentById(ResourceTable.Id_badge);
mBadge.setNumber(12); //Set your count
mBadge.setEmoji(Emoji.HAHA); //You can also set Emoji.LIKE, Emoji.WOW etc
//mBadge.setTextColor(Pass ur color);
//mBadge.setText(Pass ur text);
//mBadge.clear(); //Use to remove or clear the badge
//mBadge.getTextColor(); //Gives u text color
//mBadge.isAnimationEnabled(); //Gives u boolean value true or false
//mBadge.setAnimationEnabled(boolean value); //By default it is true 

```

# Integration

1. For using fancyfacebookbadgelib module in sample, include the source code and below dependency in entry/build.gradle to generate hap file.
        
        implementation project(":fancyfacebookbadgelib")

2. For using fancyfacebookbadgelib module in seperate application using  har file, add the har file in the entry/libs folder and add the below dependency in entry/build.gradle
        
        implementation fileTree(dir: 'libs', include: ['*har'])

3. For using fancyfacebookbadgelib module from remote repository in seperate application, add the below dependency in entry/build.gradle file.
        
        implementation 'dev.applibgroup:FancyFacebookBadge-Ohos:1.0.0'

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2018 Shashank Singhal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.