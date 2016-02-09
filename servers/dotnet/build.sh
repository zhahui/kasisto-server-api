#!/usr/bin/env bash

if ! type dnvm > /dev/null 2>&1; then
    source /usr/local/lib/dnx/bin/dnvm.sh
fi

if ! type dnu > /dev/null 2>&1 || [ -z "$SKIP_DNX_INSTALL" ]; then
    dnvm install latest -runtime coreclr -alias default
    dnvm install default -runtime mono -alias default
else
    dnvm use default -runtime mono
fi

dnu restore src/Kasisto.API/ && \
    dnu build src/Kasisto.API/ && \
    dnu pack src/Kasisto.API/ --out artifacts && \
    echo "Now, run the following to start the project: dnx --project src/Kasisto.API/project.json web"