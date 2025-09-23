package week6.assignments;

class Weather {
    public Weather() {
        System.out.println("Weather constructor called");
    }

    public void displayWeather() {
        System.out.println("General weather conditions");
    }
}

class Storm extends Weather {
    public Storm() {
        super();
        System.out.println("Storm constructor called");
    }

    @Override
    public void displayWeather() {
        System.out.println("Stormy weather conditions");
    }
}

class Thunderstorm extends Storm {
    public Thunderstorm() {
        super();
        System.out.println("Thunderstorm constructor called");
    }

    @Override
    public void displayWeather() {
        System.out.println("Thunderstorm with heavy rain and lightning");
    }
}

class Sunshine extends Weather {
    public Sunshine() {
        super();
        System.out.println("Sunshine constructor called");
    }

    @Override
    public void displayWeather() {
        System.out.println("Sunny weather with clear skies");
    }
}

public class WeatherTest {
    public static void main(String[] args) {
        Weather[] weatherArr = {
                new Weather(),
                new Storm(),
                new Thunderstorm(),
                new Sunshine()
        };

        System.out.println();

        for (Weather w : weatherArr) {
            w.displayWeather();
        }
    }
}
