# resurfaceio-simulator
Simulate API calls and import into Resurface database

This open source Java utility generates simulated API calls (in [NDJSON format](https://resurface.io/json.html))
and sends these to a remote Resurface database. This command-line utility works with Resurface databases on Docker or Kubernetes.

[![License](https://img.shields.io/github/license/resurfaceio/simulator)](https://github.com/resurfaceio/simulator/blob/v3.5.x/LICENSE)
[![Contributing](https://img.shields.io/badge/contributions-welcome-green.svg)](https://github.com/resurfaceio/simulator/blob/v3.5.x/CONTRIBUTING.md)

## Usage

Download executable jar:
```
wget https://dl.cloudsmith.io/public/resurfacelabs/public/maven/io/resurface/resurfaceio-simulator/3.5.6/resurfaceio-simulator-3.5.6.jar
```

Run from command line:
```
java -DWORKLOAD=Coinbroker -DHOST=localhost -DPORT=7701 -DCLOCK_SKEW_DAYS=0 -DLIMIT_MESSAGES=0 -DLIMIT_MILLIS=0 -DSLEEP_PER_BATCH=0 -Xmx512M -jar resurfaceio-simulator-3.5.6.jar
```

## Environment Variables

```
WORKLOAD: workload implementation class
HOST: machine name for remote database
PORT: network port for remote database

CLOCK_SKEW_DAYS: default is '0' (none), rewind virtual clock & advance faster
LIMIT_MESSAGES: default is '0' (unlimited), quit after this many messages
LIMIT_MILLIS: default is '0' (unlimited), quit after this many milliseconds
SLEEP_PER_BATCH: default is '0' (none), pause in millis between batches
URL: override HOST and PORT with custom URL for remote database
```

## Available Workloads

* **Minimum** - empty calls with method, url and response code only (12 byte/call)
* **Coinbroker** (default) - REST and GraphQL calls with injected failures and attacks (500 byte/call average)
* **RestSmall** - REST calls with randomized url path, headers, and JSON bodies (2 KB/call average)
* **RestLarge** - REST calls with randomized url path, headers, and JSON bodies (8 KB/call average)

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
    <artifactId>resurfaceio-simulator</artifactId>
    <version>3.5.6</version>
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
