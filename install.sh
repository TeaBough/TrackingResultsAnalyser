#!/bin/sh

rm -rf bin
rm -rf lib
mkdir -p bin
mkdir -p lib

sbt clean
for name in "BounceRate" "FewBounceRatePages" "PopularPage" "SessionDurationVariation" "SessionsAverage" 
do
	echo "Create ${name,,} script"
	sed -i "4s/\"\(.*\)\"/\"${name}\"/" build.sbt
	sed -i "6s/\"\(.*\)\"/\"${name,,}\"/" build.sbt
	eval "sbt stage"
	cp target/universal/stage/bin/${name,,} bin/	
	cp target/universal/stage/lib/${name,,}* lib/	
done
cp target/universal/stage/lib/* lib/	

