- Forked from: https://github.com/jsundqvist/jvncsender

## Build/Install new release version

```sh
./scripts/build-jvncsender.sh
```

## Run app from root directory

```sh
./scripts/run-jvncsender.sh
```

## Usage:

```sh
usage: ./scripts/run-jvncsender.sh [-list] [-help] -host <hostname> -port <port> -text <text> -mouseClick <x,y,clickCount> [-password <password>] [-wait <seconds>]
-help                        print this message
-host <hostname>             hostname or ip-address to send it to
-list                        list keymappings
-password <password>         password to use
-port <port>                 port to connect to f.i. 5900
-text <text>                 text to send, (can be use multiple times)
-mouseClick <x,y,clickCount> mouse click to send with the specified position and click count
-wait <seconds>              seconds to wait in between sending different texts (default=1s)
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
