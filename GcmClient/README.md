#GcmClient

* Run the following inside the /GcmClient folder.

        android update project -t android-17 -p .

* In `DemoActivity.java` initialize the library by calling:

        hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");

    in your activity's `onCreate` method.

    To get the `API Key`, `Domain Name` and the `App ID`, navigate to `Settings`>`SDK (for Developers)` in your agent dashboard and scroll down to **"Initializing Helpshift"** section.

    ![](https://developers.helpshift.com/static/books/common/settings-integration.png)

    Select your App from the dropdown and copy the three tokens to be passed when initializing Helpshift.

* In `DemoActivity.java` assign the project number from https://code.google.com/apis/console/ as the `SENDER_ID`.

    **[Related documentation](https://developers.helpshift.com/android/notifications/#configure-helpshift-android-sdk)**
