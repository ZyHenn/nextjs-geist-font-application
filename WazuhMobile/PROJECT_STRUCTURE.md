# Wazuh Mobile - Complete Project Structure

## 📁 Project Directory Structure

```
WazuhMobile/
├── 📄 README.md                           # Complete setup and integration guide
├── 📄 PROJECT_STRUCTURE.md               # This file - project overview
├── 📄 build.gradle                       # Project-level build configuration
├── 📄 settings.gradle                    # Project settings and modules
├── 📄 gradle.properties                  # Gradle configuration properties
│
└── 📁 app/                               # Main application module
    ├── 📄 build.gradle                   # App-level dependencies and config
    │
    └── 📁 src/main/
        ├── 📄 AndroidManifest.xml        # App manifest, activities, permissions
        │
        ├── 📁 java/com/wazuh/mobile/     # Java source code
        │   ├── 📄 SplashActivity.java    # Splash screen with loading animation
        │   ├── 📄 LoginActivity.java     # Dynamic server login screen
        │   ├── 📄 MainActivity.java      # Main dashboard activity
        │   │
        │   ├── 📁 api/                   # API integration layer (commented)
        │   │   ├── 📄 WazuhApiService.java    # Wazuh API service
        │   │   ├── 📄 OpenAIService.java      # OpenAI API service
        │   │   └── 📄 ApiCallback.java        # API callback interface
        │   │
        │   └── 📁 models/                # Data models for API responses
        │       ├── 📄 AuthResponse.java       # Authentication response
        │       └── 📄 EventsResponse.java     # Events statistics response
        │
        └── 📁 res/                       # Android resources
            ├── 📁 drawable/              # UI graphics and backgrounds
            │   ├── 📄 splash_background.xml      # Splash screen gradient
            │   ├── 📄 status_active_background.xml   # Active status badge
            │   ├── 📄 status_inactive_background.xml # Inactive status badge
            │   └── 📄 button_background.xml      # Button styling
            │
            ├── 📁 layout/                # UI layout files
            │   ├── 📄 activity_splash.xml        # Splash screen layout
            │   ├── 📄 activity_login.xml         # Login screen layout
            │   └── 📄 activity_main.xml          # Dashboard layout
            │
            └── 📁 values/                # App resources and styling
                ├── 📄 strings.xml                # All app text strings
                ├── 📄 colors.xml                 # Color definitions
                └── 📄 styles.xml                 # UI styles and themes
```

## 🎨 UI Components Overview

### 1. Splash Screen (`activity_splash.xml`)
- **Wazuh logo** with modern design
- **Loading animation** with animated dots
- **Gradient background** with brand colors
- **Auto-navigation** to login after 3 seconds

### 2. Login Screen (`activity_login.xml`)
- **Dynamic server configuration** input field
- **Username and password** form fields
- **Material Design** input components
- **Server URL validation** and storage
- **Clean, professional** layout

### 3. Dashboard (`activity_main.xml`)
- **Header section** with greeting and API status
- **Statistics cards** showing events and alerts
- **Agent monitoring** with real-time status
- **AI summary section** with OpenAI integration
- **High priority alerts** list
- **Bottom navigation** for app sections
- **Scrollable content** for mobile optimization

## 🔧 Technical Implementation

### Frontend Features (Ready to Use)
✅ **Complete UI Implementation**
- All screens designed and implemented
- Professional Wazuh branding
- Responsive design for mobile devices
- Material Design components

✅ **Navigation Flow**
- Splash → Login → Dashboard
- Proper activity transitions
- Back button handling

✅ **Data Storage**
- SharedPreferences for user settings
- Server URL and username persistence
- Login state management

### Backend Integration (Commented for Testing)
🔄 **API Services (Ready to Uncomment)**
- Wazuh API integration service
- OpenAI API service for AI summaries
- Proper error handling and callbacks
- Network request management

🔄 **Data Models**
- Authentication response handling
- Events and statistics parsing
- Agent status management
- Alert data structures

## 🚀 Getting Started

### For Frontend Testing (Current State)
1. Open project in Android Studio
2. Build and run the application
3. Test UI flow: Splash → Login → Dashboard
4. All backend calls are simulated

### For Full Integration
1. Follow the README.md integration guide
2. Uncomment API integration code
3. Configure Wazuh server endpoints
4. Add OpenAI API key
5. Enable internet permissions
6. Test with real data

## 📱 Screen Flow

```
[Splash Screen]
     ↓ (3 seconds)
[Login Screen]
     ↓ (successful login)
[Dashboard]
     ↓ (bottom navigation)
[Alerts] [Events] [Settings]
```

## 🎯 Key Features Implemented

### Security Monitoring
- Real-time event statistics
- Critical alert notifications
- Agent status monitoring
- API connectivity status

### AI Integration
- OpenAI-powered security summaries
- Threat analysis capabilities
- Incident response suggestions
- Intelligent alert prioritization

### User Experience
- Modern, professional design
- Intuitive navigation
- Responsive layout
- Loading states and animations

## 🔐 Security Considerations

### Current Implementation
- Input validation on login forms
- URL format validation
- Secure data storage preparation

### For Production (When Integrating APIs)
- HTTPS enforcement
- API key secure storage
- Token-based authentication
- Certificate pinning
- Network security configuration

## 📋 Next Steps

1. **Test Frontend**: Run the app to see the complete UI
2. **Review Code**: Examine the commented API integration code
3. **Configure APIs**: Follow README.md to enable backend integration
4. **Customize**: Modify colors, strings, or layouts as needed
5. **Deploy**: Build and distribute the application

---

**Status**: ✅ Frontend Complete | 🔄 Backend Ready for Integration

The application is fully functional for frontend testing and ready for backend API integration when needed.
