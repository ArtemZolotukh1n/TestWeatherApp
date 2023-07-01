## Setup
1. Clone the repository.
2. Obtain an API key from https://openweathermap.org.
3. In the project's root directory, copy the `keys.properties.example` file and rename the copy to `keys.properties`.
4. Open `keys.properties` and replace `YOUR_API_KEY_HERE` with your actual API key.
5. Run the project.

## Note
Splash screen has two implementations:
1. Fearly new Splash Screen API implementation - that doens't show up on all devices
2. Regular composable that switches to main screen after 1 seconds. 

## How I can Improve my code/app
1. Connect Detekt to the project to monitor code cleanliness.
2. Use version catalogs.
3. Use M3.
4. Add more dynamism to the user interface, for example, changing the background based on different weather conditions.
5. Save the last retrieved weather locally on the user's device so that it can be displayed even without internet connection - mb datastore or *overkill?* room.
6. Add city selection - currently, St. Petersburg is hardcoded.
