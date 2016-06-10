#!/bin/bash
#
# build-devicefarm.sh
#
# Builds a ZIP file of the Appium Python tests for use with AWS Device Farm.
# This should be run via ./appium-python/build-devicefarm.sh from the project root.
#
# Requirements:
#  - Python installed
#  - Virtualenv installed

# http://redsymbol.net/articles/unofficial-bash-strict-mode/
set -euo pipefail
IFS=$'\n\t'

# create virtualenv if it does not exist
cd appium-python
virtualenv env

# enter the virtualenv
# http://redsymbol.net/articles/unofficial-bash-strict-mode/#sourcing-nonconforming-document
set +u
source env/bin/activate
set -u

# install requirements and bundle in wheelhouse/
pip install -r requirements.txt
pip wheel --wheel-dir wheelhouse -r requirements.txt

# exit virtualenv
deactivate

# delete python cache files
find . -name '__pycache__' -type d -exec rm -r {} +
find . -name '*.pyc' -exec rm -f {} +
find . -name '*.pyo' -exec rm -f {} +
find . -name '*~' -exec rm -f {} +

# bundle the zip file
zip -r test_bundle.zip tests/ wheelhouse/ requirements.txt
