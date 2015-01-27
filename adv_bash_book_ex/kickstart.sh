#!/bin/sh
WAR_NAME=$(find /Users/zwang/dcmlui/dc/muse-dc-web/target | grep "\.war$")

if [ -z ${WAR_NAME} ]
then
    echo ".war file ${WAR_NAME} not exist"
    exit -1
else 
    echo ${WAR_NAME}
fi    
DATE_STRING=$( date "+%Y%m%d" )
echo ${DATE_STRING}

tail -f {DATE_STRING}.txt
