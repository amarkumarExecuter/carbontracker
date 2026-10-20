Ye le bhai, poora text ekdum clean, perfectly formatted aur structured karke ek hi jagah de raha hoon. Isme "How the System Works" aur baaki saari headings ke formatting issues theek kar diye hain.

Ise **ek hi baar mein copy karke** apne `README.md` file mein paste kar le:

```markdown
# 🌱 Mission LiFE - Carbon Tracker & AI Sustainability Coach

A production-grade, polyglot-persistence carbon tracking web application built with **Java Spring Boot**, **MongoDB**, **H2 Database**, and **Groq AI**. Designed for environmental hackathons to promote sustainable lifestyle habits inspired by the *Mission LiFE* (Lifestyle for Environment) initiative[cite: 1, 3].

---

## 📋 Overview

Mission LiFE Carbon Tracker is an intelligent sustainability platform designed to monitor daily carbon emissions, track citizen energy consumption, and provide real-time AI guidance in near real time. The system is useful for green energy initiatives, urban sustainability planners, eco-conscious citizens, and hackathon evaluators who need fast awareness of environmental impact.

The platform helps answer a critical question: *"How much CO2 is emitted by daily transport or energy use, and how can citizens take immediate corrective action?"* By fusing structured transactional data with flexible activity logs and ultra-fast AI inference, the system produces actionable insights and gamified rewards to support sustainable lifestyle choices.

This system is built around an AI-powered sustainability workflow where:
- User activity data (transport, energy usage) is captured via an interactive dashboard[cite: 1, 3],
- Structured user profiles and eco-points are managed in an SQL database[cite: 1, 3],
- High-frequency activity logs are stored in a NoSQL cloud database[cite: 1, 3],
- Groq AI evaluates sustainability habits to provide instant expert advice[cite: 1, 3],
- The result is shown on a live web dashboard for easy monitoring and reward tracking[cite: 1, 3].

---

## 🚀 Key Features

The product provides a modern, operational dashboard with the following user-facing capabilities:
- **Real-time carbon telemetry** for transport and energy activities[cite: 1, 3]
- **Dynamic CO2 emission calculation** based on specific actions (Petrol Cars vs. Bicycles, Grid vs. Solar)[cite: 1, 3]
- **Gamified eco-points and tier upgrades** (from *Eco-Beginner* to *Eco-Warrior 🌿*)[cite: 1, 3]
- **AI Sustainability Coach** powered by Groq's ultra-fast LPU inference (`openai/gpt-oss-20b`)[cite: 1, 3]
- **Polyglot persistence architecture** combining SQL (H2) and NoSQL (MongoDB Atlas)[cite: 1, 3]
- **Embedded interactive frontend dashboard** for seamless single-page execution[cite: 1, 3]
- **Cloud-ready Docker containerization** deployed live on Render[cite: 1, 3]
- **RESTful API endpoints** for scalable backend communication[cite: 1, 3]

---

## 🏛️ System Architecture

```text
User
  │
  ▼
Interactive HTML/JS Frontend Dashboard
  │
  ▼ (REST API / JSON)
Spring Boot Backend Server (Port 8081 / Docker Container)
  ├──► Service Layer (Business Logic & Carbon Calculations)
  ├──► Spring Data JPA ──────► H2 Database (SQL: Users, Points & Badges)
  ├──► Spring Data MongoDB ──► MongoDB Atlas (NoSQL: Activity Logs)
  └──► RestTemplate ────────► Groq AI API (LPU Inference Engine)

