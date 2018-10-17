# TravellingON

A **serverless** application (**firebase(db & cloud functions)** + **react(client)**)

Helps travellers to go on a trip. Gives an ability to look through existing sights and add new ones. Also to join already suggested trips and suggest new ones.

---
# Server

The point of all this is to build a full stack application without a server. To do so I use **firebase database** and **cloud functions for firebase**.

According to the Firebase Realtime Database documentation:
> The Firebase Realtime Database is a cloud-hosted database. Data is stored as JSON and synchronized in realtime to every connected client. When you build cross-platform apps with our iOS, Android, and JavaScript SDKs, all of your clients share one Realtime Database instance and automatically receive updates with the newest data.

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

Sight entity consists of:
- name
- location
- description (optional)

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
