# QuickChat - Part 2

## Student Information
- Name: Nizaam
- Project: QuickChat
- Language: Java
- IDE: Apache NetBeans

---

# Project Description

QuickChat is a Java console-based messaging application that allows users to:

- Register an account
- Login using stored credentials
- Send messages
- Store messages
- Disregard messages
- View total messages sent
- Save user and message data using JSON

The application was developed for Part 2 of the programming assignment.

---

# Features Implemented

## User Registration
Users can register with:
- Username
- Password
- South African cellphone number
- First name
- Last name

Validation includes:
- Username must contain "_"
- Username max length = 5 characters
- Password must contain:
  - Capital letter
  - Number
  - Special character
  - Minimum 8 characters
- Cellphone number must use South African international format

---

# Login System

Users can:
- Login using stored credentials
- Retry login if credentials are incorrect

User details are stored in:
```text
users.json
