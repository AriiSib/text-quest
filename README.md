# Java Developer's Quest

## Project Description
Java Developer's Quest is a project designed to help you become a proficient Java developer.
It offers various learning paths and challenges to enhance your programming skills and advance your career in software development.

## Technologies
- Java 21
- Maven
- JUnit 5
- Lombok
- Jakarta EE 10
- Apache Tomcat

## Installation and Running

### Prerequisites
- Java 21
- Tomcat 10.1.24
- Maven 3.9.6

### Clone the Repository
```sh
git clone https://github.com/AriiSib/text-quest.git
cd text-quest
```

## Setting Up Run Configuration in IntelliJ IDEA with Tomcat

### Install Apache Tomcat

Ensure Apache Tomcat 10.1.24 or later is installed on your machine. If not, download and install Tomcat from the [official Apache Tomcat website](https://tomcat.apache.org/).

### Configure Your Project in IntelliJ IDEA

1. Open IntelliJ IDEA and load your project.
2. Go to `File` -> `Project Structure` (or use `Ctrl+Alt+Shift+S`).
3. Under `Project Settings`, select `Facets`.
4. Click `+` and choose `Web`.
5. Select `Apache Tomcat`, specify the path to your Tomcat installation directory, and click `OK`.

### Add Tomcat Server to IntelliJ IDEA

1. Open `Run` -> `Edit Configurations...`.
2. Click `+`, choose `Tomcat Server` -> `Local`.
3. In the new configuration, fill in the following details:
   - **Name:** Enter a name for your configuration, e.g., `Text Quest Tomcat`.
   - **Deployment:** Click `+`, choose `Artifact` -> `text-quest:war`.
   - **Application Context:** Set it to `/text_quest_war`.
   - **Before launch:** Ensure `Build` -> `Build Artifacts` is selected.

### Run Your Application

1. Select your newly created run configuration from the dropdown list at the top-right corner of IntelliJ IDEA.
2. Click the green run button or use `Shift+F10` to start the project.

### Access Your Application

Once Tomcat is successfully launched in the IntelliJ IDEA console, open a web browser and go to:
````
(if you selected HTTP port 8080)
http://localhost:8080/text_quest_war/
````

These steps will help your users set up the run configuration for your application in IntelliJ IDEA.
