#!/bin/bash

COL_BLUE="\033[1;34m"
COL_BOLD="\033[1m"
COL_CYAN="\033[1;36m"
COL_GREEN="\033[1;32m"
COL_NORMAL="\033[0;39m"
COL_PURPLE="\033[1;35m"
COL_RED="\033[1;31m"
COL_YELLOW="\033[1;33m"
COL_MESSAGE=${COL_GREEN}

SKIP_TESTS=true

main() {
  parseCmdLineArguments "$@"
  log.info "Started building jvncsender"
  if ${SKIP_TESTS}; then
    log.info "Skipping tests"
    mvn clean install -Dmaven.test.skip=true
  else
    mvn clean install
  fi
  log.info "Finished building jvncsender"
}

log.info() {
  local ENTRY_DATE="${COL_CYAN}$(date +%Y-%m-%d' '%H:%M:%S)${COL_NORMAL}"
  local LOG_MESSAGE=$1
  echo -e "${ENTRY_DATE} - [${COL_BLUE}INFO${COL_NORMAL}] - ${COL_MESSAGE}${LOG_MESSAGE}${COL_NORMAL}"
}

log.error() {
  local ENTRY_DATE="${COL_CYAN}$(date +%Y-%m-%d' '%H:%M:%S)${COL_NORMAL}"
  local LOG_MESSAGE=$1
  echo -e "${ENTRY_DATE} - [${COL_RED}ERROR${COL_NORMAL}] - ${COL_RED}${LOG_MESSAGE}${COL_NORMAL}"
}

parseCmdLineArguments() {
  while getopts ":ht" OPT; do
    case $OPT in
    ("h")
      printHelpMenu
      exit 0
      ;;
    ("t")
      SKIP_TESTS=false
      ;;
    (\?)
      log.error "Invalid argument $OPTARG"
      exit 1
      ;;
    esac
  done
}

printHelpMenu() {
  echo -e ""
  echo -e "Usage: ${COL_PURPLE}build-jvncsender.sh${COL_NORMAL} [options]"
  echo -e ""
  echo -e "  Options:"
  echo -e "     ${COL_BLUE}-h${COL_NORMAL} display help"
  echo -e "     ${COL_BLUE}-t${COL_NORMAL} run tests. skips them by default"
}

main "$@"
