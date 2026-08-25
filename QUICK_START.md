# Quick start

## Get the repository

1. Fork this repository on GitHub to your own account.
2. Clone *your fork* (not the course repository):

```sh
git clone https://github.com/<your-username>/SweetHomeMockInternship.git
cd SweetHomeMockInternship
```

Work and commit in your fork for the rest of the internship. Do not push to
the upstream course repository.

## Prerequisites

- JDK 11 (recommended; JDK 8 is also supported)
- Maven 3.6 or newer
- A graphical desktop for launching the application

Check the tools available on your machine:

```sh
java -version
mvn -version
```

Both commands should report the same JDK family. If Maven reports a different
or newer JDK, set `JAVA_HOME` to a JDK 8 or 11 installation before continuing.

## Build and smoke test

Run these commands from the repository root:

```sh
mvn -DskipTests package
mvn -Dtest=BuildSmokeTest test
```

The first command compiles the legacy application and creates
`target/sweet-home-3d-internship-5.4-internship.jar`. The second runs a small
headless test that passes before any feature work.

The first Maven run may download Maven's compiler and test plugins plus JUnit.
The obsolete application libraries are already included in this repository.

## Launch

From a graphical terminal at the repository root, run:

```sh
mvn compile exec:java
```

The 3D panel is intentionally disabled in this exercise, which avoids native
Java 3D setup on lab machines. A successful launch looks like this:

![Sweet Home 3D running](images/sweethome.png)

Sweet Home 3D also supports a 3D mode, but it is disabled for this exercise to
avoid native Java 3D setup on student and lab machines. It is not required or
assessed, but you may explore it if interested:

![Sweet Home 3D with the 3D view enabled](images/sweethome3d.png)

The bottom-right panel shows the 3D view of the floor plan.

Stop the application by closing its window. Then save a screenshot as
`submissions/task1-running.png`.

## Run the feature tests

```sh
mvn test
```

On the starter code, the smoke test passes and the feature tests fail with
messages for Tasks 2–4. This is expected. Re-run the tests as you work until
all tests pass.

## IDE setup

Open the repository root as an existing Maven project. IntelliJ IDEA, Eclipse,
and VS Code should import `pom.xml`; do not configure source folders or JARs by
hand. If prompted for a project SDK, choose JDK 8 or 11.

## Troubleshooting

- `release version 8 not supported`: Maven is using a JDK older than 8.
- Compilation errors mentioning APIs removed after Java 11: switch the Maven
  runtime to JDK 11.
- No window appears: make sure you ran the launch command in a graphical
  session, not a headless SSH session. Use a lab desktop if necessary.
- Maven cannot download plugins or JUnit: connect to the network once, or run
  on a lab machine with the course Maven cache.
- To discard only generated build output, run `mvn clean`. It does not remove
  source files or screenshots.
