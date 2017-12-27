#!/bin/bash

sbt "++${TRAVIS_SCALA_VERSION}" "^^${SBT_VERSION}" publish docs/makeSite

mkdir _site
cd _site
git clone git@github.com:cirg-up/cilib.git --branch gh-pages --depth 1 .
git checkout --orphan newBranch
cp -R ../docs/target/site/* .
git add --all
git commit -a -m "Travis #$TRAVIS_BUILD_NUMBER update site"
git branch -D gh-pages
git branch -m gh-pages
git push --force origin gh-pages
