# TravellingON

A **serverless** application (**firebase(db & cloud functions)** + **react(client)**)

Helps travellers to go on a trip. Gives an ability to look through existing sights and add new ones. Also to join already suggested trips and suggest new ones.

You can find "vision and scope" and "requirements" documents under `/documentation`.

You can find wireframes under `/documentation/mockups`.
You can find mockups under `/documentation/mockups`.
You can find clickable prototype made with InVision under `/documentation`.

---
# Server

The point of all this is to build a full stack application without a server. To do so I use **firebase database** and **cloud functions for firebase**.

### Database
According to the Firebase Realtime Database documentation:
> The Firebase Realtime Database is a cloud-hosted database. Data is stored as JSON and synchronized in realtime to every connected client. When you build cross-platform apps with our iOS, Android, and JavaScript SDKs, all of your clients share one Realtime Database instance and automatically receive updates with the newest data.

Sight entity consists of:
- name
- location
- description (optional)

Trip entity consists of:
- sight
- date
- list of members

### Cloud Functions
According to the Firebase Cloud Function documentation:
> Cloud Functions for Firebase let’s you automatically run backend code in response to events triggered by Firebase features and HTTPS requests. Your code is stored in Google’s cloud and runs in a managed environment. There’s no need to manage and scale your own servers.

The serverless part is located under `/server` and has the following endpoints:
* *insertSight*
  * POST;
  * body must have name and location, description is optional;
  * adds a new sight;
  * returns all existing sights 
  * URL - `https://us-central1-  travellingon-922b0.cloudfunctions.net/insertSight`
  
* *deleteSight*
  * DELETE;
  * query must have id;
  * deletes sight by given id;
  * returns all existing sights 
  * URL - `https://us-central1-travellingon-922b0.cloudfunctions.net/deleteSight?id=${sightId}`
  
* *selectAllSights*
  * GET;
  * returns all existing sights 
  * URL - `https://us-central1-travellingon-922b0.cloudfunctions.net/selectAllSights`
  
* *selectSightsByName*
  * GET;
  * query must have name;
  * returns sights with name equal or name includes the given name
  * URL - `https://us-central1-travellingon-922b0.cloudfunctions.net/selectSightsByName?name=${sightName}`
  
* *updateSight*
  * POST;
  * query must have id;
  * body can have name, location, description (at least one is required);
  * updates a sight with given id with new values;
  * returns all existing sights 
  * URL - `https://us-central1-travellingon-922b0.cloudfunctions.net/updateSight?id=${sightId}`

---
# Client
I use **React** to build a client that will make use of these endpoints and persist to a database.

According to Wikipedia:
> In computing, React is a JavaScript library for building user interfaces. It is maintained by Facebook and a community of individual developers and companies. React can be used as a base in the development of single-page or mobile applications.

All the code is located under `/client`.

---
# Design principles
I want to make my designs more understandable, flexible and maintainable. Unfortunately due to a serverless architecture I cannot use SOLID or GRASP (object-oriented designs).

My using of JS (an interpreted programming language) for cloud functions and client allows me though to write my code according to **Single-responsiblity principle** (**S**OLID).

Also I am following the **DRY** (Don't repeat yourself) principle to reduce repetition and to avoid redundancy in my code.

---
# Resilency
I have each cloud function timeout set to 60s. 
Also some errors are thrown manually:
- insertSight - when no name or location (or both) are found in request body;
- deleteSight - when no id to delete by is specified;
- selectSightsByName - when no name to search by is specified;
- updateSight - when no id to update by is specified; when no new values for an update found.

I handle these errors on client side. I have a message text-danger paragraph I use to display error messages to a user.

You can find the model under `/documentation`.

---
# Security
I use Firebase Authentication and FirebaseUI library to provide authentication and authorization along with some UI flows.

According to the Firebase Authentication documentation:
> Firebase Authentication provides backend services, easy-to-use SDKs, and ready-made UI libraries to authenticate users to your app. It supports authentication using passwords, phone numbers, popular federated identity providers like Google, Facebook and Twitter, and more.

> Firebase Authentication integrates tightly with other Firebase services, and it leverages industry standards like OAuth 2.0 and OpenID Connect, so it can be easily integrated with your custom backend.

According to the FirebaseUI documentation:
> FirebaseUI is a library built on top of the Firebase Authentication SDK that provides drop-in UI flows for use in your app.

For now I use just email/password provider. I may also add Google and GitHub providers in the nearest future.

You can add new sights and update the existing ones just after you are logged in.

---
# Monitoring
Firebase provides the ability to monitor both database and cloud functions.

For DB (for last 30 days):
- connections (the number of simultaneous realtime connections to the database);
- storage (how much data is stored in the database);
- downloads (downloads account for all bytes downloaded from the database, including connection protocol and SSL encryption overhead, over 1-min interval);
- load (the percentage of the database that's busy processing requests over 1-min interval).

For cloud functions:
- health (for last 30 days):
  * total errors;
  * error groups;
- logs (for last 7 days) - both error and info levels;
- usage (for last 30 days) - total function invocations.

You can find the model and some screenshots under `/documentation`.

---
# Telemetry
Some KPI is provided by Firebase Authentication:
- user identifier;
- providers;
- when user was created;
- when user last logged in;
- user UID.

For the rest I use Google Analytics.

You can find the model and some screenshots under `/documentation`.
