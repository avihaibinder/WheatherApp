# 🌤 WeatherApp - Spring Boot Console App

This Spring Boot console application fetches the current weather for a list of cities using the [OpenWeatherMap API](https://openweathermap.org/current) and displays the temperature sorted in ascending order.

## ✅ Features

- 🌐 Fetches city list from a remote JSON URL
- 🌦 Fetches real-time weather from OpenWeatherMap
- 🧠 Handles API rate-limiting (HTTP 429)
- 🖨 Prints results in: `[CITY] : [TEMPERATURE]`

## 🧪 Tech Stack

- Java 17+
- Spring Boot
- OpenWeatherMap API

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/avihaibinder/WheatherApp.git
cd WheatherApp

## 🛠 Prerequisites & Setup

- **Java version:** Java 17 or higher
- **Build tool:** Maven
- **Dependencies:**
  - `org.json`
  - Spring Boot (Web, Core)
- **OpenWeatherMap API Key** is required
Edit the following in `src/main/resources/application.properties`:

```properties
api.key=YOUR_API_KEY

Run WheatherAppApplication for the program to work.
Rate Limiting:
-Detects HTTP 429 responses from OpenWeatherMap
-Waits 1 second before retrying the request
-Retries up to 3 times
-Implemented in HttpService

Retry Logic
Retries on:
-Rate-limiting (429)
-Network/connection failures
-Retry limit: 3 attempts per city
-Fails gracefully with console error logging

If I had more time I would first of all finish the ascending order printing(I almost finished it :( )
then I would add async calls and I would save the date to H2 database
I did my best :)
Thank You very much.
