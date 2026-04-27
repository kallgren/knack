# No babashka yet; npm scripts

Babashka would be the idiomatic Clojure choice for build/deploy task scripting, but `package.json` already exists for npm dependencies and the current task list (build, watch, test, deploy) is one-line shell each. Trigger to introduce `bb.edn`: when build/deploy logic outgrows shell strings — most likely candidate is the first localStorage → Drive migration script.
