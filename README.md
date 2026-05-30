# Firebase Authentication - MVVM Architecture (Jetpack Compose)

A modern Android authentication application built using **Kotlin**, **Jetpack Compose**, **Firebase Authentication**, and **MVVM Architecture** following Android development best practices.

## 🚀 Features

### Authentication

* User Registration with Email & Password
* User Login
* User Logout
* Authentication State Management
* Firebase Authentication Integration

### UI

* Jetpack Compose UI
* Material 3 Design
* Responsive Layouts
* State-Driven UI Updates
* Form Validation
* Error Handling & User Feedback

### Architecture

* MVVM (Model-View-ViewModel)
* Clean Separation of Concerns
* Unidirectional Data Flow
* Repository Pattern
* Dependency Injection with Hilt
* Lifecycle-Aware Components

---

## 🏗 Architecture Overview

The project follows the **MVVM Architecture Pattern** to ensure maintainability, scalability, and testability.

```text
Presentation Layer
│
├── Screens (Compose UI)
├── Components
└── ViewModels
        │
        ▼
Domain Layer
│
├── Use Cases
└── Business Logic
        │
        ▼
Data Layer
│
├── Repository
└── Firebase Auth Service
```

### Benefits

* Separation of Concerns
* Scalable Codebase
* Easier Maintenance
* Better Testability
* Improved Code Reusability
* Reduced Coupling
* Lifecycle-Aware State Management

---

## 📂 Project Structure

```text
com.example.firebaseauthmvvm
├── common
├── data
│   ├── repository
│   └── remote
│            └── auth
│
├── di (dependency injection)
│ 
├── domain
│   ├── usecase
│   ├── model
│   └── repository
│
├── presentation
│   ├── login
│   ├── register
│   ├── navigation
│   └── widgets
│
└── MainActivity.kt
```

---

## 🛠 Tech Stack

| Technology              | Purpose                   |
| ----------------------- | ------------------------- |
| Kotlin                  | Programming Language      |
| Jetpack Compose         | Modern UI Toolkit         |
| Firebase Authentication | User Authentication       |
| Hilt                    | Dependency Injection      |
| StateFlow               | Reactive State Management |
| Coroutines              | Asynchronous Programming  |
| Navigation Compose      | Navigation Management     |
| Material 3              | UI Design System          |

---

## 🎯 Key Engineering Principles

### MVVM Architecture

Separates UI, business logic, and data sources into independent layers.

### Scalability

Designed to easily add:

* Google Sign-In
* Phone Authentication
* Forgot Password
* Multi-Factor Authentication
* Backend APIs
* User Profiles

### Separation of Concerns

Each layer has a single responsibility:

* UI Layer → Displays data
* ViewModel → Handles UI logic
* Repository → Manages data sources
* Firebase Service → Authentication provider

### Dependency Injection

Hilt manages dependencies and improves:

* Testability
* Modularity
* Maintainability

### Reactive Programming

StateFlow ensures UI automatically reacts to state changes.

### Lifecycle Awareness

ViewModels survive configuration changes and prevent memory leaks.

### Error Handling

Centralized error management with meaningful user feedback.

### Clean Code Practices

* Single Responsibility Principle
* SOLID Principles
* Consistent Naming Conventions
* Reusable Components
* Modular Structure

---

## 🔐 Authentication Flow

```text
User Action
    │
    ▼
Compose Screen
    │
    ▼
ViewModel
    │
    ▼
UseCase
    │
    ▼
Repository
    │
    ▼
Firebase Authentication
    │
    ▼
StateFlow Update
    │
    ▼
UI Recomposition
```

---

## 🧪 Testability

Architecture is designed to support:

* Unit Testing
* Repository Testing
* ViewModel Testing
* Mock Firebase Services
* Dependency Injection Testing

---

## 📸 Screens

* Login Screen
* Register Screen

---

## Learning Outcomes

This project demonstrates:

* Modern Android Development
* MVVM Architecture
* Jetpack Compose
* Firebase Authentication
* Hilt Dependency Injection
* StateFlow & Coroutines
* Clean Architecture Principles
* Scalable Project Structure
* Production-Ready Code Organization

---

## ⭐ About
This project was built to showcase modern Android development practices using Jetpack Compose, Firebase Authentication, MVVM Architecture, Hilt, Coroutines, and StateFlow.
If you find this project useful, consider giving it a ⭐ on GitHub.

Focused on building scalable, maintainable, and production-ready mobile applications using modern Android architecture and development practices.