```

The architecture follows a practical full-stack pipeline: the frontend sends activity requests to the backend, the backend computes carbon emissions, interacts with dual databases for persistence, queries Groq AI for coaching tips, and returns the response to the user interface for display.

---

## ⚙️ How the System Works

1. **Dashboard Access:** The user opens the web dashboard and lands on the interactive carbon tracking view.


2. **Activity Specification:** The user enters their User ID, selects an activity type (Transport or Energy), and specifies action details (e.g., Petrol Car, Public Bus, Bicycle, Electricity, Solar).


3. **Quantity Input:** The user inputs quantity (km or units) and clicks **"Calculate & Save Carbon"**.


4. **API Request:** The frontend sends the payload to the Spring Boot backend through REST API requests (`/api/carbon/add-activity`).


5. **Business Logic & Persistence:** The backend business logic calculates total CO2 emissions and awards corresponding eco-points. Structured user tier points are updated via Spring Data JPA in the H2 database, while detailed activity logs are persisted in MongoDB Atlas.


6. **AI Interaction:** For sustainability advice, the user types a query into the AI Coach box and clicks **"Ask Groq AI"**. The backend routes the query securely to the Groq AI API using `RestTemplate`, and the AI-generated recommendation is instantly rendered back onto the dashboard in real time.



---

## 🛠️ Technology Stack

| Technology / Library | Role in the Project |
| --- | --- |
| **Java** | Core programming language for enterprise backend logic |
| **Spring Boot** | Enterprise framework for building REST APIs and application structure

 |
| **Spring Data JPA** | ORM framework for managing structured SQL entities

 |
| **Spring Data MongoDB** | ODM framework for high-frequency NoSQL document storage

 |
| **H2 Database** | In-memory SQL database for transactional user profiles and points

 |
| **MongoDB Atlas** | Cloud NoSQL database for flexible activity logs

 |
| **Groq API (`openai/gpt-oss-20b`)** | Ultra-fast LPU inference engine for the AI Sustainability Coach

 |
| **HTML5 / CSS3 / JavaScript** | Modern, responsive frontend dashboard interface

 |
| **Maven Wrapper (`mvnw`)** | Build automation and dependency management tool

 |
| **Docker** | Containerization platform for consistent cloud deployment

 |
| **Render Cloud** | Cloud hosting platform for live public URL accessibility

 |

---

## 📂 Complete Project Structure

```text
carbontracker/
├── Dockerfile                  # Containerization config for Render deployment
├── pom.xml                     # Maven project dependencies and plugins
├── mvnw / mvnw.cmd             # Maven wrapper scripts
├── src/
│   ├── main/
│   │   ├── java/com/carbontracker/
│   │   │   ├── CarbonTrackerApplication.java  # Main Spring Boot entry point
│   │   │   ├── controller/                    # REST API controllers
│   │   │   ├── model/                         # Entity and Document models
│   │   │   ├── repository/                    # JPA and Mongo repositories
│   │   │   └── service/                       # Business logic & external API integration
│   │   └── resources/
│   │       ├── application.properties         # Database & environment configuration
│   │       └── static/
│   │           └── index.html                 # Single-page interactive frontend dashboard
└── README.md                   # Project documentation

```

---

## 📦 Installation and Setup

### 1. Clone the Repository

From your terminal, clone the project and enter the directory:

```bash
git clone [https://github.com/amarkumarExecuter/carbontracker.git](https://github.com/amarkumarExecuter/carbontracker.git)
cd carbontracker

```

### 2. Configure Properties

Open `src/main/resources/application.properties` and ensure your settings match:

```properties
server.port=8082

# H2 Database Settings
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# MongoDB Cloud URI
spring.data.mongodb.uri=mongodb+srv://itsamansingh6205_db_user:<PASSWORD>@missionlife-db.1u4txg8.mongodb.net/missionlife_mongo?retryWrites=true&w=majority

# Groq AI Key
groq.api.key=YOUR_GROQ_API_KEY
groq.api.url=[https://api.groq.com/openai/v1/chat/completions](https://api.groq.com/openai/v1/chat/completions)

```

### 3. Run the Application Locally

Using the Maven Wrapper, start the application:

```bash
./mvnw spring-boot:run

```

Open your web browser and navigate to: 👉 **http://localhost:8081**

---

## 💡 API Endpoints & Data Flow

The application exposes the following REST endpoints:

* `GET /api/carbon/test` — Verifies backend server connectivity


* `POST /api/carbon/register` — Registers a new user profile in SQL storage


* `POST /api/carbon/add-activity` — Logs activity data, computes CO2 emissions, and awards eco-points


* `POST /api/ai/chat` — Interacts with the Groq-powered AI Sustainability Coach



---

## 🎯 Environmental & Green Energy Impact

Supports green energy awareness campaigns and citizen engagement initiatives where individual behavioral change can aggregate into massive climate impact. It supports:

* Citizen carbon footprint tracking,


* Green energy adoption monitoring (Solar vs. Grid),


* Gamified sustainability incentives,


* AI-driven personalized eco-coaching.



---

## 🚀 Live Deployment

* **Live Application URL:** [https://carbontracker-q4zk.onrender.com](https://carbontracker-q4zk.onrender.com)

* **GitHub Repository:** [https://github.com/amarkumarExecuter/carbontracker](https://github.com/amarkumarExecuter/carbontracker)


```

```
