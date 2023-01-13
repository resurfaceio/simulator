# resurfaceio-ndjson-faker
Fake NDJSON generation utility

This open source Java utility dynamically generates fake API calls (in [NDJSON format](https://resurface.io/json.html))
and sends these to a remote Resurface database. This command-line utility works with Resurface databases on Docker or Kubernetes.

[![License](https://img.shields.io/github/license/resurfaceio/ndjson-faker)](https://github.com/resurfaceio/ndjson-faker/blob/v3.5.x/LICENSE)
[![Contributing](https://img.shields.io/badge/contributions-welcome-green.svg)](https://github.com/resurfaceio/ndjson-faker/blob/v3.5.x/CONTRIBUTING.md)

## Usage

Download executable jar:
```
wget https://dl.cloudsmith.io/public/resurfacelabs/public/maven/io/resurface/resurfaceio-ndjson-faker/3.5.1/resurfaceio-ndjson-faker-3.5.1.jar
```

Run from command line:
```
java -DWORKLOAD=Coinbroker -DHOST=localhost -DPORT=7701 -DLIMIT_MESSAGES=0 -DLIMIT_MILLIS=0 -DSATURATED_STOP=no -Xmx512M -jar resurfaceio-ndjson-faker-3.5.1.jar
```

## Available Workloads

* **Coinbroker** - (default) REST and GraphQL calls with injected failures and attacks
* **Minimum** - empty calls with method, url and response code only
* **RestSmall** - REST calls with randomized url path, headers, and JSON bodies (2KB/call average)

## Environment Variables

```
WORKLOAD: target workload implementation
HOST: machine name for remote database
PORT: network port for remote database

LIMIT_MESSAGES: default is '0' (unlimited), quit after this many messages
LIMIT_MILLIS: default is '0' (unlimited), quit after this many milliseconds
SATURATED_STOP: default is 'no', quit if database is saturated
URL: override HOST and PORT with custom URL for remote database
```

## Dependencies

* Java 17
* [DiUS/java-faker](https://github.com/DiUS/java-faker)
* [resurfaceio/ndjson](https://github.com/resurfaceio/ndjson)

## Installing with Maven

⚠️ We publish our official binaries on [CloudSmith](https://cloudsmith.com) rather than Maven Central, because CloudSmith
is awesome.

If you want to call this utility from your own Java application, add these sections to `pom.xml` to install:

```xml
<dependency>
    <groupId>io.resurface</groupId>
    <artifactId>resurfaceio-ndjson-faker</artifactId>
    <version>3.5.1</version>
</dependency>
```

```xml
<repositories>
    <repository>
        <id>resurfacelabs-public</id>
        <url>https://dl.cloudsmith.io/public/resurfacelabs/public/maven/</url>
        <releases>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </releases>
    </repository>
</repositories>
```

---
<small>&copy; 2016-2023 <a href="https://resurface.io">Resurface Labs Inc.</a></small>
