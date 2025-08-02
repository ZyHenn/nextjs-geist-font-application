# Wazuh Mobile - Security Event Monitoring App

A modern Android mobile application for monitoring Wazuh security events with AI-powered analysis and real-time dashboard.

## Features

### 🚀 Core Features
- **Splash Screen** - Modern loading screen with Wazuh branding
- **Dynamic Login** - Configurable server connection with secure authentication
- **Real-time Dashboard** - Live security event monitoring and statistics
- **AI-Powered Analysis** - OpenAI integration for intelligent security summaries
- **Agent Monitoring** - Real-time status of security agents
- **High Priority Alerts** - Critical security event notifications
- **Responsive Design** - Optimized for various Android screen sizes

### 📱 User Interface
- Professional color scheme with Wazuh branding
- Card-based layout for better information organization
- Scrollable dashboard with comprehensive security overview
- Bottom navigation for easy feature access
- Status indicators for API connectivity

## Project Structure

```
WazuhMobile/
├── app/
│   ├── build.gradle                 # App-level build configuration
│   └── src/main/
│       ├── AndroidManifest.xml      # App manifest and permissions
│       ├── java/com/wazuh/mobile/
│       │   ├── SplashActivity.java  # Splash screen with loading animation
│       │   ├── LoginActivity.java   # Dynamic server login
│       │   ├── MainActivity.java    # Main dashboard activity
│       │   ├── api/
│       │   │   ├── WazuhApiService.java    # Wazuh API integration (commented)
│       │   │   ├── OpenAIService.java      # OpenAI API integration (commented)
│       │   │   └── ApiCallback.java        # API callback interface
│       │   └── models/
│       │       ├── AuthResponse.java       # Authentication response model
│       │       └── EventsResponse.java     # Events response model
│       └── res/
│           ├── layout/              # UI layouts for all screens
│           ├── values/              # Colors, strings, styles
│           └── drawable/            # Background and UI elements
├── build.gradle                    # Project-level build configuration
├── settings.gradle                 # Project settings
└── gradle.properties              # Gradle properties
```

## Setup Instructions

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK API Level 24 or higher
- Java 8 or higher
- Gradle 7.0 or higher

### Installation Steps

1. **Clone/Download the Project**
   ```bash
   # If using git
   git clone <repository-url>
   cd WazuhMobile
   
   # Or extract the provided source code
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the WazuhMobile folder and select it
   - Wait for Gradle sync to complete

3. **Build the Project**
   ```bash
   # Using command line
   ./gradlew build
   
   # Or use Android Studio Build menu
   Build > Make Project
   ```

4. **Run the Application**
   - Connect an Android device or start an emulator
   - Click the "Run" button in Android Studio
   - Or use command line: `./gradlew installDebug`

## API Integration Guide

### 🔧 Backend Integration Setup

The application is designed with a clean separation between frontend and backend. All API integration code is currently **commented out** to allow frontend testing. Follow these steps to enable backend integration:

### Step 1: Enable Dependencies

Uncomment the following dependencies in `app/build.gradle`:

```gradle
// Uncomment these lines for API integration
implementation 'com.squareup.okhttp3:okhttp:4.12.0'
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.google.code.gson:gson:2.10.1'
```

### Step 2: Enable Internet Permissions

Uncomment the permissions in `AndroidManifest.xml`:

```xml
<!-- Uncomment these lines for API integration -->
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

### Step 3: Configure Wazuh API Integration

1. **Open `WazuhApiService.java`**
2. **Uncomment the entire implementation** (remove the `/* */` comment blocks)
3. **Configure your Wazuh server endpoints**:

```java
// Example Wazuh API endpoints to implement
private static final String AUTH_ENDPOINT = "/security/user/authenticate";
private static final String EVENTS_ENDPOINT = "/events";
private static final String AGENTS_ENDPOINT = "/agents";
private static final String ALERTS_ENDPOINT = "/alerts";
```

4. **Update API interface** - Create `WazuhApiInterface.java`:

