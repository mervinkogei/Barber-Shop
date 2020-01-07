## Barber-Shop [![codebeat badge](https://codebeat.co/badges/411e8d82-3ed0-42de-a283-fdc13700504d)](https://codebeat.co/projects/github-com-mervinkogei-barber-shop-master) [![Maintainability](https://api.codeclimate.com/v1/badges/1da219ba8ef3726cc845/maintainability)](https://codeclimate.com/github/mervinkogei/Barber-Shop/maintainability)
This is an android app that allows the user to search for Barber stylist in their location and check the services they offer.

## Descriptions
Its a mobile platform where clients book and pay for hair appointments online or via your social media profiles.Get notified whenever a new appointment is booked.Manage multiple barber calendars, book appointments, make notes, change availability and more!

## Contributors
* Vincent K Kogei 'vincentkogei@gmail.com'

## Prerequisites
* Android Studio with appropriate dependencies in the gradle file.

## Running the tests
* Ensure you have the androidx.test dependency in the build gradle file.


## BDD

| Input                                      | Behavior                                 | Output                                        |
|--------------------------------------------|------------------------------------------|-----------------------------------------------|
| App Loads the Splash Screen                | The app fetches the splash screen        | The user is presented with the home view      |
| The user launches the app                  | The app fetches the main activity        | The user is presented with the home view      |
| The user clicks "Just Skip/Login"          | The app gets the login activity          | The user is taken to the login view           |
| The user clicks "Home or Cart fragment"    | App gets Booking fragment display        | The user is taken to the step of Booking      |


## Technologies used
* Java - To add functionality to the app
* XML - To design the layouts of the app

# Installation
## Requirements:
* An android IDE (preferably "Android Studio")
* An Android mobile phone
* An Android Emulator

## Procedure
* Clone the project into your local machine
* Open the project in your IDE
* Connect your mobile device to the machine and allow "USB Debugging"
* Run your application in the IDE and choose the mobile device to run the app on.
* Wait until the installation of APK is done the the app is ready for use.


## Known bugs
* Facebook Api has some errors

# Licence

[Licence](Licence)