# QuoteApp

QuoteApp is a simple Android application built using Kotlin and Jetpack Compose. It allows users to view and share their favorite quotes. The app is structured into several packages including `screen`, `model`, and `data`.

## Features

- View a collection of inspiring quotes.
- Simple and intuitive user interface built with Jetpack Compose.

## Packages

### `screen`

The `screen` package contains all the UI screens of the QuoteApp. Each screen is implemented as a composable function using Jetpack Compose. The screens included in this package are:

- **QuoteListScreen**: Displays a list of quotes fetched from the data manager.
- **QuoteDetailScreen**: Shows detailed information about a particular quote when clicked from the list.
- **QuoteList**: Call the QuoteListItem and display the list of the quotes by LazyColumn Composable.

### `model`

The `model` package contains the data model classes used in the QuoteApp. These classes represent the structure of a quote, including its text, author, and any additional metadata.

### `data`

The `data` package contains the `DataManager` object responsible for managing the retrieval and storage of quote data. It interfaces with external data sources such as APIs or local databases to fetch quotes for display in the app.

## Technologies Used

- Kotlin: A modern programming language used for Android app development.
- Jetpack Compose: A modern UI toolkit for building native Android apps using a declarative approach.
- Android Architecture Components: Provides a set of libraries that help you design robust, testable, and maintainable apps.
  
## Getting Started

To run the QuoteApp on your local machine, follow these steps:

1. Clone this repository.
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.

## Contributing

Contributions to QuoteApp are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.


