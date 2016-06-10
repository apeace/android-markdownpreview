# Markdown Preview

A simple app I made to begin learning Android development.

<img src="http://i.imgur.com/IIssGEH.png" />

<!--
<img src="http://i.imgur.com/yOMZKch.png" style="width:40%" />
<img src="http://i.imgur.com/IOEvhgx.png" style="width:40%" />
-->

## Unit & instrumentation tests

You can run tests via the command line:

```bash
# run unit tests
./gradlew test

# run UI tests (must have android device connected or emulator running)
./gradlew connectAndroidTest
```

Or via Android Studio using the following configs:

### Unit tests

<img src="http://i.imgur.com/UZfUII7.png" />
<img src="http://i.imgur.com/MOSDrc6.png" />

### UI tests

<img src="http://i.imgur.com/Uwu90As.png" />

## Appium Python tests

I also rewrote the UI tests using Appium. To use it, first install Appium
and run the server:

```
npm install -g appium
ANDROID_HOME=/path/to/android/sdk appium
```

Then create a Python Virtualenv and install dependencies:

```
cd appium-python
virtualenv env
source env/bin/activate
pip install -r requirements.txt
```

And run the tests:

```
py.test tests/
```
