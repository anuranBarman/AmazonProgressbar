# AmazonProgressBar

simple progressbar to show during network operation. Inspired by Amazon Android App.

# How to Use

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