```java
public interface WazuhApiInterface {
    @POST("/security/user/authenticate")
    Call<AuthResponse> authenticate(@Body AuthRequest request);
    
    @GET("/events")
    Call<EventsResponse> getEventsStatistics(@Query("timerange") String timeRange);
    
    @GET("/alerts")
    Call<AlertsResponse> getCriticalAlerts(@Query("severity") int severity);
    
    @GET("/agents")
    Call<AgentsResponse> getAgentsStatus();
    
    // Add more endpoints as needed
}
```

### Step 4: Configure OpenAI Integration

1. **Open `OpenAIService.java`**
2. **Uncomment the entire implementation**
3. **Add your OpenAI API key**:

```java
// In your activity or service
String openaiApiKey = "your-openai-api-key-here";
OpenAIService openAIService = new OpenAIService();
openAIService.generateSecuritySummary(openaiApiKey, eventsData, callback);
```

### Step 5: Update Activities

Uncomment the API integration code in the activity files:

**LoginActivity.java:**
```java
// Uncomment the WazuhApiService authentication code
WazuhApiService apiService = new WazuhApiService();
apiService.authenticate(serverUrl, username, password, new ApiCallback<AuthResponse>() {
    // Handle authentication response
});
```

**MainActivity.java:**
```java
// Uncomment all API service calls
WazuhApiService apiService = new WazuhApiService();
OpenAIService openAIService = new OpenAIService();
// Load real data from APIs
```

## Configuration

### Wazuh Server Configuration

Update the following configuration in your app:

```java
// Default Wazuh server configuration
public class WazuhConfig {
    public static final String DEFAULT_SERVER_URL = "https://your-wazuh-server.com";
    public static final String API_VERSION = "v1";
    public static final int CONNECTION_TIMEOUT = 30; // seconds
    public static final int READ_TIMEOUT = 30; // seconds
}
```

### OpenAI Configuration

```java
// OpenAI configuration
public class OpenAIConfig {
    public static final String API_URL = "https://api.openai.com/v1/chat/completions";
    public static final String MODEL = "gpt-3.5-turbo";
    public static final int MAX_TOKENS = 200;
    public static final double TEMPERATURE = 0.3;
}
```

## Security Considerations

### 🔒 Important Security Notes

1. **API Keys Storage**
   - Never hardcode API keys in source code
   - Use Android Keystore for secure storage
   - Consider using environment variables or secure configuration files

2. **Network Security**
   - Always use HTTPS for API communications
   - Implement certificate pinning for production
   - Add network security configuration

3. **Authentication**
   - Implement token refresh mechanism
   - Store authentication tokens securely
   - Add session timeout handling

### Example Secure Storage Implementation

```java
// Example secure token storage
public class SecureStorage {
    private static final String KEYSTORE_ALIAS = "WazuhMobileKey";
    
    public void storeToken(String token) {
        // Use Android Keystore to encrypt and store token
    }
    
    public String getToken() {
        // Retrieve and decrypt token from Keystore
        return decryptedToken;
    }
}
```

## Testing

### Frontend Testing (Current State)
The app is currently configured for frontend testing with:
- Mock data for dashboard statistics
- Simulated login process
- Static UI elements
- No actual API calls

### Backend Testing (After Integration)
Once APIs are integrated:
1. Test with actual Wazuh server
2. Verify OpenAI API responses
3. Test error handling and network failures
4. Validate data parsing and display

## Troubleshooting

### Common Issues

1. **Build Errors**
   - Ensure Android SDK is properly installed
   - Check Gradle version compatibility
   - Verify all dependencies are available

2. **API Integration Issues**
   - Verify server URLs and endpoints
   - Check API key validity
   - Ensure network permissions are enabled
   - Test API endpoints with tools like Postman

3. **UI Issues**
   - Check device compatibility (API Level 24+)
   - Verify resource files are properly included
   - Test on different screen sizes

### Debug Mode

Enable debug logging by adding to `MainActivity.java`:

```java
private static final String TAG = "WazuhMobile";
private static final boolean DEBUG = true;

if (DEBUG) {
    Log.d(TAG, "Debug message here");
}
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support and questions:
- Create an issue in the repository
- Contact the development team
- Check the Wazuh documentation for API details

---

**Note**: This application is designed to work with Wazuh security platform. Ensure you have proper Wazuh server setup and API access before integrating the backend functionality.
