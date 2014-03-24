Readme for HelpshiftDemo
==============================

Run the following inside the /HSThemeApp folder.

```
android update project -t android-17 -p .
```

In HSThemeActivity.java initialize the library by calling
```
hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");
```
in your activity's onCreate(BundlesavedInstanceState)

In HelpshiftDemoActivity.java replace SECTION\_PUBLISH\_ID with the id of the FAQ section which
is shown under FAQs (\_yourcompany\_.helpshift.com/admin/faq/) and replace
QUESTION\_PUBLISH\_ID with the id of the FAQ which is shown under FAQs.

##Theming - 2.8.x and above
To set the Helpshift SDK to inherit from your app theme styles -

* Inside helpshift-android-sdk/res/values/hs\_\_themes\_base.xml change parent of Theme.Helpshift.Base
 ```xml
 <style name="Theme.Helpshift.Base"
        parent="@style/Theme.Example">
 </style>
 ```

* Rename helpshift-android-sdk/custom\_rules\_helpshift.xml to helpshift-android-sdk/custom_rules.xml

* Inside helpshift-android-sdk/project.properties set the helpshift.res.parent variable to the path to you project res/ folder containing the parent theme.
 ```
 helpshift.res.parent=../HSThemeApp/res
 ```

*  Inside helpshift-android-sdk/res/values/hs\_\_colors.xml change the following colors to match your app theme colors

 ```xml
  <color name="hs__actionBarStackedColor">#007298</color>
  <color name="hs__actionBarTabIndicatorColor">#33b5e5</color>
 ```

##Additionally for 3.2.0 and above

*  Inside helpshift-android-sdk/res/values/hs\_\_colors.xml change the following colors to match your app theme colors

 ```xml
  <color name="hs__actionBarTextColorPrimary">#F3F3F3</color>
  <color name="hs__actionBarTextColorSecondary">#000000</color>
 ```


*  Inside helpshift-android-sdk/res/values/hs\_\_themes.xml you can change the following -

  1. hs__selectableItemBackground - Your Selectable Menu Item background style
  ```xml
    <item name="hs__selectableItemBackground">@drawable/hs__actionbar_compat_item</item>
  ```

  1. HSActionBarCompat (android:background) - Your ActionBar background drawable or color
  ```xml
    <style name="HSActionBarCompat">
      <!-- Action Bar background -->
      <item name="android:background">#222222</item>
    </style>
  ```
* If you are using themes which inherit from either AppCompat or ActionBarSherlock; add reference to these libs inside helpshift-android-sdk/project.properties
  ```
  android.library.reference.1=../appcompat
  ```
  OR
  ```
  android.library.reference.1=../actionbarsherlock
  ```
