Readme for NotificationCountApp
==============================

Run the following inside the /NotificationCountApp folder.

```
android update project -t android-17 -p .
```

In NotificationCountActivity.java initialize the library by calling
```
hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");
```
in your activity's onCreate(BundlesavedInstanceState)
