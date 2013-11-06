Readme for HelpshiftDemoMaven
==============================

**Version 2.8.0 onwards the SDK implements the Action Bar UI and depends on the
  <a href="http://developer.android.com/tools/support-library/features.html#v7"
  target="_blank">
  v7 appcompat library</a>**

**Use the <a href="https://github.com/mosabua/maven-android-sdk-deployer" target="_blank">
  Maven Android SDK Deployer</a> to install the libraries necessary, from your local Android SDK
  installation. To install the required support libs, run _mvn install -P 4.3_.**

In HelpshiftDemoActivity.java initialize the library by calling
```
hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");
```
in your activity's onCreate(BundlesavedInstanceState)

In HelpshiftDemoActivity.java replace SECTION\_PUBLISH\_ID with the id of the FAQ section which
is shown under FAQs (\_yourcompany\_.helpshift.com/admin/faq/) and replace
QUESTION\_PUBLISH\_ID with the id of the FAQ which is shown under FAQs.
