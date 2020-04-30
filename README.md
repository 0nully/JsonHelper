# JsonHelper
How to use 
Add it to your #build.gradle :

allprojects {
    repositories {
        google()
        jcenter()
#       maven { url "https://jitpack.io" }
    }
}

and:

# app.gradle

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.0.2'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
# implementation 'com.github.0nully:JsonHelper:v0.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.0'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
}


reminders:
https://jitpack.io/com/github/0nully/JsonHelper/v0.0/build.log
git push -u origin master
