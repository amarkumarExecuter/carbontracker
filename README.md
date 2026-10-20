[![Watch Demo](https://img.shields.io/badge/🚀_Watch_Live_Demo-Click_Here-blue)](Aapka_YouTube_Video_Link_Yahan_Dalein)
# 🌱 Mission LiFE - Carbon Tracker & AI Sustainability Coach

A production-grade, polyglot-persistence carbon tracking web application built with **Java Spring Boot**, **MongoDB**, **H2 Database**, and **Groq AI**. Designed for environmental hackathons to promote sustainable lifestyle habits inspired by the *Mission LiFE* (Lifestyle for Environment) initiative.

---

## 🚀 Key Features

1. **Polyglot Persistence Architecture**:
   - **SQL (H2 Database)**: Securely manages structured user profiles, total eco-points, and gamification tiers.
   - **NoSQL (MongoDB Atlas)**: Stores flexible, high-frequency activity logs (transport, energy usage) in JSON format for lightning-fast reads/writes.
2. **Real-Time Carbon Footprint Calculator**: Computes CO2 emissions dynamically based on user activities (e.g., Petrol Cars vs. Bicycles, Grid Electricity vs. Solar).
3. **Gamification & Badges**: Rewards eco-friendly choices with points and upgrades user badges from *Eco-Beginner* to *Eco-Warrior 🌿*.
4. **AI Sustainability Coach (Powered by Groq AI)**: Integrated with Groq's ultra-fast LPU inference (`openai/gpt-oss-20b`) to provide instant, practical environmental advice and carbon reduction tips.
5. **Modern Interactive Dashboard**: Clean, responsive frontend embedded directly into Spring Boot for seamless single-page execution.

---

## 🛠️ Tech Stack

- **Backend**: Java Spring Boot, Spring Data JPA, Spring Data MongoDB, RESTful APIs
- **Databases**: 
  - H2 Database (In-memory SQL for transactional user data)
  - MongoDB Atlas (Cloud NoSQL for activity logs)
- **AI Integration**: Groq API (`openai/gpt-oss-20b` via `RestTemplate`)
- **Frontend**: HTML5, CSS3, Vanilla JavaScript (Fetch API)
- **Build Tool**: Maven Wrapper (`mvnw`)

---

## 🏛️ System Architecture & Database Schema

```text
[ Frontend Dashboard (HTML/JS) ]
          │
          ▼ (REST API / JSON)
[ Spring Boot Application (Port 8081) ]
    ├──► [ Service Layer (Business Logic & Carbon Calculations) ]
    ├──► [ Spring Data JPA ] ──────► [ H2 Database (SQL: Users & Points) ]
    ├──► [ Spring Data MongoDB ] ──► [ MongoDB Atlas (NoSQL: Activity Logs) ]
    └──► [ RestTemplate ] ────────► [ Groq AI API (LPU Inference Engine) ]
