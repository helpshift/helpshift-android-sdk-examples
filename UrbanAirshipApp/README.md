Readme for UrbanAirshipApp
==============================

Run the following inside the /UrbanAirshipApp folder.

```
android update project -t android-17 -p .
```

In UrbanAirshipActivity.java initialize the library by calling
```
hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");
```
in your activity's onCreate(BundlesavedInstanceState)

In MyApplication.java uncomment the following and add the appropriate values for gcmsender,
developmentAppKey and productionAppKey.
```
  AirshipConfigOptions options = AirshipConfigOptions.loadDefaultOptions(this);
  options.gcmSender = Your Google API Project Number (allows multiple senders separated by commas)
  options.transport = gcm
  options.developmentAppKey = "Your development app key";
  options.productionAppKey = "Your production app key";
  options.inProduction = false; //determines which app key to use
  UAirship.takeOff(this, options);
```
