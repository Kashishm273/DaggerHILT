# DaggerHILT

## **INTRODUCTION**

Dependency injection is a technique widely used in programming and well suited to Android development. By following the principles of dependency injection, you lay the groundwork for a good app architecture.

Implementing dependency injection provides you with the following advantages:

* Reusability of code.
* Ease of refactoring.
* Ease of testing.


**Hilt** is an opinionated dependency injection library for Android that reduces the boilerplate of using manual DI in your project. Doing manual dependency injection requires constructing every class and its dependencies by hand and using containers to reuse and manage dependencies.
Hilt provides a standard way to do DI injection in your application by providing containers to every Android component in your project and managing the container's lifecycle automatically for you. This is done by leveraging the popular DI library: Dagger.

<br />

## **ABOUT THIS APP**

This is a sample application that uses Hilt as the DI library.
The application is very simple, it logs user interactions through multiple button clicks and uses Room to store that data to a local database. The user can see the logs of all the interactions with the app, and can even delete all the logs.
