# ContactDialog
Android dialog library which can be used to show quick profile preview.


# Screenshots

![dialog_ss](https://user-images.githubusercontent.com/7486205/37395946-8bb57784-279d-11e8-9394-91c56721cf52.jpg)


# Setup
 `minSdkVersion ` `21` or ablove 
 
#### Step 1 Add the JitPack repository to your build file:
 
 ```gradle
allprojects {
    repositories {
	...
	maven { url "https://jitpack.io" }
    }
}
```

#### Step 2 Add the dependency:

 ```
dependencies {
	        compile 'com.github.shashank-shinde:ContactDialog:1.0'
	}
```


## Implementation

```
new ContactDialogBuilder(this)
                .setName("Mohammad Faruque")
                .setSubText("Palm Beach, United States")
                .setOption1Text("Follow")
                .setOption1Drawable(R.drawable.ic_person_add)
                .setOption2Text("Message")
                .setOption2Drawable(R.drawable.ic_email)
                .setBackgroundColor(getResources().getColor(R.color.colorMy))
                .setImageResource(R.drawable.demo2)
                .setCancelable(true)
                .setOnOption1ClickListener(new OnDialogClickListener() {
                    @Override
                    public void OnClickListener(ContactDialog contactDialog) {
                        Toast.makeText(MainActivity.this, "Option 1 clicked", Toast.LENGTH_SHORT).show();
                        contactDialog.dismiss();
                    }
                })
                .setOnOption2ClickListener(new OnDialogClickListener() {
                    @Override
                    public void OnClickListener(ContactDialog contactDialog) {
                        Toast.makeText(MainActivity.this, "Option 2 clicked", Toast.LENGTH_SHORT).show();
                        contactDialog.dismiss();
                    }
                })
                .build().show();

```
