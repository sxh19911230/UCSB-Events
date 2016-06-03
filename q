warning: LF will be replaced by CRLF in UCSBEvents/.idea/compiler.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in UCSBEvents/.idea/encodings.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in UCSBEvents/.idea/modules.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in UCSBEvents/.idea/runConfigurations.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in UCSBEvents/.idea/gradle.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in UCSBEvents/.idea/misc.xml.
The file will have its original line endings in your working directory.
[1mdiff --git a/UCSBEvents/.idea/.name b/UCSBEvents/.idea/.name[m
[1mindex 1785a10..769ab2c 100644[m
[1m--- a/UCSBEvents/.idea/.name[m
[1m+++ b/UCSBEvents/.idea/.name[m
[36m@@ -1 +1 @@[m
[31m-UCSB Events[m
\ No newline at end of file[m
[32m+[m[32mUCSBEvents[m
\ No newline at end of file[m
[1mdiff --git a/UCSBEvents/.idea/gradle.xml b/UCSBEvents/.idea/gradle.xml[m
[1mindex 58992cc..8d2df47 100644[m
[1m--- a/UCSBEvents/.idea/gradle.xml[m
[1m+++ b/UCSBEvents/.idea/gradle.xml[m
[36m@@ -3,21 +3,15 @@[m
   <component name="GradleSettings">[m
     <option name="linkedExternalProjectsSettings">[m
       <GradleProjectSettings>[m
[31m-        <option name="distributionType" value="LOCAL" />[m
[32m+[m[32m        <option name="distributionType" value="DEFAULT_WRAPPED" />[m
         <option name="externalProjectPath" value="$PROJECT_DIR$" />[m
[31m-        <option name="gradleHome" value="$APPLICATION_HOME_DIR$/gradle/gradle-2.10" />[m
[32m+[m[32m        <option name="gradleJvm" value="1.8" />[m
         <option name="modules">[m
           <set>[m
             <option value="$PROJECT_DIR$" />[m
             <option value="$PROJECT_DIR$/app" />[m
           </set>[m
         </option>[m
[31m-        <option name="myModules">[m
[31m-          <set>[m
[31m-            <option value="$PROJECT_DIR$" />[m
[31m-            <option value="$PROJECT_DIR$/app" />[m
[31m-          </set>[m
[31m-        </option>[m
       </GradleProjectSettings>[m
     </option>[m
   </component>[m
[1mdiff --git a/UCSBEvents/.idea/misc.xml b/UCSBEvents/.idea/misc.xml[m
[1mindex 1d9d626..5d19981 100644[m
[1m--- a/UCSBEvents/.idea/misc.xml[m
[1m+++ b/UCSBEvents/.idea/misc.xml[m
[36m@@ -1,5 +1,32 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 <project version="4">[m
[32m+[m[32m  <component name="EntryPointsManager">[m
[32m+[m[32m    <entry_points version="2.0" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m  <component name="NullableNotNullManager">[m
[32m+[m[32m    <option name="myDefaultNullable" value="android.support.annotation.Nullable" />[m
[32m+[m[32m    <option name="myDefaultNotNull" value="android.support.annotation.NonNull" />[m
[32m+[m[32m    <option name="myNullables">[m
[32m+[m[32m      <value>[m
[32m+[m[32m        <list size="4">[m
[32m+[m[32m          <item index="0" class="java.lang.String" itemvalue="org.jetbrains.annotations.Nullable" />[m
[32m+[m[32m          <item index="1" class="java.lang.String" itemvalue="javax.annotation.Nullable" />[m
[32m+[m[32m          <item index="2" class="java.lang.String" itemvalue="edu.umd.cs.findbugs.annotations.Nullable" />[m
[32m+[m[32m          <item index="3" class="java.lang.String" itemvalue="android.support.annotation.Nullable" />[m
[32m+[m[32m        </list>[m
[32m+[m[32m      </value>[m
[32m+[m[32m    </option>[m
[32m+[m[32m    <option name="myNotNulls">[m
[32m+[m[32m      <value>[m
[32m+[m[32m        <list size="4">[m
[32m+[m[32m          <item index="0" class="java.lang.String" itemvalue="org.jetbrains.annotations.NotNull" />[m
[32m+[m[32m          <item index="1" class="java.lang.String" itemvalue="javax.annotation.Nonnull" />[m
[32m+[m[32m          <item index="2" class="java.lang.String" itemvalue="edu.umd.cs.findbugs.annotations.NonNull" />[m
[32m+[m[32m          <item index="3" class="java.lang.String" itemvalue="android.support.annotation.NonNull" />[m
[32m+[m[32m        </list>[m
[32m+[m[32m      </value>[m
[32m+[m[32m    </option>[m
[32m+[m[32m  </component>[m
   <component name="ProjectLevelVcsManager" settingsEditedManually="false">[m
     <OptionsSetting value="true" id="Add" />[m
     <OptionsSetting value="true" id="Remove" />[m
[1mdiff --git a/UCSBEvents/.idea/vcs.xml b/UCSBEvents/.idea/vcs.xml[m
[1mindex 6c0b863..6564d52 100644[m
[1m--- a/UCSBEvents/.idea/vcs.xml[m
[1m+++ b/UCSBEvents/.idea/vcs.xml[m
[36m@@ -1,6 +1,6 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 <project version="4">[m
   <component name="VcsDirectoryMappings">[m
[31m-    <mapping directory="$PROJECT_DIR$/.." vcs="Git" />[m
[32m+[m[32m    <mapping directory="" vcs="" />[m
   </component>[m
 </project>[m
\ No newline at end of file[m
[1mdiff --git a/UCSBEvents/app/build.gradle b/UCSBEvents/app/build.gradle[m
[1mindex 5dfd593..b2a267d 100644[m
[1m--- a/UCSBEvents/app/build.gradle[m
[1m+++ b/UCSBEvents/app/build.gradle[m
[36m@@ -4,12 +4,15 @@[m [mandroid {[m
     compileSdkVersion 23[m
     buildToolsVersion "22.0.1"[m
 [m
[32m+[m
[32m+[m
     defaultConfig {[m
         applicationId "edu.ucsb.cs.cs185.shadeebarzin.ucsbevents"[m
[31m-        minSdkVersion 23[m
[32m+[m[32m        minSdkVersion 19[m
         targetSdkVersion 23[m
         versionCode 1[m
         versionName "1.0"[m
[32m+[m
     }[m
     buildTypes {[m
         release {[m
[36m@@ -17,10 +20,12 @@[m [mandroid {[m
             proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'[m
         }[m
     }[m
[32m+[m
[32m+[m
 }[m
 [m
 dependencies {[m
[31m-    compile fileTree(dir: 'libs', include: ['*.jar'])[m
[32m+[m[32m    compile fileTree(include: ['*.jar'], dir: 'libs')[m
     testCompile 'junit:junit:4.12'[m
     compile 'com.android.support:appcompat-v7:23.4.0'[m
     compile 'com.android.support:support-v4:23.4.0'[m
[1mdiff --git a/UCSBEvents/app/src/main/AndroidManifest.xml b/UCSBEvents/app/src/main/AndroidManifest.xml[m
[1mindex b16a11e..5662790 100644[m
[1m--- a/UCSBEvents/app/src/main/AndroidManifest.xml[m
[1m+++ b/UCSBEvents/app/src/main/AndroidManifest.xml[m
[36m@@ -2,6 +2,8 @@[m
 <manifest xmlns:android="http://schemas.android.com/apk/res/android"[m
     package="edu.ucsb.cs.cs185.shadeebarzin.ucsbevents">[m
 [m
[32m+[m[32m    <uses-permission android:name="android.permission.INTERNET" />[m
[32m+[m
     <application[m
         android:allowBackup="true"[m
         android:icon="@mipmap/ic_launcher"[m
[36m@@ -18,6 +20,13 @@[m
                 <category android:name="android.intent.category.LAUNCHER" />[m
             </intent-filter>[m
         </activity>[m
[32m+[m[32m        <activity[m
[32m+[m[32m            android:name=".LoginActivity">[m
[32m+[m
[32m+[m[32m        </activity>[m
[32m+[m[32m        <activity[m
[32m+[m[32m            android:name=".SignupActivity">[m
[32m+[m[32m        </activity>[m
     </application>[m
 [m
 </manifest>[m
\ No newline at end of file[m
[1mdiff --git a/UCSBEvents/app/src/main/java/edu/ucsb/cs/cs185/shadeebarzin/ucsbevents/MainActivity.java b/UCSBEvents/app/src/main/java/edu/ucsb/cs/cs185/shadeebarzin/ucsbevents/MainActivity.java[m
[1mindex c09384a..58a5496 100644[m
[1m--- a/UCSBEvents/app/src/main/java/edu/ucsb/cs/cs185/shadeebarzin/ucsbevents/MainActivity.java[m
[1m+++ b/UCSBEvents/app/src/main/java/edu/ucsb/cs/cs185/shadeebarzin/ucsbevents/MainActivity.java[m
[36m@@ -1,8 +1,11 @@[m
 package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;[m
 [m
[32m+[m[32mimport android.content.Intent;[m
[32m+[m[32mimport android.os.AsyncTask;[m
 import android.os.Bundle;[m
 import android.support.design.widget.FloatingActionButton;[m
 import android.support.design.widget.Snackbar;[m
[32m+[m[32mimport android.util.Log;[m
 import android.view.View;[m
 import android.support.design.widget.NavigationView;[m
 import android.support.v4.view.GravityCompat;[m
[36m@@ -12,10 +15,16 @@[m [mimport android.support.v7.app.AppCompatActivity;[m
 import android.support.v7.widget.Toolbar;[m
 import android.view.Menu;[m
 import android.view.MenuItem;[m
[32m+[m[32mimport android.widget.Toast;[m
[32m+[m
[32m+[m[32mimport java.io.IOException;[m
[32m+[m[32mimport java.sql.SQLException;[m
 [m
 public class MainActivity extends AppCompatActivity[m
         implements NavigationView.OnNavigationItemSelectedListener {[m
 [m
[32m+[m[32m    private static final int REQUEST_LOGIN = 0;[m
[32m+[m
     @Override[m
     protected void onCreate(Bundle savedInstanceState) {[m
         super.onCreate(savedInstanceState);[m
[36m@@ -40,8 +49,17 @@[m [mpublic class MainActivity extends AppCompatActivity[m
 [m
         NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);[m
         navigationView.setNavigationItemSelectedListener(this);[m
[32m+[m
[32m+[m
[32m+[m[32m        // Start the Signup activity[m
[32m+[m[32m        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);[m
[32m+[m[32m        startActivityForResult(intent, REQUEST_LOGIN);[m
[32m+[m
[32m+[m
     }[m
 [m
[32m+[m
[32m+[m
     @Override[m
     public void onBackPressed() {[m
         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);[m
[1mdiff --git a/UCSBEvents/app/src/main/res/values/strings.xml b/UCSBEvents/app/src/main/res/values/strings.xml[m
[1mindex 9dbca34..085be2d 100644[m
[1m--- a/UCSBEvents/app/src/main/res/values/strings.xml[m
[1m+++ b/UCSBEvents/app/src/main/res/values/strings.xml[m
[36m@@ -5,4 +5,8 @@[m
     <string name="navigation_drawer_close">Close navigation drawer</string>[m
 [m
     <string name="action_settings">Settings</string>[m
[32m+[m[32m    <string name="host">184.189.236.125</string>[m
[32m+[m[32m    <string name="username">cs185</string>[m
[32m+[m[32m    <string name="password">spring</string>[m
[32m+[m[32m    <string name="table">cs185</string>[m
 </resources>[m
[1mdiff --git a/UCSBEvents/app/src/main/res/values/styles.xml b/UCSBEvents/app/src/main/res/values/styles.xml[m
[1mindex 545b9c6..e11d11a 100644[m
[1m--- a/UCSBEvents/app/src/main/res/values/styles.xml[m
[1m+++ b/UCSBEvents/app/src/main/res/values/styles.xml[m
[36m@@ -17,4 +17,5 @@[m
 [m
     <style name="AppTheme.PopupOverlay" parent="ThemeOverlay.AppCompat.Light" />[m
 [m
[32m+[m
 </resources>[m
warning: LF will be replaced by CRLF in UCSBEvents/.idea/vcs.xml.
The file will have its original line endings in your working directory.
