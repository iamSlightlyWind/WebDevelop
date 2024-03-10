# WebDevelop

This repository contains schoolworks and the final project for the subject PRJ301 at FPT University. All projects are NetBeans web applications using Java Servlet and Apache Tomcat 10 server.

## Setup

To use the projects in this repository, follow these steps:

1. Clone the repository to your local machine.

```bash
$ git clone https://github.com/iamSlightlyWind/WebDevelop
```

2. Import the projects into your preferred Java IDE.

## Note
Notes
Ensure that you have Apache Tomcat 10 installed on your system.
If you intend to use the projects in Visual Studio Code, make sure to include the required JAR libraries and Apache Tomcat server libraries in your settings.json as follows:
```json
{
    "java.project.referencedLibraries": [
        "../Libraries/*.jar",
        "/usr/share/tomcat10/lib/*.jar"
    ]
}
```
Or as follow if you are on Windows:
```json
{
    "java.project.referencedLibraries": [
        "..\\Libraries\\*.jar",
        "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\lib\\*.jar"
    ]
}
```
