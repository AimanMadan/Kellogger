#include <ESP8266WiFi.h> // Include the WiFi library for the ESP8266

// WiFi network credentials
const char* ssid = "wifi ssid";
const char* password = "wifi password";

// Server details
const char* host = "54.91.151.204";
const int port = 8080; // HTTP port

// Ultrasonic sensor pins
const int trigPin = 13; // Connect your Trig pin to GPIO 13
const int echoPin = 12; // Connect your Echo pin to GPIO 12

void setup() {
  // Initialize serial communication at 115200 baud
  Serial.begin(115200);
  delay(10);

  // Connect to WiFi
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  // Wait for the connection to establish
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());

  // Set the ultrasonic sensor pins as output and input
  pinMode(trigPin, OUTPUT); // Sets the trigPin as an Output
  pinMode(echoPin, INPUT);  // Sets the echoPin as an Input
}

void loop() {
  // Clear the trigPin
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);

  // Trigger the ultrasonic sensor by setting the trigPin high for 10 microseconds
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  // Read the echoPin to get the duration of the pulse
  long duration = pulseIn(echoPin, HIGH);

  // Calculate the distance based on the duration
  float distance = duration * 0.034 / 2;

  // Print the distance to the Serial Monitor
  Serial.print("Distance: ");
  Serial.println(distance);

  // If the distance is less than the threshold, send data to the server
  if (distance < 90) { // 
    // Create a WiFi client
    WiFiClient client;
    if (!client.connect(host, port)) {
      Serial.println("connection failed");
      return;
    }

    // Define the URL for the GET request
    String url = "/spaces/1/addPerson"; // Change this to your API endpoint

    Serial.print("Requesting URL: ");
    Serial.println(url);

    // Send the GET request to the server
    client.print(String("GET ") + url + " HTTP/1.1\r\n" +
                 "Host: " + host + "\r\n" +
                 "Connection: close\r\n\r\n");
    delay(10);

    // Read and print the server's response
    while (client.available()) {
      String line = client.readStringUntil('\r');
      Serial.print(line);
    }

    Serial.println();
    Serial.println("closing connection");

    // Wait for 3 seconds before the next detection
    delay(3000);
  }
}
