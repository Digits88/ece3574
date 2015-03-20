# Introduction #
In this exercise, you are going to modify an application for finding information in a
geo database based on your current location. The server uses the Geocell library
to create a set of data that supports proximity searches via lat/lon coordinates.
You will modify an Android client to connect to the server and retrieve virtual
telephone flyers near your current location.

# Setup #
  1. Download and install the Google plugin for Eclipse: http://code.google.com/eclipse/docs/getting_started.html
  1. Download the exercise code zip: http://code.google.com/p/ece3574/downloads/detail?name=network_comms_and_dependency_injection_exercise.zip
  1. Use File->Import Existing Projects into Workspace, select the downloaded zip, and then select the LocationServer and LocationClient projects for import

# Running the Location Server Locally #
  1. Right-click on the root folder of the "LocationServer" project
  1. Run-as "Web Application" (to run locally)
  1. Open a web browser to http://localhost:8888/loc/question/add?question=somequestion&lat=37.0622&lon=-95.677068&title=3574_is_amazing to add some sample data
  1. Feel free to modify the above url to add more data to the database

# Running the Android Location Client #
  1. Follow the directions to start the web app first!
  1. Right-click on the root folder of the "LocationClient" project
  1. Run-as "Android Application"
  1. When you have completed the assignment, you should see a list of nearby flyers
  1. Touch a flyer and it will display its contents

# Instructions #

The exercise steps are spelled out inside the source code as comments of LocationClient.java and TelephonePoleController.java.