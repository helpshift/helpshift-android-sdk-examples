# Helpshift Android SDK Samples

This repository contains a collection example projects for Helpshift Android SDK v3.2.1

**Version 3.2.0 onwards the SDK no longer has the v7 appcompat dependency and only needs the android-support-v4.jar added to the build path. For more information refer to the <a href="https://developers.helpshift.com/android/getting-started/" target="_blank">Getting Started Docs</a>**

**Version 2.8.0 onwards the SDK implements the Action Bar UI and depends on the <a href="http://developer.android.com/tools/support-library/features.html#v7" target="_blank">v7 appcompat library</a>**


## Requirements

* Latest Android SDK (see [Android Developers page](http://developer.android.com/sdk/index.html))

## Projects

Each one of the sub-directories apart from `appcompat` and `helpshift-android-sdk` in this respository is a genuine Android project that demonstrates SDK integration and features.

* **HelpshiftDemo**: demonstrates different support screens in your app
* **HelpshiftDemoMaven**: HelpshiftDemo project using maven instead of ant
* **HSThemeApp**: app to demo theme inheritance over Helpshift SDK's UI
* **GCMApp**: demonstrates Helpshift support notifications via Google Cloud Messaging
* **UrbanAirshipApp**: demonstrates Helpshift support notifications via Urban Airship
* **PGApp**: demo app to check SDK compatibility with Proguard active

**Note:** `/helpshift-android-sdk` and `/appcompat` are required for example projects to function correctly.

## Resources
* Documentation: [https://developers.helpshift.com/android/getting-started/](https://developers.helpshift.com/ios/getting-started/)
* API Reference: [https://www.helpshift.com/docs/api/android/v3.x/reference/com/helpshift/Helpshift.html](https://www.helpshift.com/docs/api/android/v3.x/reference/com/helpshift/Helpshift.html)
* Release Notes: [https://developers.helpshift.com/android/release-notes/](https://developers.helpshift.com/android/release-notes/)
* Release Notes: [https://developers.helpshift.com/android/upgrade-2x/](https://developers.helpshift.com/android/upgrade-2x/)

## Samples for Older Releases

* [Release v3.2.0](../../tree/3.2.0)
* [Release v3.1.1](../../tree/3.1.1)
* [Release v3.1.0](../../tree/3.1.0)
* [Release v3.0.1](../../tree/3.0.1)
* [Release v3.0.0](../../tree/3.0.0)
* [Release v2.8.2](../../tree/2.8.2)

## License

```
Copyright 2014, Helpshift, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## Third Party

### Third Party Packages

| Package       | License                               | Copyright / Creator
-----------------|---------------------------------------|---------------------
| Urban Airship Android Library | Simplified BSD | (C) 2009-2012 Urban Airship Inc.
| Android v4 Support Library | [Android Software Development Kit License](http://developer.android.com/sdk/terms.html) | (C) Google, Inc.
| Android v7 appcompat Library | [Android Software Development Kit License](http://developer.android.com/sdk/terms.html) | (C) Google, Inc.


### Resources

| Resource       | License                               | Copyright / Creator
-----------------|---------------------------------------|---------------------
| Action Bar resources | Creative Commons 2.5 | (C) Google Inc.
