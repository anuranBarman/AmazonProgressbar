# AmazonProgressBar

simple progressbar to show during network operation. Inspired by Amazon Android App.

![](https://github.com/anuranBarman/AmazonProgressbar/blob/master/amazonProgressbar.gif "Screenshot")


# How to Use

add the library via Jitpack. Add below lines to your build.gradle file (Project Level)

```
	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```
add below lines to your build.gradle file (App level)

```
	dependencies {
	        compile 'com.github.anuranBarman:AmazonProgressbar:1.0.0'
	}

```
Add this to your XML layout. Works best with FrameLayout as parent layout.

```
    <com.mranuran.amazonprogressbar.AmazonProgressbarView
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/progressBar"
    app:holderHeight="200"
    app:holderWidth="200"
    app:holderColor="#313131"
    android:visibility="gone"/>
```

# How to Start and Stop the Progressbar

```
AmazonProgressbarView amazonProgressbarView=(AmazonProgressbarView)findViewById(R.id.progressBar);
```

to start the progressbar:
```
amazonProgressbarView.start();
```

to stop the progressbar
```
amazonProgressbarView.stop();
```
