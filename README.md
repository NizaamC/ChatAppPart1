# QuickChat - Part 3

## Student Information

* Name: Nizaam
* Project: QuickChat
* Language: Java
* IDE: Apache NetBeans

---

# Project Description

QuickChat is a Java console-based messaging application that allows users to register, log in, send messages, store messages, disregard messages, and generate reports. User and message information is persisted using JSON files.

The application was developed across Part 1, Part 2, and Part 3 of the programming assignment.

---

# Features Implemented

## User Registration

Users can register with:

* Username
* Password
* South African cellphone number
* First name
* Last name

Validation includes:

* Username must contain "_"
* Username maximum length = 5 characters
* Password must contain:

  * Uppercase letter
  * Number
  * Special character
  * Minimum 8 characters
* Cellphone number must contain the South African international code (+27)

---

## Login System

Users can:

* Login using stored credentials
* Retry login if credentials are incorrect

User details are stored in:

users.json

---

## Message System

Users can:

* Send messages
* Store messages for later
* Disregard messages
* View total messages sent

Each message contains:

* Message ID
* Message Hash
* Recipient Number
* Message Text

---

## Message Validation

The application validates:

### Message Length

* Maximum 250 characters

Success Message:

Message ready to send.

Failure Message:

Message exceeds 250 characters by X; please reduce the size.

### Recipient Number

The recipient number must:

* Start with +27
* Contain the correct number of digits

---

## Message Hash

A unique hash is automatically generated using:

* First two digits of Message ID
* Message number
* First word of the message
* Last word of the message

Example:

00:0:HITONIGHT

---

## JSON Storage

The application stores data using JSON files:

### users.json

Stores:

* Username
* Password
* User details

### messages.json

Stores:

* Message ID
* Message Hash
* Recipient
* Message Content
* Message Status

---

## Part 3 Features

The following arrays are implemented:

* Sent Messages
* Stored Messages
* Disregarded Messages
* Message Hashes
* Message IDs

Users can:

* Display stored messages
* Display sender and recipient details
* Display the longest stored message
* Search by Message ID
* Search by Recipient
* Delete messages using Message Hash
* Display message reports

---

## Reports

The application can generate reports displaying:

* Message Hash
* Recipient
* Message Contents

for all sent messages.

---

## Unit Testing

JUnit tests were created for:

* Username validation
* Password validation
* Phone number validation
* Message length validation
* Message ID generation
* Message Hash generation
* Recipient validation
* Message actions

---

## Technologies Used

* Java
* Apache NetBeans
* JSON Simple
* JUnit
* Git
* GitHub

---

## Running the Application

1. Open the project in Apache NetBeans.
2. Build the project.
3. Run Main.java.
4. Register or log in.
5. Use the menu options to manage messages.

---

## Repository

GitHub Repository:

https://github.com/NizaamC/ChatAppPart1

---

## Author

Nizaam
