Readme for GCMApp
==============================

Run the following inside the /GCMApp folder.

```
android update project -t android-17 -p .
```

In GCMActivity.java initialize the library by calling
```
hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");
```
in your activity's onCreate(BundlesavedInstanceState)

In GCMActivity.java assign the project number from https://code.google.com/apis/console/ as the
senderId
