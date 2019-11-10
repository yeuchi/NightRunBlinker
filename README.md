# NightRunBlinker <img src="https://user-images.githubusercontent.com/1282659/68507979-c8e08880-0232-11ea-84c5-da3501bac0f5.png" width="40"> 
Simple caution blinking on phone or watch for running in the dark.

Google Play 
https://play.google.com/store/apps/details?id=com.ctyeung.nightrunblinker

# Introduction
As a runner myself, I often run in the dark (morning or night) to meet training schedule mileage.  Yeah, there are plenty excellent safety products with reflectors and/or emits caution blinking.  Since I am already wearing my GPS/heart-rate-monitor watch and/or strapped to a phone, why not double their usefulness as well ?  

## Phone

### Use Cases
<img src="https://user-images.githubusercontent.com/1282659/68509122-d64b4200-0235-11ea-8f83-c782384ca709.png" width="300">

Safety. Caution oncoming traffic with your blinking phone and/or watch.  Among many phone carrier designs, below three are popular styles this application is designed for.  
<img src="https://user-images.githubusercontent.com/1282659/68545145-dbbc9f80-038f-11ea-83c5-dc92d18f531d.png" width="200"> <img src="https://user-images.githubusercontent.com/1282659/68342402-1f718980-00b0-11ea-8745-ef3c03f15009.png" width="200"> <img src="https://user-images.githubusercontent.com/1282659/68342403-1f718980-00b0-11ea-8f4d-83d3d4550238.png" width="200"> 

#### MainActivity (configuration) 
Basic configurable features.
1. Colors of the toggling screen.
2. Blink interval in seconds (should it be in half-seconds or milli-seconds?).

<img src="https://user-images.githubusercontent.com/1282659/68545123-a87a1080-038f-11ea-9a7f-2dea7215bfe8.jpg" width="200">  <img src="https://user-images.githubusercontent.com/1282659/68545250-e4fa3c00-0390-11ea-8595-7adb5cf3b7ff.jpg" width="200">  <img src="https://user-images.githubusercontent.com/1282659/68545157-fbec5e80-038f-11ea-8401-0baf3d3703fd.jpg" width="200"> 

<img src="https://user-images.githubusercontent.com/1282659/68545171-1fafa480-0390-11ea-9892-99f19472bd64.jpg" width="400">
<img src="https://user-images.githubusercontent.com/1282659/68545268-00654700-0391-11ea-8a65-18b0301185a3.jpg" width="400"> <img src="https://user-images.githubusercontent.com/1282659/68348134-b9d8c980-00be-11ea-94ce-8f515c5792ad.jpg" width="400">

#### BlinkActivity
Toggles between below screens for the configured duration; phone is in wakelock mode.

<img src="https://user-images.githubusercontent.com/1282659/68332660-cba97500-009c-11ea-9eed-cc98a881ab78.jpg" width="200">  <img src="https://user-images.githubusercontent.com/1282659/68545190-4a99f880-0390-11ea-814b-cc1e3b365abb.jpg" width="200">
 
<img src="https://user-images.githubusercontent.com/1282659/68348136-b9d8c980-00be-11ea-8e74-9cf7a3ccc063.jpg" width="400"> <img src="https://user-images.githubusercontent.com/1282659/68348135-b9d8c980-00be-11ea-91eb-d25bdb59c0c5.jpg" width="400">

### Test
This application has been tested on Samsung Galaxy9.

## Watch 
Look forward to implement! 

# References 
1. Color Popup by duanhong
   https://github.com/duanhong169/ColorPicker/releases?utm_source=android-arsenal.com&utm_medium=referral&utm_campaign=7068
