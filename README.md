# NightRunBlinker <img src="https://user-images.githubusercontent.com/1282659/68507979-c8e08880-0232-11ea-84c5-da3501bac0f5.png" width="40"> 
Simple caution blinking on phone or watch for running in the dark.

Google Play 
https://play.google.com/store/apps/details?id=com.ctyeung.nightrunblinker

# Introduction
As a runner myself, I often run in the dark (morning or night) to meet training schedule mileage.  Yeah, there are plenty excellent safety products with reflectors and/or emits caution blinking.  Since I am already wearing my GPS/heart-rate-monitor watch and/or strapped to a phone, why not double their usefulness as well ?  

## Phone

### Use Cases
Safety. Caution oncoming traffic with your blinking phone.  Among many phone carrier designs, below three are popular styles this application is designed for.  
<img src="https://user-images.githubusercontent.com/1282659/68342401-1f718980-00b0-11ea-914d-30eb1fe16efb.png" width="200">  <img src="https://user-images.githubusercontent.com/1282659/68342402-1f718980-00b0-11ea-8745-ef3c03f15009.png" width="200">  <img src="https://user-images.githubusercontent.com/1282659/68342403-1f718980-00b0-11ea-8f4d-83d3d4550238.png" width="200"> 

#### MainActivity (configuration) 
Basic configurable features.
1. Colors of the toggling screen.
2. Blink interval in seconds (should it be in half-seconds or milli-seconds?).

<img src="https://user-images.githubusercontent.com/1282659/68332629-c2b8a380-009c-11ea-8f79-1fc3dc599d3f.jpg" width="200">  <img src="https://user-images.githubusercontent.com/1282659/68334674-be8e8500-00a0-11ea-8ad4-38cb850c343a.jpg" width="200">  <img src="https://user-images.githubusercontent.com/1282659/68334675-bf271b80-00a0-11ea-8bdf-5632c15e0d7b.jpg" width="200"> 

<img src="https://user-images.githubusercontent.com/1282659/68348132-b9403300-00be-11ea-943b-960393ee4e77.jpg" width="400">

<img src="https://user-images.githubusercontent.com/1282659/68348133-b9d8c980-00be-11ea-8648-ed5151405c42.jpg" width="400"> <img src="https://user-images.githubusercontent.com/1282659/68348134-b9d8c980-00be-11ea-94ce-8f515c5792ad.jpg" width="400">

#### BlinkActivity
Toggles between below screens for the configured duration; phone is in wakelock mode.

<img src="https://user-images.githubusercontent.com/1282659/68332660-cba97500-009c-11ea-9eed-cc98a881ab78.jpg" width="200">  <img src="https://user-images.githubusercontent.com/1282659/68332662-cf3cfc00-009c-11ea-9d53-94c816da8518.jpg" width="200">
 
<img src="https://user-images.githubusercontent.com/1282659/68348136-b9d8c980-00be-11ea-8e74-9cf7a3ccc063.jpg" width="400"> <img src="https://user-images.githubusercontent.com/1282659/68348135-b9d8c980-00be-11ea-91eb-d25bdb59c0c5.jpg" width="400">

### Test
This application has been tested on Samsung Galaxy9.

## Watch 
Look forward to implement! 

# References 
1. Color Popup by duanhong
   https://github.com/duanhong169/ColorPicker/releases?utm_source=android-arsenal.com&utm_medium=referral&utm_campaign=7068
