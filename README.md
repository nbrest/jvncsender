- Forked from: https://github.com/jsundqvist/jvncsender

## Build/Install new release version

```sh
./scripts/build-jvncsender.sh
```

## Run app from root directory

```sh
./scripts/run-jvncsender.sh
```

## Debug:

- In IntelliJ create a new run configuration for VncSenderMain.main() and set the necessary command line arguments

## Usage:

```sh
usage: java -jar jvncsender.jar options
Options:
 -host <hostname>            hostname or ip-address to send it to
 -port <port>                port to connect to f.i. 5900
 -password <password>        password to use
 -wait <seconds>             seconds to wait in between sending different texts (default=1s)
 -text <text>                text to send, (can be use multiple times)
 -mouseClick <clickParams>   [LEFT|RIGHT],positionX,positionY,numberOfClicks
 -help                       print this message
 -list                       list keymappings
```

## Create new release version

- On `dev` branch update `${RELEASE_VERSION}` in `<version>` in `pom.xml`, commit and push
- Then run in the command line:
```sh
export RELEASE_VERSION=X.XX
git checkout master
git merge master dev
git push origin master
git tag -a v${RELEASE_VERSION} -m "Release v${RELEASE_VERSION}"
git push origin v${RELEASE_VERSION}
git checkout dev
```

# Changelog:

#### v1.07

- Updated mouse click logic to a single command line parameter

#### v1.06

- Added support for right mouse click

#### v1.05

- Fixed left mouse click

#### v1.04

- Updated logback configuration to hide initial logback setup messages

#### v1.03

- Added logging framework and updated logging
- Moved packages to com.nicobrest.kamehouse for kamehouse logging filters to pickup
- Added initial left mouse click support
- Added build and run scripts

#### v1.02

- Fixed windows key press support

#### v1.01

- Added support for windows key press
- Updated target to Java 17
- Added some unit tests
- Updated maven plugin versions

#### v1.00

- Initial release after fork from https://github.com/jsundqvist/jvncsender

From original README.txt:
---------------------

Please note that jvncsender uses:

- http://www.tightvnc.com/
- http://www.jcraft.com/jsch/ (as it is used by tightvnc)
