Readme for HelpshiftDemo
==============================

Run the following inside the /HelpshiftDemo folder.

In HelpshiftDemoActivity.java initialize the library by calling
```
hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");
```
in your activity's onCreate(BundlesavedInstanceState)

In HelpshiftDemoActivity.java replace SECTION\_PUBLISH\_ID with the id of the FAQ section which
is shown under FAQs (\_yourcompany\_.helpshift.com/admin/faq/) and replace
QUESTION\_PUBLISH\_ID with the id of the FAQ which is shown under FAQs.
