# DevFestDatabinding

Sample app for using the Android "Data Binding Library". It showcases a list of all Android Versions released to this date.
The app and usage of the "Data Binding Library" are up to date as of 5. November 2015.

## Presentation

The slides of my talk at GDG Devfest Hamburg about the Android "Data Binding Library" are available at:
https://mauin.github.io/DevFestDatabinding/

## Branches

The repository contains two branches.
`master` will contain the app with usage of the Databinding library.
`no-databinding` showcases the same application without usage of the library.

## Components

`WelcomeActivity` acts the entry point to the application with a simple start screen. Pressing the button leads to the list.

`VersionListActivity` contains the main list of the app, listing all Android Versions with some data about them.

`AddVersionActivity` showcases the usage of a ViewModel and how it can be connected to the UI with Databinding.
